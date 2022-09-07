package view.book;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import view.View;

public class BookSelectView extends View {
    public JLabel la_msg, labelId;
    public JButton btnSelect, btnGenre, bt_back;
    public BookClickView[] viewBookClick;
    public JButton btnMyPage, btnLogout;
    public BookSelectView() {
        setTitle("BookSelectView");
        setLayout(null);
        //new   
        la_msg = new JLabel("도서를 선택하세요");
        labelId = new JLabel("id");
        btnSelect = new JButton("도서 선택");
        btnGenre = new JButton("장르 선택");
        bt_back = new JButton("로그 아웃");
        viewBookClick = new BookClickView[3];
        btnMyPage = new JButton("마이페이지");
        btnLogout = new JButton("로그아웃");
        //setBounds
        labelId.setBounds(100, 20, 80, 30);
        la_msg.setBounds(500, 20, 120, 30);
        btnSelect.setBounds(250, 700, 100, 30);
        btnGenre.setBounds(580, 700, 100, 30);
        btnMyPage.setBounds(680, 20, 100, 30);
        btnLogout.setBounds(820, 20, 100, 30);
        //add
        add(labelId);
        add(la_msg);
        add(btnSelect);
        add(btnGenre);
        add(btnMyPage);
        add(btnLogout);
        //add BookClickView
        for(int i=0; i<viewBookClick.length; i++) {
            viewBookClick[i] = new BookClickView();
            viewBookClick[i].setBounds(310*i+60, 100, 250, 500);
            add(viewBookClick[i]);
        }

        setSize(1000,800);
        setVisible(false);
    }
}