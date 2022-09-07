package view.member;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import view.View;

public class MyPageView extends View {
    public JLabel labelMsg, labelGrade, labelCash, labelPoint;
    public JButton btnUpdate, btnHistory, btnCash, btnLogout, btnBack;
    
    public MyPageView() {
        setTitle("MypageView");
        setLayout(null);
        labelMsg = new JLabel("id님 환영합니다.");
        labelGrade = new JLabel("등급: VIP");
        labelCash = new JLabel("등급: 10000 원");
        labelPoint = new JLabel("잔여포인트: 7500 P");
        btnUpdate = new JButton("비밀번호 수정");
        btnHistory = new JButton("이용 내역");
        btnCash = new JButton("캐쉬 충전");
        btnLogout = new JButton("로그아웃");
        btnBack = new JButton("도서선택창으로");
        //setBounds
        btnBack.setBounds(66,10,150,30);
        labelMsg.setBounds(50, 50, 150, 30);
        labelGrade.setBounds(50, 90, 150, 30);
        labelCash.setBounds(50, 140, 150, 30);
        labelPoint.setBounds(50, 190, 150, 30);

        btnUpdate.setBounds(66, 230, 150, 30);
        btnHistory.setBounds(66, 280, 150, 30);
        btnCash.setBounds(66, 330, 150, 30);
        btnLogout.setBounds(66, 380, 150, 30);

        add(labelMsg);
        add(labelGrade);
        add(labelCash);
        add(labelPoint);

        add(btnUpdate);
        add(btnCash);
        add(btnHistory);
        add(btnLogout);
        add(btnBack);

        setSize(300,500);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new MyPageView();
    }
}