package view;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class JoinView extends JFrame 
{
     public JTextField tfId,tfName,tfEmail;
     public JPasswordField tfPwd,tfPwd2;
     public JButton btnSubmit,btnReset,btnCheckId;
     JLabel la_id,la_pass1,la_pass2,la_n,la_email, la_genre;
     public JComboBox<String> cbGenre;
     String items[] = {"수필", "소설", "스릴러"};
      public JoinView()
     {   
      setTitle("joinView");
      
      tfId = new JTextField();
      tfPwd = new JPasswordField();
      tfPwd2 = new JPasswordField();
      tfName= new JTextField();
      tfEmail = new JTextField();
      
      cbGenre = new JComboBox<>(items);
      
      btnSubmit = new JButton("등록");
      btnReset = new JButton("취소");
      btnCheckId = new JButton("중복확인");
      
      la_id = new JLabel("I  D:");
      la_pass1 = new JLabel("비  번:");
      la_pass2 = new JLabel("비번확인:");
      la_n = new JLabel("이  름:");
      la_email = new JLabel("이메일:"); 
      la_genre = new JLabel("장  르:");
      
//setBounds 
      tfId.setBounds(80,30,100,25);
      tfPwd.setBounds(80,70,100,25);
      tfPwd2.setBounds(80,110,100,25);
      tfName.setBounds(80,150,100,25);
      tfEmail.setBounds(80,190,180,25);
      cbGenre.setBounds(80,230,100,25);
      
      btnSubmit.setBounds(50,290,90,25);
      btnReset.setBounds(150,290,90,25);
      btnCheckId.setBounds(190,30,90,25);
      
      la_id.setBounds(10,30,100,25);
      la_pass1.setBounds(10,70,100,25);
      la_pass2.setBounds(10,110,100,25);
      la_n.setBounds(10,150,100,25);
      la_email.setBounds(10, 190, 100, 25);
      la_genre.setBounds(10, 230, 100, 25);
//add
      setLayout(null);
      add(tfId);
      add(tfPwd);
      add(tfPwd2);
      add(tfName);
      add(tfEmail);
      add(cbGenre);
      
      add(btnSubmit);
      add(btnReset);
      add(btnCheckId);
      
      add(la_id); 
      add(la_pass1); 
      add(la_pass2); 
      add(la_n);
      add(la_email);
      add(la_genre);
      
      setBounds(350,200,300,400); 
      setVisible(false);
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
}//JoinForm