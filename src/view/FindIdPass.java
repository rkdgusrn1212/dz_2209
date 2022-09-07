package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class FindIdPass extends JFrame{

    public JTextField tfEmail;
    JLabel labelEmail; //"로그인시 입력한 이메일을 입력하세요"
    public JButton btnSubmit;

    public FindIdPass() {

        setTitle("아이디 비번 찾기");

        tfEmail = new JTextField();
        tfEmail.setBounds(50, 80, 180, 30);
        labelEmail = new JLabel("로그인시 입력한 이메일을 입력하세요");
        labelEmail.setBounds(30, 30, 250, 20);
        btnSubmit = new JButton("입력");
        btnSubmit.setBounds(110, 130, 70, 50);

        setLayout(null);
        add(tfEmail);
        add(labelEmail);
        add(btnSubmit);

        setBounds(350, 200, 300, 250);
        setVisible(true);   
    }
}
