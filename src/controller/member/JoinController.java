package controller.member;


import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controller.Controller;
import mailsender.client.MailSenderClient;
import model.dao.MemberDAO;
import model.vo.Member;
import view.View;
import view.member.JoinView;
public class JoinController extends Controller{

    JoinView viewJoin;
    private boolean isEmailValid = false;//이메일 검증여부
    private boolean isIdValid = false;//ID 검증여부.

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
        viewJoin.btnCheckId.addActionListener(this);
        viewJoin.btnValidEmail.addActionListener(this);
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
        }else if(s==viewJoin.btnCheckId) {
            String id = viewJoin.tfId.getText();
            if(!checkIdFormat(id)) {
                return; 
            }
            if(new MemberDAO().isIdExist(id)) {
                JOptionPane.showMessageDialog(viewJoin, "이미 존재하는 ID입니다.");
                viewJoin.tfId.requestFocus();
            }else {
                JOptionPane.showMessageDialog(viewJoin, "사용 가능한 ID입니다.");
                viewJoin.tfId.setEditable(false);
                isIdValid = true;
            }
        }else if(s == viewJoin.btnValidEmail) {
            //이메일 양식검사
            String email = viewJoin.tfEmail.getText();
            if(!checkEmailFormat(email)) {
                return;
            }
            if(new MemberDAO().isEmailExist(email)) {
                JOptionPane.showMessageDialog(viewJoin, "이미 존재하는 Email입니다.");
                viewJoin.tfEmail.requestFocus();
            }else {
                viewJoin.tfEmail.setEditable(false);
                String randomCode = new RandomCodeGenerator().getRandomCode(12);
                MailSenderClient.getInstance().sendMessage(email, "[두부북쉐어] 이메일 인증 코드입니다.", "다음 12자리 인증코드를 회원가입창에 입력하세요. ["+randomCode+"]");
                String respondCode = JOptionPane.showInputDialog(viewJoin, 
                        "이메일 인증코드가 "+email+"로 전송되었습니다.\n전송받은 이메일 인증코드를 아래에 입력하세요.");
            
                if(randomCode.equals(respondCode)) {
                    JOptionPane.showMessageDialog(viewJoin, "이메일 인증에 성공하였습니다.");
                    isEmailValid = true;
                }else {
                    JOptionPane.showMessageDialog(viewJoin, "이메일 인증에 실패하였습니다.");
                    viewJoin.tfEmail.setEditable(true);
                    viewJoin.tfEmail.requestFocus();
                }
            }
        }else if(s == viewJoin.btnSubmit) {
            //ID 검사
            String id = viewJoin.tfId.getText();
            if(!checkIdFormat(id)) {
                return; 
            }
            if(!isIdValid) {
                JOptionPane.showMessageDialog(viewJoin, "ID 중복을 검사해주세요.");
                viewJoin.tfId.requestFocus();
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
            if(!checkEmailFormat(email)) {
                return;
            }
            if(!isEmailValid) {
                JOptionPane.showMessageDialog(viewJoin, "Email을 먼저 인증해주세요.");
                viewJoin.tfEmail.requestFocus();
                return;
            }


            Member m = new Member();
            m.setId(viewJoin.tfId.getText());
            m.setPwd(pwd);
            m.setName(name);
            m.setEmail(viewJoin.tfEmail.getText());
            m.setInterestCategory(viewJoin.cbInterestCategory.getSelectedIndex());
            if (new MemberDAO().insertJoin(m)) {
                viewJoin.showMsg("환영합니다^^");
                finish();
            } else {
                viewJoin.showMsg("가입할 수 없습니다!");
            }
        }
    }
    
    private boolean checkIdFormat(String id) {
        if(id.length()<1) {
            showMsgWithResetText(viewJoin.tfId, "ID가 비어있습니다.");
            return false;
        }
        if(!Pattern.matches(Regex.ID, id)) {
            showMsgWithResetText(viewJoin.tfId, Regex.ID_WARN);
            return false;
        }
        return true;
    }
    
    private boolean checkEmailFormat(String email) {
        if(email.length()<1) {
            showMsgWithResetText(viewJoin.tfEmail, "이메일이 비어있습니다.");
            return false;
        }
        if(!Pattern.matches(Regex.EMAIL, email)) {
            showMsgWithResetText(viewJoin.tfEmail,Regex.EMAIL_WARN);
            return false;
        }
        if(email.length()>30) {
            showMsgWithResetText(viewJoin.tfEmail,"이메일은 30자 이하만 입력 가능합니다.\n다시 입력해 주십시오.");
            return false;
        }
        return true;
    }

    private void showMsgWithResetText(JTextField tf, String msg) {
        viewJoin.showMsg(msg);
        tf.setText("");
        tf.requestFocus();
    }
}