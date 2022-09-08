package view.member;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import view.View;

public class MyPageView extends View {
    public JLabel labelMsg, labelCash, labelPoint;
    public JButton btnUpdate, btnHistory, btnCash, btnLogout, btnBack;
    
    public MyPageView() {
        setTitle("MyPage");
        setLayout(null);
        labelMsg = new JLabel();
        labelCash = new JLabel("잔여 캐시: ");
        labelPoint = new JLabel("잔여 포인트: ");
        btnUpdate = new JButton("비밀번호 수정");
        btnHistory = new JButton("이용 내역");
        btnCash = new JButton("캐쉬 충전");
        btnLogout = new JButton("로그아웃");
        btnBack = new JButton("메인페이지");
        //setBounds
        btnBack.setBounds(240,280,150,35);
        labelMsg.setBounds(50, 30, 300, 35);
        labelCash.setBounds(50, 100, 150, 35);
        labelPoint.setBounds(50, 150, 150, 35);

        btnUpdate.setBounds(50, 230, 150, 35);
        btnHistory.setBounds(240, 230, 150, 35);
        btnCash.setBounds(50, 280, 150, 35);
        btnLogout.setBounds(240, 340, 150, 35);
        
        Font font=new Font("맑은고딕", Font.BOLD, 16);
        labelMsg.setFont(font);
        labelCash.setFont(font);
        labelPoint.setFont(font);
        btnUpdate.setFont(font);
        btnHistory.setFont(font);
        btnCash.setFont(font);
        btnLogout.setFont(font);
        btnBack.setFont(font);

        add(labelMsg);
        add(labelCash);
        add(labelPoint);

        add(btnUpdate);
        add(btnCash);
        add(btnHistory);
        add(btnLogout);
        add(btnBack);

        setBounds(730,250,450,460);
    }
}
