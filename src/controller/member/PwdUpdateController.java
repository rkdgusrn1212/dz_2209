package controller.member;

import java.awt.event.ActionEvent;
import java.util.regex.Pattern;

import javax.swing.JTextField;

import controller.Controller;
import model.dao.MemberDAO;
import view.View;
import view.member.PwdUpdateView;

public class PwdUpdateController extends Controller {
    
    PwdUpdateView pwdUpdateView;

    protected PwdUpdateController(Controller controller, String id) {
        super(controller, PwdUpdateView.class, id);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object s = e.getSource();
        if(s == pwdUpdateView.btnReset) {
            finish();
        }else if(s == pwdUpdateView.btnSubmit) {
            String pwd = new String(pwdUpdateView.tfPwd.getPassword());
            //패스워드 검사.
            if(pwd.length()<1) {
                showMsgWithResetText(pwdUpdateView.tfPwd, "비밀번호가 비어있습니다.");
                return;
            }
            if(!Pattern.matches(Regex.PASSWORD,pwd)) {
                pwdUpdateView.tfPwdConfirm.setText("");
                showMsgWithResetText(pwdUpdateView.tfPwd, Regex.PASSWORD_WARN);
                return;
            }
            //패스워드 재확인 검사.
            String pwdConfirm = new String(pwdUpdateView.tfPwdConfirm.getPassword());
            if(pwdConfirm.length()<1) {
                showMsgWithResetText(pwdUpdateView.tfPwdConfirm, "비밀번호를 한번 더 입력해주세요.");
                return;
            }
            if(!pwd.equals(pwdConfirm)) {
                pwdUpdateView.tfPwdConfirm.setText("");
                showMsgWithResetText(pwdUpdateView.tfPwd,"입력한 패스워드가 서로 다릅니다.\n다시 입력해 주십시오.");
                return;
            }
            new MemberDAO().updatePwd(getArgs(0), pwd);
            finish();
        }
    }

    @Override
    protected void create(View windowView) {
        pwdUpdateView = (PwdUpdateView) windowView;
        pwdUpdateView.btnReset.addActionListener(this);
        pwdUpdateView.btnSubmit.addActionListener(this);
    }

    private void showMsgWithResetText(JTextField tf, String msg) {
        pwdUpdateView.showMsg(msg);
        tf.setText("");
        tf.requestFocus();
    }
}
