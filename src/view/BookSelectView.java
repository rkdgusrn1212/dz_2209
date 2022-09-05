package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BookSelectView extends JFrame {
    public JLabel la_msg, la_id;
    public JButton bt_select, bt_genre, bt_back;
    public BookClickView[] v_bc;
    public JButton bt_mypage, bt_logout;
    public BookSelectView() {
        setTitle("BookSelectView");
        setLayout(null);
//new   
        la_msg = new JLabel("도서를 선택하세요");
        la_id = new JLabel("id");
        bt_select = new JButton("도서 선택");
        bt_genre = new JButton("장르 선택");
        bt_back = new JButton("로그 아웃");
        v_bc = new BookClickView[3];
        bt_mypage = new JButton("마이페이지");
        bt_logout = new JButton("로그아웃");
//setBounds
        la_id.setBounds(100, 20, 80, 30);
        la_msg.setBounds(500, 20, 120, 30);
        bt_select.setBounds(250, 700, 100, 30);
        bt_genre.setBounds(580, 700, 100, 30);
        bt_mypage.setBounds(680, 20, 100, 30);
        bt_logout.setBounds(820, 20, 100, 30);
//add
        add(la_id);
        add(la_msg);
        add(bt_select);
        add(bt_genre);
        add(bt_mypage);
        add(bt_logout);
//add BookClickView
        for(int i=0; i<v_bc.length; i++) {
            v_bc[i] = new BookClickView();
            v_bc[i].setBounds(310*i+60, 100, 250, 500);
            add(v_bc[i]);
        }
        
        setSize(1000,800);
        setVisible(false);
    }
}