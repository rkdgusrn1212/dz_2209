package controller.member;


import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.util.regex.Pattern;

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
        viewJoin.tfPwd2.setText("");
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
            String id = viewJoin.tfId.getText();
            if(!Pattern.matches("^[a-zA-Z0-9_]{6,20}$", id)) {
                viewJoin.showMsg("ID는 6글자 이상 20글자 이하의 영문자, 숫자, 언더바만 입력 가능합니다.\n다시 입력해 주십시오.");
                viewJoin.tfId.setText("");
                viewJoin.tfId.requestFocus();
                return;
            }
            String pwd = new String(viewJoin.tfPwd.getPassword());
            //패스워드 검사.
            if(!Pattern.matches("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,16}$",pwd)) {
                viewJoin.showMsg("비밀번호는 숫자, 영문자, 특수문자를 각각 하나이상 포함하고 8자이상 16자 이하여야 합니다.\n다시 입력해 주십시오.");
                viewJoin.tfPwd.setText("");
                viewJoin.tfPwd2.setText("");
                viewJoin.tfPwd.requestFocus();
                return;
            }
            //패스워드 재확인 검사.
            if(!pwd.equals(new String(viewJoin.tfPwd2.getPassword()))) {
                viewJoin.showMsg("입력한 패스워드가 서로 다릅니다.");
                viewJoin.tfPwd.setText("");
                viewJoin.tfPwd2.setText("");
                viewJoin.tfPwd.requestFocus();
                return;
            }
            //이메일 양식검사
            String email = viewJoin.tfEmail.getText();
            if(!Pattern.matches("^[a-zA-Z0-9+-\\_.]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$", email)) {
                viewJoin.showMsg("알맞는 이메일 형식이 아닙니다.\n다시 입력해 주십시오.");
                viewJoin.tfEmail.setText("");
                viewJoin.tfEmail.requestFocus();
                return;
            }
            if(email.length()>30) {
                viewJoin.showMsg("이메일은 30자 이하만 입력 가능합니다.\n다시 입력해 주십시오.");
                viewJoin.tfEmail.setText("");
                viewJoin.tfEmail.requestFocus();
                return;
            }
            Member m = new Member();
            m.setId(viewJoin.tfId.getText());
            m.setPass(pwd);
            m.setEname(viewJoin.tfName.getText());
            m.setEmail(email);
            m.setGenre(viewJoin.cbGenre.getSelectedItem().toString());
            if (new MemberDAO().insertJoin(m)) {
                viewJoin.showMsg("환영합니다^^");
                finish();
            } else {
                viewJoin.showMsg("가입할 수 없습니다!");
            }
        }
    }
    
    private boolean checkPwdRegEx(String pwd) {
        return Pattern.matches("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,13}$",  pwd);
    }
}
