package view.book;

import java.awt.Color;
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
        setTitle("BookSelectView");
        setLayout(null);
        //new   
        labelMsg = new JLabel("도서를 선택하세요");
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

        btnPick1.setBounds(150, 560, 80,30);
        btnPick2.setBounds(460, 560, 80,30);
        btnPick3.setBounds(770, 560, 80,30);
        labelId.setBounds(100, 20, 80, 30);
        labelMsg.setBounds(440, 20, 120, 30);
        tfSearch.setBounds(550, 700, 180, 30);
        btnAdd.setBounds(100, 700, 100, 30);
        btnQuiz.setBounds(250, 700, 100, 30);
        btnAllList.setBounds(400, 700, 100, 30);
        btnSearch.setBounds(730, 700, 100, 30);
        btnMyPage.setBounds(680, 20, 100, 30);
        btnLogout.setBounds(820, 20, 100, 30);
        
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
        setSize(1000,800);
    }
}
