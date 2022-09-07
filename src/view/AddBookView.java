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
     public JTextField tfIsbn,tfGenre,tfPrice, tfBook, tfWriter;
     public JTextArea taContent;
     public JButton btSubmit,btReset;
     JLabel labelIsbn,labelBook,labelWriter,labelGenre,labelPrice, labelContent;
     JScrollPane scrollPanel;
      public AddBookView(){   
      setTitle("AddBookView");
      
      tfIsbn = new JTextField();
      tfBook = new JPasswordField();
      tfWriter = new JPasswordField();
      tfGenre= new JTextField();
      tfPrice = new JTextField();
      taContent = new JTextArea();
      
      btSubmit = new JButton("등록");
      btReset = new JButton("취소");
      
      labelIsbn = new JLabel("도서번호:");
      labelBook = new JLabel("도서명:");
      labelWriter = new JLabel("저자명:");
      labelGenre = new JLabel("장르:");
      labelPrice = new JLabel("도서원가:"); 
      labelContent = new JLabel("줄거리:");
      
//setBounds 
      tfIsbn.setBounds(80,30,100,25);
      tfBook.setBounds(80,70,100,25);
      tfWriter.setBounds(80,110,100,25);
      tfGenre.setBounds(80,150,100,25);
      tfPrice.setBounds(80,190,100,25);
      scrollPanel = new JScrollPane(taContent);
      scrollPanel.setBounds(80,230,180,60);
      
      btSubmit.setBounds(50,310,90,25);
      btReset.setBounds(150,310,90,25);
      
      labelIsbn.setBounds(10,30,100,25);
      labelBook.setBounds(10,70,100,25);
      labelWriter.setBounds(10,110,100,25);
      labelGenre.setBounds(10,150,100,25);
      labelPrice.setBounds(10, 190, 100, 25);
      labelContent.setBounds(10, 230, 100, 25);
//add
      setLayout(null);
      add(tfIsbn);
      add(tfBook);
      add(tfWriter);
      add(tfGenre);
      add(tfPrice);
      
      add(btSubmit);
      add(btReset);
      
      add(labelIsbn); 
      add(labelBook); 
      add(labelWriter); 
      add(labelGenre);
      add(labelPrice);
      add(labelContent);
      add(scrollPanel);
      
      setBounds(350,200,300,400); 
      
      setVisible(true);
     }//생성자  
      public void showMsg(String msg) {
      JOptionPane.showMessageDialog(this, msg);
     }
      
      public void setEmpty() {
       tfIsbn.setText("");
       tfPrice.setText("");
       tfGenre.setText("");
       tfBook.setText("");
       tfWriter.setText("");
      }
      public static void main(String[] args) {
        new AddBookView();
    }
}//AddBookView
