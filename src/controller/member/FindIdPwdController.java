package controller.member;

import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import controller.Controller;
import mailsender.client.MailSenderClient;
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

public class FindIdPwdController extends Controller{
    FindIdPwdView viewFindIdPwd;
    public FindIdPwdController(Controller controller) {
        super(controller, FindIdPwdView.class);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MailSenderClient.getInstance().sendMessage(viewFindIdPwd.tfEmail.getText(),"테스트 메일 입니다.","아무 메시지나 넣음");
        finish();
    }

    @Override
    protected void create(View windowView) {
        viewFindIdPwd = (FindIdPwdView) windowView;
        viewFindIdPwd.btnSubmit.addActionListener(this);
        viewFindIdPwd.tfEmail.requestFocus();
    }

}
