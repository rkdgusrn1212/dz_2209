package view.member;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import view.View;


public class FindIdPwdView extends View{

    public JTextField tfEmail;
    JLabel labelEmail; //"로그인시 입력한 이메일을 입력하세요"
    public JButton btnSubmit;

    public FindIdPwdView() {

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

        setBounds(800,300,300,300);
    }
}
