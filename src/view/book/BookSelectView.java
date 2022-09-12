package view.book;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import view.View;

public class BookSelectView extends View {
    public JLabel labelMsg, labelId;
    public JButton btnAdd, btnAllList, btnSearch, btnMyPage, btnLogout;
    public BookClickView[] viewBookClick;
    public JTextField tfSearch;
    public JComboBox<String> cbSearchBook;
    String books[] = {"도서명", "저자명", "분류", "ISBN"};
    
    public BookSelectView() {
        setTitle("메인페이지");
        setLayout(null);
        //new
        labelMsg = new JLabel("추천 도서");
        labelId = new JLabel("id");
        tfSearch = new JTextField("입력");
        btnAdd = new JButton("도서 등록");
        btnAllList = new JButton("전체 목록");
        btnSearch = new JButton("도서 검색");
        viewBookClick = new BookClickView[3];
        btnMyPage = new JButton("마이페이지");
        btnLogout = new JButton("로그아웃");
        cbSearchBook = new JComboBox<>(books);
        
        
        //setBounds

        labelId.setBounds(70, 40, 120, 35);
        labelMsg.setBounds(460, 50, 180, 35);
        tfSearch.setBounds(609, 700, 210, 35);
        btnAdd.setBounds(80, 700, 130, 35);
        btnAllList.setBounds(290, 700, 130, 35); //420
        btnSearch.setBounds(820, 700, 130, 35);
        btnMyPage.setBounds(670, 20, 130, 35);
        btnLogout.setBounds(820, 20, 130, 35);
        cbSearchBook.setBounds(495, 700, 110, 35);
        
        
        Font font=new Font("맑은고딕", Font.BOLD, 16);
        Font font2=new Font("맑은고딕", Font.ITALIC, 16);
        labelMsg.setFont(font);
        labelId.setFont(font);
        labelMsg.setFont(font);
        tfSearch.setFont(font2);
        btnAdd.setFont(font);
        btnAllList.setFont(font);
        btnSearch.setFont(font);
        btnMyPage.setFont(font);
        btnLogout.setFont(font);
        cbSearchBook.setFont(font);
        
        //add
        add(labelId);
        add(labelMsg);
        add(tfSearch);
        add(btnAdd);
        add(btnSearch);
        add(btnAllList);
        add(btnMyPage);
        add(btnLogout);
        add(cbSearchBook);
        
        //add BookClickView
        for(int i=0; i<viewBookClick.length; i++) {
            viewBookClick[i] = new BookClickView();
            viewBookClick[i].setBounds(310*i+60, 100, 250, 500);
            add(viewBookClick[i]);
        }
        setBounds(400,100,1000,800); 
    }
}
