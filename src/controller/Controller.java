package controller;

import java.awt.event.ActionListener;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import view.View;

public abstract class Controller implements ActionListener, WindowListener{

    private Controller parentController;
    private String[] args;
    private View windowView;//컨트롤러가 붙은 뷰.

    //이전 컨트롤러와 사용할 뷰 쓰일 인자를 전달함.
    protected Controller(Controller controller, Class viewClass, String... args){
        parentController = controller;
        this.args = args;
        try {
            windowView = (View) viewClass.getConstructor().newInstance();
        } catch (Exception e) {
            System.out.println("윈도우 뷰 생성에 실패.");
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        start();
    }
    
    protected String getArgs(int idx) {
        return args[idx];
    }


    //뷰가 새로 생성되서 맨 위에 뜸.
    private void start() {
        windowView.addWindowListener(this);
        create(windowView);
        if(parentController!=null) {
            parentController.stop();
        }
        resume();
    }
    //뷰를 생성하는 부분
    protected abstract void create(View windowView);
    
    //사용자 입력을 받기 시작할때 호출
    //리스너 등록. 뷰 가시성 켜기.
    protected void resume() {
        System.out.println("화면 출력");
        windowView.setVisible(true);
    }

    //더이상은 사용자 입력을 받지 않을때 호출
    //위에 또다른 뷰가 떠서 사용자 입력을 못받는 경우
    //리스너제거 뷰 가시성 끄기.
    protected void stop() {
        System.out.println("화면 닫힘");
        windowView.setVisible(false);
    }
    
    //아예 view가 사라짐
    //자식클래스는 super를 맨 끝에 호출해야 한다.
    protected void finish() {
        stop();
        windowView.dispose();
        if(parentController!=null) {
            parentController.resume();
        }
    }
    

    @Override
    public void windowClosing(WindowEvent e) {
        System.out.println("close window");
        /*
         * 프로그램 강제종료 로직.
         */
    }

    @Override
    public void windowOpened(WindowEvent e) {
    }


    @Override
    public void windowClosed(WindowEvent e) {
    }


    @Override
    public void windowIconified(WindowEvent e) {
        // TODO Auto-generated method stub

    }


    @Override
    public void windowDeiconified(WindowEvent e) {
        // TODO Auto-generated method stub

    }


    @Override
    public void windowActivated(WindowEvent e) {
        // TODO Auto-generated method stub

    }


    @Override
    public void windowDeactivated(WindowEvent e) {
        // TODO Auto-generated method stub
    }
}