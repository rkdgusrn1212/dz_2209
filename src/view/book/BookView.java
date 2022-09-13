package view.book;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import view.View;

public class BookView extends View{
    public JLabel labelViewTitle, labelName, labelWriter, labelPrice, labelSummary, labelImage;
    public JTextField tfName, tfWriter, tfPrice;
    public JScrollPane spSummary;
    public JTextArea taSummary;
    public JButton btnBack, btnPay, btnUpdate, btnDelete, btnReturn;
    
//    JTable table; //검색과 전체 보기를 위한 테이블 객체 생성
    public BookView() {
    	setTitle("도서상세보기");
        setLayout(null);
        labelImage = new JLabel("이미지삽입예정 210*297");
        labelViewTitle = new JLabel("도서 상세");
        labelViewTitle.setAlignmentX(CENTER_ALIGNMENT);
        labelViewTitle.setFont(new Font("맑은고딕", Font.BOLD, 32));
        labelName = new JLabel("도서명");
        labelWriter = new JLabel("저자명");
        labelPrice = new JLabel("원가");
        labelSummary = new JLabel("줄거리");
        btnBack = new JButton("이전");
        btnUpdate = new JButton("수정");
        btnUpdate.setVisible(false);//기본은 꺼둠. 오직 등록자만이 볼수 있음.
        btnDelete = new JButton("삭제");
        btnDelete.setVisible(false);//기본은 꺼둠. 오직 등록자만이 볼수 있음.
        btnReturn = new JButton("반납");
        btnReturn.setVisible(false);
        btnPay = new JButton("결제");
        tfName = new JTextField();
        tfName.setFocusable(false);
        tfWriter = new JTextField();
        tfWriter.setFocusable(false);
        tfPrice = new JTextField();
        tfPrice.setFocusable(false);
        spSummary = new JScrollPane(taSummary = new JTextArea());
        taSummary.setLineWrap(true);
        taSummary.setFocusable(false);
        
        // setBounds
        btnUpdate.setBounds(600, 20, 65, 35);
        btnDelete.setBounds(670, 20, 65, 35);
        btnBack.setBounds(740, 20, 65, 35);
        btnPay.setBounds(830, 20, 130, 35);
        btnReturn.setBounds(830, 20, 130, 35);
        labelViewTitle.setBounds(400, 12, 200, 35);
        labelName.setBounds(40, 120, 105, 35);
        tfName.setBounds(160, 120, 250, 35);
        labelWriter.setBounds(40, 200, 50, 35);
        tfWriter.setBounds(160, 200, 250, 35);
        labelPrice.setBounds(40, 280, 105, 35);
        tfPrice.setBounds(160, 280, 250, 35);
        labelSummary.setBounds(40, 360, 50, 35);
        spSummary.setBounds(160, 360, 250, 200);
        labelImage.setBounds(570, 90, 353, 500);
        
        Font font=new Font("맑은고딕", Font.BOLD, 16);
        Font fontSmall=new Font("맑은고딕", Font.BOLD, 14);
        btnUpdate.setFont(fontSmall);
        btnDelete.setFont(fontSmall);
        btnBack.setFont(fontSmall);
        btnPay.setFont(font);
        btnReturn.setFont(font);
        labelName.setFont(font);
        labelPrice.setFont(font);
        labelWriter.setFont(font);
        labelSummary.setFont(font);
        tfName.setFont(font);
        tfPrice.setFont(font);
        tfWriter.setFont(font);
        taSummary.setFont(font);
        //테이블 객체 생성
        add(labelViewTitle);
        add(btnBack);
        add(btnPay);
        add(btnReturn);
        add(btnUpdate);
        add(btnDelete);
        add(labelName);
        add(labelWriter);
        add(labelPrice);
        add(labelSummary);
        add(labelImage);
        add(tfName);
        add(tfWriter);
        add(tfPrice);
        add(spSummary);
        
        setBounds(500,200,1000,700);
        
    }
} 
