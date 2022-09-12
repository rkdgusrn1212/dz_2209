package view.book;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import view.View;

public class BookView extends View{
    public JLabel labelBook, labelName, labelWriter, labelPrice, labelSummary, labelImage;
    public JButton btnBack, btnPay;
    
//    JTable table; //검색과 전체 보기를 위한 테이블 객체 생성
    public BookView() {
    	setTitle("도서상세보기");
        setLayout(null);
        labelImage = new JLabel("이미지삽입예정 210*297");
        labelBook = new JLabel("도서 상세 보기");
        labelName = new JLabel("도서명");
        labelWriter = new JLabel("저자명");
        labelPrice = new JLabel("원가");
        labelSummary = new JLabel("줄거리");
        btnBack = new JButton("메인페이지");
        btnPay = new JButton("결제");
        
        // setBounds
        btnBack.setBounds(680, 20, 130, 35);
        btnPay.setBounds(830, 20, 130, 35);
        labelBook.setBounds(450, 12, 105, 35);
        labelName.setBounds(40, 120, 105, 35);
        labelPrice.setBounds(40, 280, 105, 35);
        labelWriter.setBounds(40, 200, 50, 35);
        labelSummary.setBounds(40, 360, 50, 35);
        labelImage.setBounds(680, 120, 210, 297);
        
        Font font=new Font("맑은고딕", Font.BOLD, 16);
        btnBack.setFont(font);
        btnPay.setFont(font);
        labelBook.setFont(font);
        labelName.setFont(font);
        labelPrice.setFont(font);
        labelWriter.setFont(font);
        labelSummary.setFont(font);
        
        //테이블 객체 생성
        add(labelBook);
        add(btnBack);
        add(btnPay);
        add(labelName);
        add(labelWriter);
        add(labelPrice);
        add(labelSummary);
        add(labelImage);
        
        setBounds(500,200,1000,700);
        
    }
} 
