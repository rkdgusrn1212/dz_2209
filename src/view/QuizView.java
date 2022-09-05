package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import javax.swing.JTextField;

public class QuizView extends JFrame{
    JPanel panel_Q;
    JLabel label_quizQ;
    JLabel label_nameQ;
    JLabel label_contentQ;
    JLabel la_answer;
    public JTextField tf_answer;
    public JButton confirm_Q;
    public JButton cancel_Q;
    public QuizView() {
        setTitle("퀴즈");
        confirm_Q = new JButton("확인");
        cancel_Q = new JButton("취소");
        label_quizQ = new JLabel("퀴즈");
        label_nameQ = new JLabel("책제목");
        label_contentQ = new JLabel("질문내용");
        tf_answer = new JTextField();
        panel_Q = new JPanel();
        panel_Q.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, Color.ORANGE, Color.YELLOW, null, null));
        
        panel_Q.setLayout(null);
        getContentPane().setLayout(null);
        panel_Q.setBounds(14, 12, 714, 64);
        tf_answer.setColumns(10);
        label_contentQ.setBounds(51, 151, 654, 130);
        label_nameQ.setBounds(24, 88, 147, 51);
        label_quizQ.setBounds(306, 12, 111, 40);
        tf_answer.setBounds(216, 316, 463, 36);
        confirm_Q.setBounds(185, 393, 160, 64);
        cancel_Q.setBounds(377, 393, 160, 64);

        panel_Q.add(label_quizQ);
        getContentPane().add(panel_Q);
        getContentPane().add(label_nameQ);
        getContentPane().add(label_contentQ);
        getContentPane().add(tf_answer);
        getContentPane().add(confirm_Q);
        getContentPane().add(cancel_Q);
        la_answer = new JLabel("정답");
        la_answer.setBounds(83, 314, 105, 40);
        getContentPane().add(la_answer);
    }
}

