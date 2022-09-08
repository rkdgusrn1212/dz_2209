package view.book;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
public class BookPayView extends JFrame {
	public JTable table;
    public JLabel labelId, labelCash, labelPoint, labelLend, labelUsePoint;
    public JTextField tfPoint;
    public JButton btnPay, btnBack;
    public BookPayView() {
        setTitle("도서대여 결제");
        setLayout(null);
     
        //p_book
        labelId = new JLabel("회원 ID");
        labelCash = new JLabel("회원 보유 캐시");
        labelPoint = new JLabel("회원 보유 포인트");
        labelUsePoint= new JLabel("사용 포인트");
        labelLend = new JLabel("대여 가격");
        tfPoint = new JTextField(10);
        btnPay = new JButton("결제");
      	btnBack = new JButton("이전으로");
        
        labelId.setBounds(50, 30, 180, 50);
        labelCash.setBounds(50, 100, 180, 50);
        labelPoint.setBounds(50, 170, 180, 50);
        labelLend.setBounds(390, 30, 70, 50);
        labelUsePoint.setBounds(390, 100, 90, 50);
        tfPoint.setBounds(490, 110, 180, 35);
        btnPay.setBounds(390, 180, 135, 35);
        btnBack.setBounds(570, 180, 135, 35);
        
        Font font=new Font("맑은고딕", Font.BOLD, 16);
        labelId.setFont(font);
        labelCash.setFont(font);
        labelPoint.setFont(font);
        labelLend.setFont(font);
        labelUsePoint.setFont(font);
        tfPoint.setFont(font);
        btnPay.setFont(font);
        btnBack.setFont(font);
        
        add(labelId);
        add(labelCash);
        add(labelPoint);
        add(labelLend);
        add(labelUsePoint);
        add(tfPoint);
        add(btnPay);
        add(btnBack);

        
        setBounds(500,300,770,300);
        
    }
}
