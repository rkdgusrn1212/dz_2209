package mailsender.server;

import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Properties;
import java.util.Scanner;

import mailsender.Message;
import mailsender.server.MailSender.ResultListener;

/**
 * 메시지를 소캣으로 전송받아 이메일로 전송한다.
 *@author 강현구
 */
public class MailSenderServer{

    public static void main(String[] args) {

        System.out.println("메시지-메일 전송 서버 프로그램 시작!");
        MessageReceiverThread thread = new MessageReceiverThread();
        thread.start();
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.print("종료하려면 exit를 입력하세요 > ");
            String[] inst = sc.nextLine().split("\\s+");
            System.out.println(inst[0]);
            if(inst[0].trim().equals("exit")) {
                break;
            }
        }
        sc.close();
        System.out.println("메시지-메일 전송 서버 종료...");
        thread.softStop();
    }

    static class MessageReceiverThread extends Thread {

        ServerSocket serverSocket;
        boolean isRunning = true;
        Socket socket;

        MessageReceiverThread(){
            int port = 0;
            try {
                Properties porp = new Properties();
                porp.load(new FileReader("server.properties"));
                port = Integer.parseInt(porp.getProperty("port"));
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
            try {
                serverSocket = new ServerSocket(port);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            while(isRunning) {//한번에 한 클라이언트만 처리. 메일 동시 발송을 막는다.
                try {
                    socket = serverSocket.accept();
                    ObjectInputStream os = new ObjectInputStream(socket.getInputStream());
                    Message msg = (Message)os.readObject();
                    new MailSender(new MsgRcvResultListener()).sendMail(msg.receiverEmail, msg.subject, msg.msg);
                }catch(Exception e) {
                    synchronized(this) {
                        if(isRunning) {
                            System.out.println("알수없는 오류로 소켓통신 끊김.");
                            e.printStackTrace();
                        }
                    }
                }finally{
                    try {
                        if(socket!=null) {
                            socket.close();
                            socket = null;
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        void softStop() {
            synchronized(this) {
                isRunning = false;
            }
            try {
                if(socket!=null) {
                    socket.close();
                }
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    private static class MsgRcvResultListener implements ResultListener {

        @Override
        public void result(String receiverEmail, String subject, String msg, boolean success) {
            System.out.println(receiverEmail+"에게 <메일 제목:\""+subject+"\"> 보내기"+(success?"성공":"실패"));
        }   
    }
}
