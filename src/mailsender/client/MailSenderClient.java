package mailsender.client;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Properties;

import mailsender.Message;

/**
 * 프로그램에서 메일 전송 서버로 요청을 보낼 수 있게 해주는 기능을 제공하는 싱글톤 클래스
 * @author 강현구.
 *
 */
public class MailSenderClient extends Thread{
    private String mIp;
    private int mPort;
    private static MailSenderClient mInstance;

    public static MailSenderClient getInstance() {
        if(mInstance==null) {
            mInstance = new MailSenderClient();
        }
        return mInstance;
    }

    private MailSenderClient(){
        try {
            Properties porp = new Properties();
            porp.load(new FileReader("client.properties"));
            mIp = porp.getProperty("server_ip");
            mPort = Integer.parseInt(porp.getProperty("server_port"));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("메일 전송 클라이언트 구성 정보 불러오기 실패");
        }
    }

    public void sendMessage(String receiverEmail, String subject, String msg) {
        new MessageSenderThread(mIp, mPort, receiverEmail, subject, msg).start();
    }

    private static class MessageSenderThread extends Thread{
        private String mReceiverEmail;
        private String mSubject;
        private String mMsg;
        private String mIp;
        private int mPort;
        MessageSenderThread(String ip, int port, String receiverEmail, String subject, String msg){
            mReceiverEmail = receiverEmail;
            mSubject = subject;
            mMsg = msg;
            mIp = ip;
            mPort = port;
        }
        @Override
        public void run() {
            Socket s = null;
            try {
                s = new Socket(mIp, mPort);
                s.setSoTimeout(2000);
                ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
                Message msg = new Message();
                msg.receiverEmail = mReceiverEmail;
                msg.subject = mSubject;
                msg.msg = mMsg;
                oos.writeObject(msg);
            }catch(Exception e) {
                e.printStackTrace();
                System.out.println("알수없는 오류 발생");
            }finally {
                try {
                    s.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }   
        }
    }
}
