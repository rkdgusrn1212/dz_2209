package view.member;


import javax.swing.JButton;
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
    JLabel labelId, labelPass;

    public LoginView(){
        setTitle("LoginView");

        tfId = new JTextField();     
        tfPwd = new JPasswordField();

        btnLogin = new JButton("로그인");
        btnJoin = new JButton("신규가입");
        btnFindIdPw = new JButton("ID/PW 찾기");

        labelId = new JLabel("I  D");
        labelPass = new JLabel("Password");
        

        tfId.setBounds(80,30,100,25);
        tfPwd.setBounds(80,65,100,25);
        btnLogin.setBounds(90,110,80,25);
        btnJoin.setBounds(190,30,90,25);
        btnFindIdPw.setBounds(190,65,80,25);
        labelId.setBounds(8,30,80,25);
        labelPass.setBounds(8,65,90,25);

        setLayout(null);
        add(tfId);
        add(tfPwd);
        add(btnLogin);
        add(btnJoin);
        add(btnFindIdPw);
        add(labelId);
        add(labelPass);

        setBounds(400,300,300,180);
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
