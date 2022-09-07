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
    JPanel panelQuiz;
    JLabel labelQuiz;
    JLabel labelTitle;
    JLabel labelContent;
    JLabel labelAnswer;
    public JTextField tfAnswer;
    public JButton btnConfirm;
    public JButton btnCancel;
    public QuizView() {
        setTitle("퀴즈");
        btnConfirm = new JButton("확인");
        btnCancel = new JButton("취소");
        labelQuiz = new JLabel("퀴즈");
        labelTitle = new JLabel("책제목");
        labelContent = new JLabel("질문내용");
        tfAnswer = new JTextField();
        panelQuiz = new JPanel();
        panelQuiz.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, Color.ORANGE, Color.YELLOW, null, null));

        panelQuiz.setLayout(null);
        getContentPane().setLayout(null);
        panelQuiz.setBounds(14, 12, 714, 64);
        tfAnswer.setColumns(10);
        labelContent.setBounds(51, 151, 654, 130);
        labelTitle.setBounds(24, 88, 147, 51);
        labelQuiz.setBounds(306, 12, 111, 40);
        tfAnswer.setBounds(216, 316, 463, 36);
        btnConfirm.setBounds(185, 393, 160, 64);
        btnCancel.setBounds(377, 393, 160, 64);

        panelQuiz.add(labelQuiz);
        getContentPane().add(panelQuiz);
        getContentPane().add(labelTitle);
        getContentPane().add(labelContent);
        getContentPane().add(tfAnswer);
        getContentPane().add(btnConfirm);
        getContentPane().add(btnCancel);
        labelAnswer = new JLabel("정답");
        labelAnswer.setBounds(83, 314, 105, 40);
        getContentPane().add(labelAnswer);
    }
}

