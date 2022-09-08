package view.book;

import java.awt.Font;

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
     public JTextField tfIsbn, tfBook, tfWriter, tfPrice; 
     public JTextArea taContent;
     public JButton btnSubmit, btnReset;
     JLabel labelIsbn,labelBook,labelWriter,labelCategory,labelPrice, labelContent;
     public JComboBox<String> cbInterestCategory;
     JScrollPane sp;
     String items[] = {"총류", "철학, 심리학, 윤리학", "종교", "사회과학", "순수과학", "기술과학", "예술", "어학", "문학", "역사, 지리, 관광"};
     
     public AddBookView(){   
         setTitle("도서추가");
      
         tfIsbn = new JTextField();
//          tf_book = new JPasswordField();
//          tf_writer = new JPasswordField();
         tfBook = new JTextField();
         tfWriter = new JTextField();
         tfPrice = new JTextField();
         taContent = new JTextArea();
          
         btnSubmit = new JButton("등록");
         btnReset = new JButton("취소");
          
         labelIsbn = new JLabel("도서번호");
         labelBook = new JLabel("도서명");
         labelWriter = new JLabel("저자명");
         labelCategory = new JLabel("도서장르");
         labelPrice = new JLabel("도서원가"); 
         labelContent = new JLabel("줄거리");

         cbInterestCategory = new JComboBox<>(items);


         
         //setBounds 
         tfIsbn.setBounds(150,30,200,35);
         tfBook.setBounds(150,80,200,35);
         tfWriter.setBounds(150,130,200,35);
         cbInterestCategory.setBounds(150,180,200,35);
         tfPrice.setBounds(150,230,200,35);
         sp = new JScrollPane(taContent);
         sp.setBounds(150,280,200,145);
          
         btnSubmit.setBounds(40,450,130,35);
         btnReset.setBounds(220,450,130,35);
          
         labelIsbn.setBounds(40,30,100,35);
         labelBook.setBounds(40,80,100,35);
         labelWriter.setBounds(40,130,100,35);
         labelCategory.setBounds(40, 180, 100,35);
         labelPrice.setBounds(40, 230, 100, 35);
         labelContent.setBounds(40, 273, 100, 35);
         
         Font font=new Font("맑은고딕", Font.BOLD, 16);
         tfIsbn.setFont(font);
         tfBook.setFont(font);
         tfWriter.setFont(font);
         cbInterestCategory.setFont(font);
         tfPrice.setFont(font);
         sp.setFont(font);
         btnSubmit.setFont(font);
         btnReset.setFont(font);
         labelIsbn.setFont(font);
         labelBook.setFont(font);
         labelWriter.setFont(font);
         labelCategory.setFont(font);
         labelPrice.setFont(font);
         labelContent.setFont(font);
         
         
         
          //add
          setLayout(null);
          add(tfIsbn);
          add(tfBook);
          add(tfWriter);
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
          add(cbInterestCategory);
          
          setBounds(700,200,410,550); 
          
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
              tfPrice.setText("");
          }

      
}//AddBookView
