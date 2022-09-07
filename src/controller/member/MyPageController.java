package controller.member;

import java.awt.event.ActionEvent;
import controller.Controller;
import view.View;
import view.member.MyPageView;

public class MyPageController extends Controller {

    MyPageView viewMyPage;
    
    public MyPageController(Controller controller, String id) {
        super(controller, MyPageView.class, id);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object s = e.getSource();
        if (s == viewMyPage.btnBack) {
            finish();
        } else if (s == viewMyPage.btnLogout) {
            viewMyPage.setVisible(false);
           // viewLogin.setVisible(true);
        } else if (s == viewMyPage.btnUpdate) {
            //Member m = new MemberDAO().selectMemberInfo(userId);
           // viewPwdUpdate.tfId.setText(m.getId());
           // viewPwdUpdate.tfName.setText(m.getEname());
           // viewPwdUpdate.tfEmail.setText(m.getEmail());
           // viewPwdUpdate.tfPwd.setText("");
           // viewPwdUpdate.tfPwd2.setText("");
           // viewPwdUpdate.tfPwd.requestFocus();
            viewMyPage.setVisible(false);
           // viewPwdUpdate.setVisible(true);
        }else if (s == viewMyPage.btnHistory) {

            viewMyPage.setVisible(false);
           // viewHistory.setVisible(true);
        }else if (s == viewMyPage.btnCash) {
            //Member m = new MemberDAO().selectMypage(userId);
            //viewCash.la_nowcash.setText("현재 캐시: " + m.getCash()+"원");
            //viewCash.tf_cash.setText("");
            //viewCash.tf_cash.requestFocus();
            viewMyPage.setVisible(false);
            //viewCash.setVisible(true);
        }
    }


    @Override
    protected void create(View windowView) {
        viewMyPage = (MyPageView) windowView;
        viewMyPage.btnBack.addActionListener(this);
        viewMyPage.btnLogout.addActionListener(this);
        viewMyPage.btnUpdate.addActionListener(this);
        viewMyPage.btnHistory.addActionListener(this);
        viewMyPage.btnCash.addActionListener(this);
        viewMyPage.labelMsg.setText(getArgs(0) + "님 환영합니다.");
    }

    @Override
    protected void resume() {
        super.resume();
        model.vo.Member m = new model.dao.MemberDAO().selectMypage("회원 ID: " +getArgs(0));
        //viewBookPay.labelId.setText(m.getId());
        //viewBookPay.labelGrade.setText("회원 등급: "+grade[m.getGrade()-1]);
        //viewBookPay.labelPoint.setText("회원 포인트: "+m.getPoint()+"P");
    }
}
