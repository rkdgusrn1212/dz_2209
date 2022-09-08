package view.member;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class PwdUpdateView extends JFrame {
    public JTextField tfId,tfName,tfEmail;
    public JPasswordField tfPwd,tfPwd2;
    public JButton btnSubmit,btnReset;
    JLabel la_id,la_pass1,la_pass2,la_n,la_email;


    public PwdUpdateView()
    {   
        setTitle("비밀번호 변경");

        tfId = new JTextField();
        tfPwd = new JPasswordField();
        tfPwd2 = new JPasswordField();
        tfName= new JTextField();
        tfEmail = new JTextField();

        btnSubmit = new JButton("등록");
        btnReset = new JButton("취소");

        la_id = new JLabel("I  D");
        la_pass1 = new JLabel("비밀번호");
        la_pass2 = new JLabel("비밀번호확인");
        la_n = new JLabel("이  름");
        la_email = new JLabel("이메일"); 


        tfId.setBounds(140,30,200,35);
        tfPwd.setBounds(140,80,200,35);
        tfPwd2.setBounds(140,130,200,35);
        tfName.setBounds(140,180,200,35);
        tfEmail.setBounds(140,230,200,35);

        btnSubmit.setBounds(30,300,150,35);
        btnReset.setBounds(200,300,150,35);

        la_id.setBounds(30,30,100,35);
        la_pass1.setBounds(30,85,100,35);
        la_pass2.setBounds(30,135,100,35);
        la_n.setBounds(30,185,100,35);
        la_email.setBounds(30, 235, 100, 35);
        
        //폰트 추가
        Font font=new Font("맑은고딕", Font.BOLD, 16);
        tfId.setFont(font);
        tfPwd.setFont(font);
        tfPwd2.setFont(font);
        tfName.setFont(font);
        tfEmail.setFont(font);
        btnSubmit.setFont(font);
        btnReset.setFont(font);
        la_id.setFont(font);
        la_pass1.setFont(font);
        la_pass2.setFont(font);
        la_n.setFont(font);
        la_email.setFont(font);

        setLayout(null);
        add(tfId);
        add(tfPwd);
        add(tfPwd2);
        add(tfName);
        add(tfEmail); 

        add(btnSubmit);
        add(btnReset);

        add(la_id); 
        add(la_pass1); 
        add(la_pass2); 
        add(la_n);
        add(la_email);

        tfName.setEnabled(false);
        tfId.setEnabled(false);

        setBounds(800,300,400,400);
        setVisible(true);
    }//생성자  
    public void showMsg(String msg) {
        JOptionPane.showMessageDialog(this, msg);
    }

    public void setEmpty() {
        tfId.setText("");
        tfEmail.setText("");
        tfName.setText("");
        tfPwd.setText("");
        tfPwd2.setText("");
    }
   
}//PassUpdateView
