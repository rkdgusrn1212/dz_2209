package mailsender.server;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

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

//메일을 전송하는 클래스 직접 생성해서 쓴다.
class MailSender {
    
    private String mSender;
    private String mPwd;
    private ResultListener mListener;
    
    MailSender(ResultListener listener){
        mListener = listener;
        Properties pro = new Properties();
        try {
            pro.load(new FileReader("mail.properties"));
            mSender = pro.getProperty("sender");
            mPwd = pro.getProperty("pwd");
        } catch (IOException e) {
            System.out.println("메일 전송 정보 불러오기 실패");
            e.printStackTrace();
        }
    }
    
    void sendMail(String receiverEmail, String subject, String msg) {
        
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", 465);
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.ssl.enable", "true");
        prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        prop.put("mail.smtp.ssl.protocols", "TLSv1.2");

        Session session = Session.getInstance(prop, new MailAuthenticator(mSender, mPwd));
        Message message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(mSender));
            message.setRecipients(
                    Message.RecipientType.TO, InternetAddress.parse(receiverEmail));
            message.setSubject(subject);
            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            mimeBodyPart.setContent(msg, "text/html; charset=utf-8");
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(mimeBodyPart);
            message.setContent(multipart);
            Transport.send(message);
            mListener.result(receiverEmail, subject, msg, true);
            return;
        } catch (AddressException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        mListener.result(receiverEmail, subject, msg, false);
    }
    
    private static class MailAuthenticator extends Authenticator {
        private String mSender;
        private String mPwd;
        private MailAuthenticator(String sender, String pwd){
            mSender = sender;
            mPwd = pwd;
        }
        @Override
        protected PasswordAuthentication getPasswordAuthentication() {
            Properties pro = new Properties();
            try {
                pro.load(new FileReader("mail.properties"));
            } catch (IOException e) {
                System.out.println("메일 전송 정보 불러오기 실패");
                e.printStackTrace();
            }
            return new PasswordAuthentication(mSender, mPwd);
        }
    }
    
    interface ResultListener{
        void result(String receiverEmail, String subject, String msg, boolean success);
    }
}
