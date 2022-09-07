package view.book;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
public class BookPayView extends JFrame {
    public JPanel panelBook, panelPay;
    public JLabel labelImage, labelBook, labelWriter, labelPrice;
    public JTextArea taContent;
    public JLabel labelId, labelGrade, labelPoint, labelLend, labelShowPoint;
    public JTextField tfPoint;
    public JButton btnPay, btnBack;
    public BookPayView() {
        setTitle("BookPayView");
        panelBook = new JPanel();
        panelBook.setBackground(Color.CYAN);
        panelPay = new JPanel();
        panelPay.setBackground(Color.white);
        panelBook.setLayout(null);
        
        //p_pay
        panelPay.setLayout(null);
        labelId = new JLabel("회원 id");
        labelGrade = new JLabel("회원 등급");
        labelPoint = new JLabel("회원 포인트");
        labelLend = new JLabel("대여금액: 2000원");
        labelShowPoint = new JLabel("사용 포인트: ");
        tfPoint = new JTextField(10);
        btnPay = new JButton("결제");
        btnBack = new JButton("도서선택창");
        labelId.setBounds(50, 50, 100, 30);
        labelGrade.setBounds(50, 120, 100, 30);
        labelPoint.setBounds(50, 190, 100, 30);
        panelPay.add(labelId);
        panelPay.add(labelGrade);
        panelPay.add(labelPoint);
        labelLend.setBounds(300, 50, 100, 30);
        labelShowPoint.setBounds(300, 120, 100, 30);
        tfPoint.setBounds(400, 120, 100, 30);
        btnPay.setBounds(300, 200, 100, 30);
        btnBack.setBounds(480, 200, 100, 30);
        panelPay.add(labelLend);
        panelPay.add(labelShowPoint);
        panelPay.add(tfPoint);
        panelPay.add(btnBack);
        panelPay.add(btnPay);
        //p_book
        labelImage = new JLabel("도서 이미지");
        labelBook = new JLabel("도서명");
        taContent = new JTextArea();
        labelPrice = new JLabel("도서 원가");
        labelWriter = new JLabel("작가명");
        labelImage.setBounds(50, 30, 200, 200);
        labelBook.setBounds(300, 50, 100, 30);
        labelWriter.setBounds(300, 100, 100, 30);
        labelPrice.setBounds(300, 150, 100, 30);
        taContent.setBounds(500, 30, 200, 200);
        panelBook.add(labelImage);
        panelBook.add(labelBook);
        panelBook.add(labelPrice);
        panelBook.add(labelWriter);
        panelBook.add(taContent);
        panelBook.setPreferredSize(new Dimension(0, 270));
        add(panelBook, BorderLayout.PAGE_START);
        add(panelPay, BorderLayout.CENTER);
        setBounds(500,200,750,600);
        setVisible(true);
        
        
        //버튼클릭시 화면 전환 
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new BookSelectView();
                setVisible(false);              
            }        
        });
        
        btnPay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {               
                JOptionPane.showMessageDialog(null, "결제되었습니다");
            }
        });
        
        
    }
    public static void main(String[] args) {
        new BookPayView().setVisible(true);
    }
}
