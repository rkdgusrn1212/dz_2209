package controller.member;

import java.awt.event.ActionEvent;
import controller.Controller;
import controller.admin.AdminController;
import controller.book.BookSelectController;
import model.dao.MemberDAO;
import view.View;
import view.member.LoginView;
/**
 * start -> finish의 라이프 사이클을 가진다.
 * @author 강현구
 *
 */
public class LoginController extends Controller{

    private LoginView viewLogin;
    public LoginController(Controller controller) {
        super(controller, LoginView.class);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object s = e.getSource();
        if(s==viewLogin.btnLogin) {
            String id = viewLogin.tfId.getText();
            String pass = new String(viewLogin.tfPwd.getPassword());
            if (id.equals("admin") && pass.equals("manager")) {// 1-1 관리자 로그인
                viewLogin.showMsg("관리자 로그인 성공!!");
                new AdminController(null);
                return;
            }

            if ((new MemberDAO().loginCheck(id, pass))) { // 1.로그인 성공!
                viewLogin.showMsg(id + "님 환영합니다 ^_^");
                new BookSelectController(null, id);
                finish();
            } else {
                viewLogin.showMsg("아이디 또는 비밀번호를 확인해주세요!");
                viewLogin.tfId.setText("");
                viewLogin.tfId.requestFocus();
                viewLogin.tfPwd.setText("");
            }
        }else if(s == viewLogin.btnJoin) {
            new JoinController(this);
        }else if(s == viewLogin.btnFindIdPw) {
            new FindIdPwdController(this);
        }
    }
    @Override
    protected void create(View windowView) {
        viewLogin = (LoginView)windowView;
        viewLogin.btnLogin.addActionListener(this);
        viewLogin.btnJoin.addActionListener(this);
        viewLogin.btnFindIdPw.addActionListener(this);
    }
}
