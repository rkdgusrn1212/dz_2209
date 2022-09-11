package view.member;


import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import view.View;

public class LoginView extends View
{
    public JTextField tfId;
    public JPasswordField tfPwd;
    public JButton btnLogin,btnJoin;
    public JButton btnFindIdPw;
    public JCheckBox adminCheckBox;
    JLabel labelId, labelPass;

    public LoginView(){
        setTitle("로그인");

        tfId = new JTextField();     
        tfPwd = new JPasswordField();

        btnLogin = new JButton("로그인");
        btnJoin = new JButton("신규가입");
        btnFindIdPw = new JButton("ID/PW 찾기");

        labelId = new JLabel("I  D");
        labelPass = new JLabel("Password");
        adminCheckBox = new JCheckBox("관리자로 로그인");

        tfId.setBounds(120,40,200,35);
        tfPwd.setBounds(120,100,200,35);
        btnLogin.setBounds(345,40,100,95);
        btnJoin.setBounds(30,170,180,35);
        btnFindIdPw.setBounds(270,170,180,35);
        labelId.setBounds(20,43,80,25);
        labelPass.setBounds(20,105,105,25);
        adminCheckBox.setBounds(20,135,150,25);
        
        // 폰트 생성
        Font font=new Font("맑은고딕", Font.BOLD, 16);
        labelId.setFont(font);
        labelPass.setFont(font);
        tfId.setFont(font);
        tfPwd.setFont(font);
        btnLogin.setFont(font);
        btnFindIdPw.setFont(font);
        btnJoin.setFont(font);

        setLayout(null);
        add(tfId);
        add(tfPwd);
        add(btnLogin);
        add(btnJoin);
        add(btnFindIdPw);
        add(labelId);
        add(labelPass);
        add(adminCheckBox);

        setBounds(700,400,480,270);
        setResizable(false);
    }//생성자

    public void showMsg(String msg) {
        JOptionPane.showMessageDialog(this, msg);
    }

    public int showConfirm(String msg) {
        int num = JOptionPane.showConfirmDialog(this, msg);
        return num; //0->예, 1->아니오, 2->취소
    }
    public void setEmpty() {
        tfId.setText("");
        tfPwd.setText("");
    }      
}//LoginView
