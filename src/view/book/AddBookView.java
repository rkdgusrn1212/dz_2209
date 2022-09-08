package view.book;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import view.View;

public class AddBookView extends View
{
     public JTextField tfIsbn, tfBook, tfWriter, tfCategory, tfPrice; 
     public JTextArea taContent;
     public JButton btnSubmit, btnReset;
     JLabel labelIsbn,labelBook,labelWriter,labelCategory,labelPrice, labelContent;
     JScrollPane sp;
     
     public AddBookView(){   
         setTitle("AddBookView");
      
         tfIsbn = new JTextField();
//          tf_book = new JPasswordField();
//          tf_writer = new JPasswordField();
         tfBook = new JTextField();
         tfWriter = new JTextField();
         tfCategory = new JTextField();
         tfPrice = new JTextField();
         taContent = new JTextArea();
          
         btnSubmit = new JButton("등록");
         btnReset = new JButton("취소");
          
         labelIsbn = new JLabel("도서번호 : ");
         labelBook = new JLabel("도서명 : ");
         labelWriter = new JLabel("저자명 : ");
         labelCategory = new JLabel("도서장르 : ");
         labelPrice = new JLabel("도서원가 :"); 
         labelContent = new JLabel("줄거리 :");
          
         
         //setBounds 
         tfIsbn.setBounds(80,30,100,25);
         tfBook.setBounds(80,70,100,25);
         tfWriter.setBounds(80,110,100,25);
         tfCategory.setBounds(80,150,100,25);
         tfPrice.setBounds(80,190,100,25);
         sp = new JScrollPane(taContent);
         sp.setBounds(80,230,180,60);
          
         btnSubmit.setBounds(50,310,90,25);
         btnReset.setBounds(150,310,90,25);
          
         labelIsbn.setBounds(10,30,100,25);
         labelBook.setBounds(10,70,100,25);
         labelWriter.setBounds(10,110,100,25);
         labelCategory.setBounds(10,150,100,25);
         labelPrice.setBounds(10, 190, 100, 25);
         labelContent.setBounds(10, 230, 100, 25);
         
         
          //add
          setLayout(null);
          add(tfIsbn);
          add(tfBook);
          add(tfWriter);
          add(tfCategory);
          add(tfPrice);
//          add(taContent);
          
          add(btnSubmit);
          add(btnReset);
          
          add(labelIsbn); 
          add(labelBook); 
          add(labelWriter); 
          add(labelCategory);
          add(labelPrice);
          add(labelContent);
          add(sp);
          
          setBounds(350,200,300,400); 
          
          setVisible(true);
         }
     
     
          //생성자  
          public void showMsg(String msg) {
          JOptionPane.showMessageDialog(this, msg);
         }
          
          public void setEmpty() {
              tfIsbn.setText("");
              tfBook.setText("");
              tfWriter.setText("");
              tfCategory.setText("");
              tfPrice.setText("");
          }
          

      
}//AddBookView
