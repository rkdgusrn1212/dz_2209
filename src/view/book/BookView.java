package view.book;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import view.View;
import view.member.MyPageView;
public class BookView extends View{
    JLabel labelBook ;
    public JButton btnBack ;
    JButton btnNext ;
    JButton btnPrev;
    JPanel panelBook ;
//    JTable table; //검색과 전체 보기를 위한 테이블 객체 생성
    
    public BookView() {
        getContentPane().setLayout(null);
        labelBook = new JLabel("책 제목");
        btnBack = new JButton("메인페이지");
        panelBook = new JPanel();
        btnPrev = new JButton("이전");
        btnNext = new JButton("다음");
        panelBook.setBounds(133, 54, 1164, 615);
        btnBack.setBounds(14, 13, 105, 27);
        btnPrev.setBounds(14, 500, 105, 68);
        labelBook.setBounds(450, 12, 640, 28);
        btnNext.setBounds(850, 500, 105, 68);
        //테이블 객체 생성
//        add(new JScrollPane(table = new JTable()), "Center");
        add(new JScrollPane(panelBook = new JPanel()), "Center");
        
        getContentPane().add(labelBook);
        getContentPane().add(btnBack);
        getContentPane().add(panelBook);
        getContentPane().add(btnPrev);
        getContentPane().add(btnNext);
        
        setBounds(500,200,1000,700);
        
    }
    
    public static void main(String[] args) {
        new BookView();
    }
} 