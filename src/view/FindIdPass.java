package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class FindIdPass extends JFrame{
    
    public JTextField tf_email;
    JLabel la_email; //"로그인시 입력한 이메일을 입력하세요"
    public JButton bt_submit;
    
    public FindIdPass() {
        
        setTitle("아이디 비번 찾기");
        
        tf_email = new JTextField();
          tf_email.setBounds(50, 80, 180, 30);
        la_email = new JLabel("로그인시 입력한 이메일을 입력하세요");
          la_email.setBounds(30, 30, 250, 20);
        bt_submit = new JButton("입력");
          bt_submit.setBounds(110, 130, 70, 50);
          
        setLayout(null);
        add(tf_email);
        add(la_email);
        add(bt_submit);
        
        setBounds(350, 200, 300, 250);
        setVisible(true);   
    }
}
