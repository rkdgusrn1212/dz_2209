package controller.member;

import java.awt.event.ActionEvent;
import controller.Controller;
import model.dao.MemberDAO;
import model.vo.Member;
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
            new MemberUpdateController(this, getArgs(0));
        }else if (s == viewMyPage.btnEditBook) {
        	
        }else if (s == viewMyPage.btnCash) {
        	new CashController(this);
            //Member m = new MemberDAO().selectMypage(id);
            //viewCash.la_nowcash.setText("보유 캐시: " + m.getCash()+"원");
            //viewCash.tf_cash.setText("");
            //viewCash.tf_cash.requestFocus();
            //viewCash.setVisible(true);
        }
    }


    @Override
    protected void create(View windowView) {
        viewMyPage = (MyPageView) windowView;
        viewMyPage.btnBack.addActionListener(this);
        viewMyPage.btnLogout.addActionListener(this);
        viewMyPage.btnUpdate.addActionListener(this);
        viewMyPage.btnEditBook.addActionListener(this);
        viewMyPage.btnCash.addActionListener(this);
        viewMyPage.labelMsg.setText(getArgs(0) + "의 MyPage");
    }

    @Override
    protected void resume() {
        super.resume();
        
    }
}
