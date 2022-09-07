package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginView extends JFrame
{
    public JTextField tfId;
    public JPasswordField tfPwd;
    public JButton btnLogin,btnJoin;
    JLabel la_id, la_pass;

    public LoginView()
    {  
        setTitle("LoginView");

        tfId = new JTextField();     
        tfPwd = new JPasswordField();

        btnLogin = new JButton("로그인");
        btnJoin = new JButton("신규가입");

        la_id = new JLabel("I  D");
        la_pass = new JLabel("Password");

        tfId.setBounds(80,30,100,25);
        tfPwd.setBounds(80,65,100,25);
        btnLogin.setBounds(90,110,80,25);
        btnJoin.setBounds(190,30,90,25);
        la_id.setBounds(8,30,80,25);
        la_pass.setBounds(8,65,90,25);

        setLayout(null);
        add(tfId);
        add(tfPwd);
        add(btnLogin);
        add(btnJoin);
        add(la_id);
        add(la_pass);

        setBounds(400,300,300,180);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

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
