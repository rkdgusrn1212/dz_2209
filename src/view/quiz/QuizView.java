package view.quiz;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

import view.history.HistoryView;

public class QuizView extends JFrame{
    JPanel panelQuiz;
    JLabel labelQuiz, labelContent, labelAnswer;
    JRadioButton rBtnAs1, rBtnAs2, rBtnAs3, rBtnAs4, rBtnAs5;
    public ButtonGroup bg;
    public JTextField tfAnswer;
    public JButton btnConfirm, btnCancel;
    public QuizView() {
        setTitle("퀴즈");
        
        btnConfirm = new JButton("확인");
        btnCancel = new JButton("취소");
        
        labelQuiz = new JLabel("퀴즈");
        labelContent = new JLabel("질문내용");
        
        tfAnswer = new JTextField();
        
        // 퀴즈 영역 꾸밈(장식 효과)
        panelQuiz = new JPanel();
        panelQuiz.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, Color.GRAY, Color.YELLOW, null, null));
        panelQuiz.setLayout(null);
        getContentPane().setLayout(null);
        panelQuiz.setBounds(14, 12, 714, 40);
        labelQuiz.setBounds(340, 2, 111, 40);
        labelContent.setBounds(51,75, 654, 130);
        
        // 정답 창 설정
        labelAnswer = new JLabel("정답");
        labelAnswer.setBounds(65, 314, 105, 40); // 정답 글자 위치
        getContentPane().add(labelAnswer);
        
        tfAnswer.setColumns(10);

        
        // 정답 Radio 버튼으로 선택
        // 선택 버튼 생성
        rBtnAs1 = new JRadioButton("1");
        rBtnAs2 = new JRadioButton("2");
        rBtnAs3 = new JRadioButton("3");
        rBtnAs4 = new JRadioButton("4");
        rBtnAs5 = new JRadioButton("5");
        // 라디오 버튼 그룹화
        bg = new ButtonGroup();
        bg.add(rBtnAs1);
        bg.add(rBtnAs2);
        bg.add(rBtnAs3);
        bg.add(rBtnAs4);
        bg.add(rBtnAs5);
        // 라디오 버튼 위치 조정
        rBtnAs1.setBounds(160, 319, 80, 30);
        rBtnAs2.setBounds(260, 319, 80, 30);
        rBtnAs3.setBounds(360, 319, 80, 30);
        rBtnAs4.setBounds(460, 319, 80, 30);
        rBtnAs5.setBounds(560, 319, 80, 30);
        // 확인 취소 창 위치 및 크기 조정
        btnConfirm.setBounds(185, 393, 160, 45);
        btnCancel.setBounds(377, 393, 160, 45);


        
        Font font=new Font("맑은고딕", Font.BOLD, 16);
        panelQuiz.setFont(font);
        labelQuiz.setFont(font);
        labelContent.setFont(font);
        rBtnAs1.setFont(font);
        rBtnAs2.setFont(font);
        rBtnAs3.setFont(font);
        rBtnAs4.setFont(font);
        rBtnAs5.setFont(font);
        btnConfirm.setFont(font);
        btnCancel.setFont(font);
        labelAnswer.setFont(font);
        
        // frame
        add(rBtnAs1);
        add(rBtnAs2);
        add(rBtnAs3);
        add(rBtnAs4);
        add(rBtnAs5);

        panelQuiz.add(labelQuiz);
        getContentPane().add(panelQuiz);
        getContentPane().add(labelContent);
        getContentPane().add(tfAnswer);
        getContentPane().add(btnConfirm);
        getContentPane().add(btnCancel);
        

        setBounds(700,200,760,510); 
        
    }
}

