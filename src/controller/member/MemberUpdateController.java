package controller.member;

import java.awt.event.ActionEvent;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controller.Controller;
import model.dao.MemberDAO;
import model.vo.Member;
import view.View;
import view.member.MemberUpdateView;

public class MemberUpdateController extends Controller {
    
    MemberUpdateView pwdUpdateView;

    protected MemberUpdateController(Controller controller, String id) {
        super(controller, MemberUpdateView.class, id);
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
        pwdUpdateView = (MemberUpdateView) windowView;
        pwdUpdateView.btnReset.addActionListener(this);
        pwdUpdateView.btnSubmit.addActionListener(this);
    }
    
    @Override
    protected void resume() {
        Member member = new model.dao.MemberDAO().selectWithId(getArgs(0));
        if( member==null) {
            JOptionPane.showMessageDialog(pwdUpdateView,"계정정보 쿼리 실패!");
            finish();
        }
        pwdUpdateView.tfId.setText(member.getId());
        pwdUpdateView.tfEmail.setText(member.getEmail());
        pwdUpdateView.tfName.setText(member.getName());
    }

    private void showMsgWithResetText(JTextField tf, String msg) {
        pwdUpdateView.showMsg(msg);
        tf.setText("");
        tf.requestFocus();
    }
}
