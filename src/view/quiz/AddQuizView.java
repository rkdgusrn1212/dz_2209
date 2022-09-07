package view.quiz;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class AddQuizView extends JFrame 
{
     public JTextArea taQuestion;
     public JTextField tfAnswer; 
     public JButton btnSubmit, btnReset;
     JLabel labelQuestion,labelAnswer;
     JScrollPane sp;
     
     public AddQuizView(){   
         setTitle("AddQuizView");
         
         labelQuestion = new JLabel("퀴즈 문제 : ");
         labelAnswer = new JLabel("퀴즈 정답 : ");
         
         taQuestion = new JTextArea();
         tfAnswer = new JTextField();
          
         btnSubmit = new JButton("등록");
         btnReset = new JButton("취소");
         
         //setBounds 
         labelQuestion.setBounds(10,30,100,25);
         labelAnswer.setBounds(10,70,100,25);
         
//         tfWriter.setBounds(80,110,100,25);
//         tfGenre.setBounds(80,150,100,25);
//         tfPrice.setBounds(80,190,100,25);
         sp = new JScrollPane(taQuestion);
         sp.setBounds(80,230,180,60);
         tfAnswer.setBounds(80,70,100,25);
          
         btnSubmit.setBounds(50,310,90,25);
         btnReset.setBounds(150,310,90,25);
         
          //add
          setLayout(null);
          add(labelQuestion);
          add(labelAnswer);
          add(taQuestion);
          add(tfAnswer);
          
          add(btnSubmit);
          add(btnReset);
          add(sp);
          
          setBounds(350,200,300,400); 
          
          setVisible(true);
         }
     
     
          //생성자  
          public void showMsg(String msg) {
          JOptionPane.showMessageDialog(this, msg);
         }
          
//          public void setEmpty() {
//              tfIsbn.setText("");
//              tfBook.setText("");
//              tfWriter.setText("");
//              tfGenre.setText("");
//              tfPrice.setText("");
//          }
          
          
          //main
      public static void main(String[] args) {
        new AddQuizView();
    }
      
}//AddBookView