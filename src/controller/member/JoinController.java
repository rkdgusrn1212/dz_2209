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
            if(!Pattern.matches("^[a-zA-Z0-9_]{6,20}$", id)) {
                showMsgWithResetText(viewJoin.tfId, "ID는 6글자 이상 20글자 이하의 영문자, 숫자, 언더바만 입력 가능합니다.\n다시 입력해 주십시오.");
                return;
            }
            String pwd = new String(viewJoin.tfPwd.getPassword());
            //패스워드 검사.
            if(pwd.length()<1) {
                showMsgWithResetText(viewJoin.tfPwd, "비밀번호가 비어있습니다.");
                return;
            }
            if(!Pattern.matches("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,16}$",pwd)) {
                viewJoin.tfPwdConfirm.setText("");
                showMsgWithResetText(viewJoin.tfPwd,"비밀번호는 숫자, 영문자, 특수문자를 각각 하나이상 포함하고 8자이상 16자 이하여야 합니다.\n다시 입력해 주십시오.");
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
            if(!Pattern.matches("^[a-zA-Z0-9+-\\_.]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$", email)) {
                showMsgWithResetText(viewJoin.tfEmail,"알맞는 이메일 형식이 아닙니다.\n다시 입력해 주십시오.");
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
    
    private boolean checkPwdRegEx(String pwd) {
        return Pattern.matches("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,13}$",  pwd);
    }
}
