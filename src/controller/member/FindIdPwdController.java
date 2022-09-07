package controller.member;

import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import controller.Controller;
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
        sendMail(viewFindIdPwd.tfEmail.getText());
        finish();
    }

    @Override
    protected void create(View windowView) {
        viewFindIdPwd = (FindIdPwdView) windowView;
        viewFindIdPwd.btnSubmit.addActionListener(this);
        viewFindIdPwd.tfEmail.requestFocus();
    }

    private void sendMail(String receiverEmail) {
        System.out.println(receiverEmail);
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", 465);
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.ssl.enable", "true");
        prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        prop.put("mail.smtp.ssl.protocols", "TLSv1.2");


        Session session = Session.getInstance(prop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                Properties pro = new Properties();
                try {
                    pro.load(new FileReader("mail.properties"));
                } catch (IOException e) {
                    System.out.println("메일 전송 정보 불러오기 실패");
                    e.printStackTrace();
                }
                return new PasswordAuthentication(pro.getProperty("sender"), pro.getProperty("pwd"));
            }
        });
        Message message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress("khgremote@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO, InternetAddress.parse(receiverEmail));
            message.setSubject("Mail Subject");

            String msg = "ID 정보 : xx, 패스워드 정보: xx";

            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            mimeBodyPart.setContent(msg, "text/html; charset=utf-8");

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(mimeBodyPart);

            message.setContent(multipart);

            Transport.send(message);
        } catch (AddressException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (MessagingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
