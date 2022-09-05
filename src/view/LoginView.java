package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginView extends JFrame
{
        public JTextField tf_id;
        public JPasswordField tf_pass;
        public JButton bt_login,bt_join;
     JLabel la_id, la_pass;
     
      public LoginView()
     {  
      setTitle("LoginView");
      
      tf_id = new JTextField();     
      tf_pass = new JPasswordField();
      
      bt_login = new JButton("로그인");
      bt_join = new JButton("신규가입");
     
         la_id = new JLabel("I  D");
      la_pass = new JLabel("Password");
      
      tf_id.setBounds(80,30,100,25);
      tf_pass.setBounds(80,65,100,25);
      bt_login.setBounds(90,110,80,25);
      bt_join.setBounds(190,30,90,25);
      la_id.setBounds(8,30,80,25);
      la_pass.setBounds(8,65,90,25);
      
      setLayout(null);
      add(tf_id);
      add(tf_pass);
      add(bt_login);
      add(bt_join);
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
        tf_id.setText("");
        tf_pass.setText("");
       }      
}//LoginView
