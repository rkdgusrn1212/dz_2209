package view.book;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class BookPayView extends JFrame {
    public JPanel p_book, p_pay;
    public JLabel la_image, la_book, la_writer, la_price;
    public JTextArea ta_content;

    public JLabel labelId, labelGrade, labelPoint, la_lend, la_showpoint;
    public JTextField tf_point;
    public JButton btnPay, btnBack;

    public BookPayView() {
        setTitle("BookPayView");
        p_book = new JPanel();
        p_book.setBackground(Color.CYAN);
        p_pay = new JPanel();
        p_pay.setBackground(Color.BLUE);
        p_book.setLayout(null);
        //p_pay
        p_pay.setLayout(null);
        labelId = new JLabel("회원 id");
        labelGrade = new JLabel("회원 등급");
        labelPoint = new JLabel("회원 포인트");
        la_lend = new JLabel("대여금액: 2000원");
        la_showpoint = new JLabel("사용 포인트: ");
        tf_point = new JTextField(10);
        btnPay = new JButton("결제");
        btnBack = new JButton("도서선택창");

        labelId.setBounds(50, 50, 100, 30);
        labelGrade.setBounds(50, 120, 100, 30);
        labelPoint.setBounds(50, 190, 100, 30);
        p_pay.add(labelId);
        p_pay.add(labelGrade);
        p_pay.add(labelPoint);
        la_lend.setBounds(300, 50, 100, 30);
        la_showpoint.setBounds(300, 120, 100, 30);
        tf_point.setBounds(400, 120, 100, 30);
        btnPay.setBounds(300, 200, 100, 30);
        btnBack.setBounds(480, 200, 100, 30);
        p_pay.add(la_lend);
        p_pay.add(la_showpoint);
        p_pay.add(tf_point);
        p_pay.add(btnBack);
        p_pay.add(btnPay);

        //p_book
        la_image = new JLabel("도서 이미지");
        la_book = new JLabel("도서명");
        ta_content = new JTextArea();
        la_price = new JLabel("도서 원가");
        la_writer = new JLabel("작가명");
        la_image.setBounds(50, 30, 200, 200);
        la_book.setBounds(300, 50, 100, 30);
        la_writer.setBounds(300, 100, 100, 30);
        la_price.setBounds(300, 150, 100, 30);
        ta_content.setBounds(500, 30, 200, 200);
        p_book.add(la_image);
        p_book.add(la_book);
        p_book.add(la_price);
        p_book.add(la_writer);
        p_book.add(ta_content);

        p_book.setPreferredSize(new Dimension(0, 270));
        add(p_book, BorderLayout.PAGE_START);
        add(p_pay, BorderLayout.CENTER);

        setSize(800,600);
        setVisible(false);
    }
    public static void main(String[] args) {
        new BookPayView();
    }
}
