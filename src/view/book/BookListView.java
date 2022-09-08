package view.book;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.vo.Book;
import view.View;


public class BookListView extends View{
	DefaultTableModel dtm;
	public JTable table;
	public JScrollPane sp;
	
    public JLabel labelMsg;
    public ButtonGroup btnGroup;
    public JButton btnBack;//누르면 북 셀렉트 뷰로 돌아감
    Object rowData[][]= new String[0][4];
    Object columnnames[] = {"제목", "저자", "카테고리", "대여여부"};
    
    public BookListView() {
        setTitle("BookListView");
        setLayout(null);
        
        
        // 도서 리스트 테이블 생성
        dtm = new DefaultTableModel(rowData,columnnames);
        table = new JTable(dtm);
        sp = new JScrollPane(table);
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
    //displayTable
    public void displayTable(ArrayList<Book> list) {
           dtm.setRowCount(0);//출력될 시작행의 위치 0 ---> 첫번째행
             
           for(int i=0; i< list.size(); i++) {
           Book b = list.get(i);
           Object rowData[]= {b.getBname(),b.getWriter(),b.getCategory(),b.getPrent()};
           dtm.addRow(rowData);
           }//for
        }  
}
