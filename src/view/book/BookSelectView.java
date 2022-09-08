package view.book;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import view.View;

public class BookSelectView extends View {
    public JLabel labelMsg, labelId;
    public JButton btnAdd, btnAllList, btnQuiz, btnSearch, btnMyPage, btnLogout, btnPick1, btnPick2, btnPick3;
    public BookClickView[] viewBookClick;
    public JTextField tfSearch;
    
    public BookSelectView() {
        setTitle("메인페이지");
        setLayout(null);
        //new   
        labelMsg = new JLabel("추천 도서");
        labelId = new JLabel("id");
        tfSearch = new JTextField("제목입력");
        btnAdd = new JButton("도서 등록");
        btnAllList = new JButton("전체 목록");
        btnSearch = new JButton("도서 검색");
        btnQuiz = new JButton("도서 퀴즈");
        viewBookClick = new BookClickView[3];
        btnMyPage = new JButton("마이페이지");
        btnLogout = new JButton("로그아웃");
        btnPick1 = new JButton("선 택");
        btnPick2 = new JButton("선 택");
        btnPick3 = new JButton("선 택");
        
        
        //setBounds

        btnPick1.setBounds(140, 140, 100, 35);
        btnPick2.setBounds(450, 140, 100, 35);
        btnPick3.setBounds(760, 140, 100, 35);
        labelId.setBounds(40, 20, 120, 35);
        labelMsg.setBounds(460, 50, 180, 35);
        tfSearch.setBounds(609, 700, 210, 35);
        btnAdd.setBounds(50, 700, 130, 35);
        btnQuiz.setBounds(235, 700, 130, 35);
        btnAllList.setBounds(420, 700, 130, 35);
        btnSearch.setBounds(820, 700, 130, 35);
        btnMyPage.setBounds(670, 20, 130, 35);
        btnLogout.setBounds(820, 20, 130, 35);
        
        
        Font font=new Font("맑은고딕", Font.BOLD, 16);
        Font font2=new Font("맑은고딕", Font.ITALIC, 16);
        labelMsg.setFont(font);
        btnPick1.setFont(font);
        btnPick2.setFont(font);
        btnPick3.setFont(font);
        labelId.setFont(font);
        labelMsg.setFont(font);
        tfSearch.setFont(font2);
        btnAdd.setFont(font);
        btnQuiz.setFont(font);
        btnAllList.setFont(font);
        btnSearch.setFont(font);
        btnMyPage.setFont(font);
        btnLogout.setFont(font);
        
        //add
        add(btnPick1);
        add(btnPick2);
        add(btnPick3);
        add(labelId);
        add(labelMsg);
        add(tfSearch);
        add(btnAdd);
        add(btnSearch);
        add(btnAllList);
        add(btnQuiz);
        add(btnMyPage);
        add(btnLogout);
        
        //add BookClickView
        for(int i=0; i<viewBookClick.length; i++) {
            viewBookClick[i] = new BookClickView();
            viewBookClick[i].setBounds(310*i+60, 100, 250, 500);
            add(viewBookClick[i]);
        }
        setBounds(400,100,1000,800); 
    }
}
