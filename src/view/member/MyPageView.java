package view.member;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import view.View;

public class MyPageView extends View {
    public JLabel labelMsg, labelCash;
    public JButton btnUpdate, btnEditBook, btnCash, btnLogout, btnBack;
    
    public MyPageView() {
        setTitle("MyPage");
        setLayout(null);
        labelMsg = new JLabel(); //ID 띄우는 label
        labelCash = new JLabel("보유 캐시: ");
        btnUpdate = new JButton("회원 정보 수정");
        btnEditBook = new JButton("도서 정보 수정");
        btnCash = new JButton("캐시 충전");
        btnLogout = new JButton("로그아웃");
        btnBack = new JButton("메인페이지");
        //setBounds
        btnBack.setBounds(240,280,150,35);
        labelMsg.setBounds(50, 30, 300, 35);
        labelCash.setBounds(50, 100, 150, 35);

        btnUpdate.setBounds(50, 230, 150, 35);
        btnEditBook.setBounds(50, 280, 150, 35);
        btnCash.setBounds(240, 230, 150, 35);
        btnLogout.setBounds(240, 340, 150, 35);
        
        Font font=new Font("맑은고딕", Font.BOLD, 16);
        labelMsg.setFont(font);
        labelCash.setFont(font);
        btnUpdate.setFont(font);
        btnEditBook.setFont(font);
        btnCash.setFont(font);
        btnLogout.setFont(font);
        btnBack.setFont(font);

        add(labelMsg);
        add(labelCash);

        add(btnUpdate);
        add(btnCash);
        add(btnEditBook);
        add(btnLogout);
        add(btnBack);

        setBounds(730,250,450,460);
    }
}
