package view.book;


import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import view.View;


public class BookListView extends View{
    
	public JScrollPane sp;
	public JTable table;
    public JLabel labelMsg;
    public ButtonGroup btnGroup;
    public JButton btnBack;//누르면 북 셀렉트 뷰로 돌아감
    
    public BookListView() {
        setTitle("도서 목록 조회");
        
        sp = new JScrollPane(table = new JTable());
        table.setFillsViewportHeight(true);
        
        // 버튼 생성
        btnBack= new JButton("이전메뉴");
        labelMsg = new JLabel("도서 목록 조회");
        
        //setBounds
        sp.setBounds(20, 50, 640, 540); // 도서 리스트 테이블
        btnBack.setBounds(20, 600, 130, 35);
        labelMsg.setBounds(300, 10, 120, 30);
        
        Font font=new Font("맑은고딕", Font.BOLD, 16);
        btnBack.setFont(font);
        labelMsg.setFont(font);
        
        //add
        add(sp);
        add(btnBack);
        add(labelMsg);
        
        //메인 창 출력 위치
        setBounds(550,200,700,700);
        
    }
}
