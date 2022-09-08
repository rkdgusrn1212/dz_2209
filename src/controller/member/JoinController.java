package controller.member;


import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.util.regex.Pattern;

import javax.swing.JTextField;

import controller.Controller;
import model.dao.MemberDAO;
import model.vo.Member;
import view.View;
import view.member.JoinView;
public class JoinController extends Controller{
    
    JoinView viewJoin;

    JoinController(Controller controller){
        super(controller, JoinView.class);
    }

    @Override
    protected void create(View windowView) {
        viewJoin = (JoinView) windowView;
        viewJoin.tfId.setText("");
        viewJoin.tfName.setText("");
        viewJoin.tfPwd.setText("");
        viewJoin.tfPwdConfirm.setText("");
        viewJoin.tfEmail.setText("");
        viewJoin.btnSubmit.addActionListener(this);
        viewJoin.btnReset.addActionListener(this);
    }

    @Override
    protected void resume() {
        super.resume();
        viewJoin.tfId.requestFocus();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object s = e.getSource();
        if(s==viewJoin.btnReset) {
            finish();
        }else if(s == viewJoin.btnSubmit) {
            //ID 검사
            String id = viewJoin.tfId.getText();
            if(id.length()<1) {
                showMsgWithResetText(viewJoin.tfId, "ID가 비어있습니다.");
                return;
            }
            if(!Pattern.matches(Regex.ID, id)) {
                showMsgWithResetText(viewJoin.tfId, Regex.ID_WARN);
                return;
            }
            String pwd = new String(viewJoin.tfPwd.getPassword());
            //패스워드 검사.
            if(pwd.length()<1) {
                showMsgWithResetText(viewJoin.tfPwd, "비밀번호가 비어있습니다.");
                return;
            }
            if(!Pattern.matches(Regex.PASSWORD,pwd)) {
                viewJoin.tfPwdConfirm.setText("");
                showMsgWithResetText(viewJoin.tfPwd, Regex.PASSWORD_WARN);
                return;
            }
            //패스워드 재확인 검사.
            String pwdConfirm = new String(viewJoin.tfPwdConfirm.getPassword());
            if(pwdConfirm.length()<1) {
                showMsgWithResetText(viewJoin.tfPwdConfirm, "비밀번호를 한번 더 입력해주세요.");
                return;
            }
            if(!pwd.equals(pwdConfirm)) {
                viewJoin.tfPwdConfirm.setText("");
                showMsgWithResetText(viewJoin.tfPwd,"입력한 패스워드가 서로 다릅니다.\n다시 입력해 주십시오.");
                return;
            }
            //이름 검사
            String name = viewJoin.tfName.getText();
            if(name.length()<1) {
                showMsgWithResetText(viewJoin.tfName, "이름이 비어있습니다.");
                return;
            }
            if(name.length()>20){
                showMsgWithResetText(viewJoin.tfName,"이름은 20자 이하만 입력 가능합니다.\n다시 입력해 주십시오.");
                return;
            }
            //이메일 양식검사
            String email = viewJoin.tfEmail.getText();
            if(email.length()<1) {
                showMsgWithResetText(viewJoin.tfEmail, "이메일이 비어있습니다.");
                return;
            }
            if(!Pattern.matches(Regex.EMAIL, email)) {
                showMsgWithResetText(viewJoin.tfEmail,Regex.EMAIL_WARN);
                return;
            }
            if(email.length()>30) {
                showMsgWithResetText(viewJoin.tfEmail,"이메일은 30자 이하만 입력 가능합니다.\n다시 입력해 주십시오.");
                return;
            }
            
            Member m = new Member();
            m.setId(id);
            m.setPwd(pwd);
            m.setName(name);
            m.setEmail(email);
            m.setInterestCategory(viewJoin.cbInterestCategory.getSelectedIndex());
            if (new MemberDAO().insertJoin(m)) {
                viewJoin.showMsg("환영합니다^^");
                finish();
            } else {
                
                viewJoin.showMsg("가입할 수 없습니다!");
            }
        }
    }
    
    private void showMsgWithResetText(JTextField tf, String msg) {
        viewJoin.showMsg(msg);
        tf.setText("");
        tf.requestFocus();
    }
}