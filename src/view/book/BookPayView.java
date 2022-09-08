package view.book;
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
        setTitle("BookPayView");
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
        
        labelId.setBounds(50, 30, 50, 50);
        labelCash.setBounds(50, 100, 80, 50);
        labelPoint.setBounds(50, 170, 90, 50);
        labelLend.setBounds(350, 30, 70, 50);
        labelUsePoint.setBounds(350, 100, 90, 50);
        tfPoint.setBounds(430, 110, 120, 30);
        btnPay.setBounds(350, 190, 100, 30);
        btnBack.setBounds(510, 190, 100, 30);
        
        add(labelId);
        add(labelCash);
        add(labelPoint);
        add(labelLend);
        add(labelUsePoint);
        add(tfPoint);
        add(btnPay);
        add(btnBack);

        
        setBounds(500,200,700,300);
        
    }
}
