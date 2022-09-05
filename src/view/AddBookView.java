package view;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class AddBookView extends JFrame 
{
     public JTextField tf_isbn,tf_genre,tf_price, tf_book, tf_writer;
     public JTextArea ta_content;
     public JButton bt_submit,bt_reset;
     JLabel la_isbn,la_book,la_writer,la_genre,la_price, la_content;
     JScrollPane sp;
      public AddBookView(){   
      setTitle("AddBookView");
      
      tf_isbn = new JTextField();
      tf_book = new JPasswordField();
      tf_writer = new JPasswordField();
      tf_genre= new JTextField();
      tf_price = new JTextField();
      ta_content = new JTextArea();
      
      bt_submit = new JButton("등록");
      bt_reset = new JButton("취소");
      
      la_isbn = new JLabel("도서번호:");
      la_book = new JLabel("도서명:");
      la_writer = new JLabel("저자명:");
      la_genre = new JLabel("장르:");
      la_price = new JLabel("도서원가:"); 
      la_content = new JLabel("줄거리:");
      
//setBounds 
      tf_isbn.setBounds(80,30,100,25);
      tf_book.setBounds(80,70,100,25);
      tf_writer.setBounds(80,110,100,25);
      tf_genre.setBounds(80,150,100,25);
      tf_price.setBounds(80,190,100,25);
      sp = new JScrollPane(ta_content);
      sp.setBounds(80,230,180,60);
      
      bt_submit.setBounds(50,310,90,25);
      bt_reset.setBounds(150,310,90,25);
      
      la_isbn.setBounds(10,30,100,25);
      la_book.setBounds(10,70,100,25);
      la_writer.setBounds(10,110,100,25);
      la_genre.setBounds(10,150,100,25);
      la_price.setBounds(10, 190, 100, 25);
      la_content.setBounds(10, 230, 100, 25);
//add
      setLayout(null);
      add(tf_isbn);
      add(tf_book);
      add(tf_writer);
      add(tf_genre);
      add(tf_price);
      
      add(bt_submit);
      add(bt_reset);
      
      add(la_isbn); 
      add(la_book); 
      add(la_writer); 
      add(la_genre);
      add(la_price);
      add(la_content);
      add(sp);
      
      setBounds(350,200,300,400); 
      
      setVisible(true);
     }//생성자  
      public void showMsg(String msg) {
      JOptionPane.showMessageDialog(this, msg);
     }
      
      public void setEmpty() {
       tf_isbn.setText("");
       tf_price.setText("");
       tf_genre.setText("");
       tf_book.setText("");
       tf_writer.setText("");
      }
      public static void main(String[] args) {
        new AddBookView();
    }
}//AddBookView
