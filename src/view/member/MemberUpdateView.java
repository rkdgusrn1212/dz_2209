package view.member;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import view.View;

public class MemberUpdateView extends View {
    public JTextField tfId,tfName,tfEmail;
    public JPasswordField tfPwd,tfPwdConfirm;
    public JButton btnSubmit,btnReset;
    JLabel labelId,labelPwd,labelPwdConfirm,labelName,labelEmail;


    public MemberUpdateView()
    {   
        setTitle("회원 정보 수정");

        tfId = new JTextField();
        tfId.setEditable(false);
        tfPwd = new JPasswordField();
        tfPwdConfirm = new JPasswordField();
        tfName= new JTextField();
        tfEmail = new JTextField();
        tfEmail.setEditable(false);

        btnSubmit = new JButton("등록");
        btnReset = new JButton("취소");

        labelId = new JLabel("I  D");
        labelPwd = new JLabel("새 비밀번호");
        labelPwdConfirm = new JLabel("새 비밀번호 확인");
        labelName = new JLabel("이  름");
        labelEmail = new JLabel("이메일"); 


        tfId.setBounds(140,30,200,35);
        tfPwd.setBounds(140,80,200,35);
        tfPwdConfirm.setBounds(140,130,200,35);
        tfName.setBounds(140,180,200,35);
        tfEmail.setBounds(140,230,200,35);

        btnSubmit.setBounds(30,300,150,35);
        btnReset.setBounds(200,300,150,35);

        labelId.setBounds(30,30,100,35);
        labelPwd.setBounds(30,85,100,35);
        labelPwdConfirm.setBounds(30,135,100,35);
        labelName.setBounds(30,185,100,35);
        labelEmail.setBounds(30, 235, 100, 35);
        
        //폰트 추가
        Font font=new Font("맑은고딕", Font.BOLD, 12);
        Font fontBold = new Font("맑은고딕", Font.BOLD, 16);
        tfId.setFont(font);
        tfPwd.setFont(font);
        tfPwdConfirm.setFont(font);
        tfName.setFont(font);
        tfEmail.setFont(font);
        btnSubmit.setFont(fontBold);
        btnReset.setFont(fontBold);
        labelId.setFont(font);
        labelPwd.setFont(font);
        labelPwdConfirm.setFont(font);
        labelName.setFont(font);
        labelEmail.setFont(font);

        setLayout(null);
        add(tfId);
        add(tfPwd);
        add(tfPwdConfirm);
        add(tfName);
        add(tfEmail);
        add(btnSubmit);
        add(btnReset);

        add(labelId); 
        add(labelPwd); 
        add(labelPwdConfirm); 
        add(labelName);
        add(labelEmail);

        setBounds(800,300,400,400);
    }//생성자  
    public void showMsg(String msg) {
        JOptionPane.showMessageDialog(this, msg);
    }
}