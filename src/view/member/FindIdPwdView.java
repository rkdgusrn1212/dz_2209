package view.member;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import view.View;


public class FindIdPwdView extends View{

    public JTextField tfEmail;
    JLabel labelEmail; //"로그인시 입력한 이메일을 입력하세요"
    public JButton btnSubmit, btnReset;

    public FindIdPwdView() {

        setTitle("ID/비밀번호 찾기");

        tfEmail = new JTextField();
        tfEmail.setBounds(40, 80, 365, 35);
        labelEmail = new JLabel("가입 시 입력한 이메일을 입력하세요");
        labelEmail.setBounds(40, 30, 350, 35);
        btnSubmit = new JButton("입력");
        btnSubmit.setBounds(40, 130, 130, 35);
        btnReset = new JButton("취소");
        btnReset.setBounds(275, 130, 130, 35);
        // 폰트 생성
        Font font=new Font("맑은고딕", Font.BOLD, 16);
        tfEmail.setFont(font);
        labelEmail.setFont(font);
        btnSubmit.setFont(font);
        btnReset.setFont(font);
        

        setLayout(null);
        add(tfEmail);
        add(labelEmail);
        add(btnSubmit);
        add(btnReset);

        setBounds(730,300,450,240);
    }
}

