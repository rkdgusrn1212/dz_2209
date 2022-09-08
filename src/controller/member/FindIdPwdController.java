package controller.member;

import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.regex.Pattern;

import controller.Controller;
import mailsender.client.MailSenderClient;
import model.dao.MemberDAO;
import view.View;
import view.member.FindIdPwdView;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane;

public class FindIdPwdController extends Controller{
    FindIdPwdView viewFindIdPwd;
    public FindIdPwdController(Controller controller) {
        super(controller, FindIdPwdView.class);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object s = e.getSource();
        if(s == viewFindIdPwd.btnSubmit) {
            String email = viewFindIdPwd.tfEmail.getText();
            if(!Pattern.matches(Regex.EMAIL, email)) {
                JOptionPane.showMessageDialog(viewFindIdPwd, Regex.EMAIL_WARN);
                viewFindIdPwd.tfEmail.setText("");
                viewFindIdPwd.tfEmail.requestFocus();
                return;
            }
            if(new MemberDAO().checkEmail(email)) {
                MailSenderClient.getInstance().sendMessage(email,"테스트 메일 입니다.","아무 메시지나 넣음");
                JOptionPane.showMessageDialog(viewFindIdPwd, "이메일로 전송된 ID와 임시 비밀번호가 전송되었습니다.\n"
                        + "전송된 계정 정보로 로그인 후 반드시 비밀번호를 변경해주세요.");
                finish();
            }else {
                JOptionPane.showMessageDialog(viewFindIdPwd, "해당 이메일로 가입된 계정이 없습니다.");
            }
        }else if(s == viewFindIdPwd.btnReset){
            finish();
        }
    }

    @Override
    protected void create(View windowView) {
        viewFindIdPwd = (FindIdPwdView) windowView;
        viewFindIdPwd.btnSubmit.addActionListener(this);
        viewFindIdPwd.btnReset.addActionListener(this);
        viewFindIdPwd.tfEmail.requestFocus();
    }

}
