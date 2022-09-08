package controller.member;

import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
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
            if(email.length()<1) {
                JOptionPane.showMessageDialog(viewFindIdPwd, "이메일이 비어있습니다.");
                viewFindIdPwd.tfEmail.requestFocus();
                return;
            }
            if(!Pattern.matches(Regex.EMAIL, email)) {
                JOptionPane.showMessageDialog(viewFindIdPwd, Regex.EMAIL_WARN);
                viewFindIdPwd.tfEmail.setText("");
                viewFindIdPwd.tfEmail.requestFocus();
                return;
            }
            MemberDAO memberDAO = new MemberDAO();
            if(memberDAO.checkEmail(email)) {
                String id = memberDAO.selectIdWithEmail(email);
                String pwd = getRamdomPwd(16);
                memberDAO.updatePwdWithEmail(email, pwd);
                MailSenderClient.getInstance().sendMessage(
                        email,"[두부북쉐어] : ID 및 비밀번호 찾기 안내",
                        "안녕하세요! 두부북쉐어 입니다.\r\n"
                        +"회원님의 ID는 ["+id+"] 입니다.\r\n"
                        +"ID 및 비밀번호 찾기 요청에 따라 회원님의 계정에 임시 비밀번호가 발급되었습니다.\r\n"
                        + "다음의 임시 비밀번호로 로그인하고 계정 보호를 위해 반드시 비밀번호를 변경하세요.\r\n\r\n"
                        + pwd);
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
    
    public String getRamdomPwd(int size) {
        char[] charSet = new char[] {
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
                'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
                '!', '@', '#', '$', '%', '^', '&' };

        StringBuffer sb = new StringBuffer();
        SecureRandom sr = new SecureRandom();
        sr.setSeed(new Date().getTime());
        int[] numbers = new int[size];
        for(int i=0 ;i<size; i++) {
            numbers[i] = i;
        }
        int numIdx = numbers[(int) Math.random()*size];
        swapNumbers(numbers,numIdx,size-1);
        int specIdx = numbers[(int) Math.random()*(size-1)];
        swapNumbers(numbers,specIdx,size-2);
        int alpIdx = numbers[(int) Math.random()*(size-2)];
        swapNumbers(numbers,numIdx,size-3);
        int idx = 0;
        int len = charSet.length;
        for (int i=0; i<size; i++) {
            if(i == numIdx) {
                sb.append(charSet[(int)Math.random()*10]);
                continue;
            }
            if(i == specIdx) {
                sb.append(charSet[10+(int)Math.random()*52]);
                continue;
            }
            if(i == alpIdx) {
                sb.append(charSet[62+(int)Math.random()*7]);
                continue;
            }
            idx = sr.nextInt(len);
            sb.append(charSet[idx]);
        }
        return sb.toString();
    }
    
    private void swapNumbers(int[] array, int idx1, int idx2) {
        int temp = array[idx1];
        array[idx1] = array[idx2];
        array[idx2] = temp;
    }
}
