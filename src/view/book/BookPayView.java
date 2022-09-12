package view.book;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;

import view.View;
public class BookPayView extends View { // 수정
	public JTable table;
    public JLabel labelId, labelCash, labelLend, labelUseCash;
    public JTextField tfPoint;
    public JButton btnPay, btnBack, btnCash;
    public BookPayView() {
        setTitle("도서대여 결제");
        setLayout(null);
     
        //p_book
        labelId = new JLabel("회원 ID");
        labelCash = new JLabel("회원 보유 캐시");
        labelUseCash= new JLabel("결제 후 보유 캐시");
        labelLend = new JLabel("대여 가격");
        btnPay = new JButton("결제");
      	btnBack = new JButton("이전으로");
      	btnCash = new JButton("캐시 충전");
        
        labelId.setBounds(50, 30, 180, 50);
        labelCash.setBounds(50, 100, 180, 50);
        labelLend.setBounds(390, 30, 70, 50);
        labelUseCash.setBounds(390, 100, 150, 50);
        btnPay.setBounds(400, 180, 135, 35);
        btnBack.setBounds(570, 180, 135, 35);
        btnCash.setBounds(230, 180, 135, 35);
        
        Font font=new Font("맑은고딕", Font.BOLD, 16);
        labelId.setFont(font);
        labelCash.setFont(font);
        labelLend.setFont(font);
        labelUseCash.setFont(font);
        btnPay.setFont(font);
        btnBack.setFont(font);
        btnCash.setFont(font);
        
        add(labelId);
        add(labelCash);
        add(labelLend);
        add(labelUseCash);
        add(btnPay);
        add(btnBack);
        add(btnCash);

        
        setBounds(500,300,770,300);
        
    }
}
