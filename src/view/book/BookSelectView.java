package view.book;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import view.member.MyPageView;

public class BookSelectView extends JFrame {
    public JLabel labelMsg, labelId;
    public JButton btnSelect, btnGenre, btnAddBook;
    public BookClickView[] viewBookClick;
    public JButton btnMyPage, btnLogout;
    public BookSelectView() {
        setTitle("BookSelectView");
        setLayout(null);
        
        //new   
        labelId = new JLabel("id");
        labelMsg = new JLabel("도서를 선택하세요");
        btnMyPage = new JButton("마이페이지");
        btnLogout = new JButton("로그아웃");
        
        btnSelect = new JButton("도서 선택");
        btnGenre = new JButton("장르 선택");
        btnAddBook = new JButton("도서 등록");
        viewBookClick = new BookClickView[3];
        
       
        //setBounds
        labelId.setBounds(100, 20, 80, 30);
        labelMsg.setBounds(500, 20, 120, 30);
        
        btnMyPage.setBounds(680, 20, 100, 30);
        btnLogout.setBounds(820, 20, 100, 30);
        
        btnSelect.setBounds(250, 700, 100, 30);
        btnGenre.setBounds(400, 700, 100, 30);
        btnAddBook.setBounds(600, 700, 100, 30);
        
        
        //add
        add(labelId);
        add(labelMsg);
        
        add(btnMyPage);
        add(btnLogout);
        
        add(btnSelect);
        add(btnGenre);
        add(btnAddBook);
        
        
        //add BookClickView
        for(int i=0; i<viewBookClick.length; i++) {
            viewBookClick[i] = new BookClickView();
            viewBookClick[i].setBounds(310*i+60, 100, 250, 500);
            add(viewBookClick[i]);
        }
        
        
        //이벤트 (버튼 클릭시 화면전환)
        //마이페이지
        btnMyPage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MyPageView();
                setVisible(false);
            }
        });
        
        //도서 선택
        btnSelect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new BookClickView();
            }
        });
        
        //장르 선택
        btnGenre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new BookGenreView();
            }
        });
        
        //도서 등록
        btnAddBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddBookView();
            }
        });

        setSize(1000,800);
        setVisible(true);
        
        
    }
    
    public static void main(String[] args) {
        new BookSelectView().setVisible(true);
    }
}