package view.quiz;

import java.awt.Font;
import java.awt.event.WindowAdapter;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class AddQuizView extends JFrame {
//    public JTextField tfQuestion;
    public JTextArea tfQuestion;
    public JTextField tfAnswer;
    public JButton btnSubmit, btnReset;
    JLabel labelQuestion, labelAnswer;
    JScrollPane sp;

    public AddQuizView() {
        setTitle("퀴즈추가");
        

        labelQuestion = new JLabel("문제");
//        tfQuestion = new JTextField();
        tfQuestion = new JTextArea();
        labelAnswer = new JLabel("정답");
        tfAnswer = new JTextField();
        btnSubmit = new JButton("등록");
        btnReset = new JButton("취소");

        // setBounds
        labelQuestion.setBounds(50, 30, 100, 50);
        tfQuestion.setBounds(140, 50, 290, 250);
        tfQuestion.setLineWrap(true);

        labelAnswer.setBounds(50, 330, 100, 35);
        tfAnswer.setBounds(140, 330, 290, 35);

        btnSubmit.setBounds(50, 400, 130, 35);
        btnReset.setBounds(300, 400, 130, 35);
        
        Font font=new Font("맑은고딕", Font.BOLD, 16);
        labelQuestion.setFont(font);
        tfQuestion.setFont(font);
        labelAnswer.setFont(font);
        tfAnswer.setFont(font);
        btnSubmit.setFont(font);
        btnReset.setFont(font);
        
        // add
        setLayout(null);
        add(labelQuestion);
        add(labelAnswer);
        add(tfQuestion);
        add(tfAnswer);

        add(btnSubmit);
        add(btnReset);

        setBounds(350, 200, 500, 500);
  

    }

    // 생성자
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


}// AddBookView
