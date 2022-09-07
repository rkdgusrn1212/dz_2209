package controller.book;

import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import controller.Controller;
import controller.member.LoginController;
import controller.member.MyPageController;
import view.View;
import view.book.BookSelectView;

public class BookSelectController extends Controller {

    private BookSelectView viewBookSelect;
    private int selectedBook;

    public BookSelectController(Controller controller, String id) {
        super(controller, BookSelectView.class,  id);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object s = e.getSource();
        if (s == viewBookSelect.btnLogout) {
            finish();
            new LoginController(null);
        } else if (s == viewBookSelect.btnGenre) {
            // viewBookGenre.setVisible(true);
        }else if (s == viewBookSelect.btnMyPage) {// 마이페이지로 이동
            new MyPageController(this, getArgs(0));
        }else if(s==viewBookSelect.btnSelect){
            new BookController(this);
        }
    }
    @Override
    protected void create(View windowView) { 
        viewBookSelect = (BookSelectView) windowView;
        viewBookSelect.labelId.setText(getArgs(0) + "님");
        viewBookSelect.btnLogout.addActionListener(this);
        viewBookSelect.btnGenre.addActionListener(this);
        viewBookSelect.btnSelect.addActionListener(this);
        viewBookSelect.btnMyPage.addActionListener(this);
        for (int i = 0; i < viewBookSelect.viewBookClick.length; i++) {
            viewBookSelect.viewBookClick[i].tglBtnImage.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseReleased(MouseEvent e) {
                    boolean flag = false; // toggle button이 선택되었는지 여부를 확인하는 변수
                    for (int i = 0; i < viewBookSelect.viewBookClick.length; i++) {
                        viewBookSelect.viewBookClick[i].taContent.setVisible(false);
                    }
                    /*--------------------toggle button 체크 확인------------------*/
                    for (int i = 0; i < viewBookSelect.viewBookClick.length; i++) {
                        if (viewBookSelect.viewBookClick[i].tglBtnImage.isSelected()) {
                            flag = true;
                            selectedBook = i;
                            viewBookSelect.viewBookClick[i].taContent.setVisible(true);
                        }
                    }

                    /*--------------------toggle button 체크 여부에 따라 setEnabled() 호출 ------------------*/
                    if (!flag) {
                        for (int j = 0; j < viewBookSelect.viewBookClick.length; j++) {
                            viewBookSelect.viewBookClick[j].tglBtnImage.setEnabled(true);
                        }
                    } else {
                        for (int j = 0; j < viewBookSelect.viewBookClick.length; j++)
                            if (selectedBook != j) {
                                viewBookSelect.viewBookClick[j].tglBtnImage.setEnabled(false);
                            }
                    }
                    System.out.println("selected_book : " + selectedBook);
                }// mouseReleased
            });// v_schedule.v_sd[i].addMouseListener
        } // for
    }


    public void setClickBookText(int i, boolean flag) {
        viewBookSelect.viewBookClick[i].labelName.setVisible(flag);
        viewBookSelect.viewBookClick[i].labelWriter.setVisible(flag);
        viewBookSelect.viewBookClick[i].labelPrice.setVisible(flag);
    }
}
