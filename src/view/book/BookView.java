package view.book;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import view.member.MyPageView;
public class BookView extends JFrame{
    JLabel labelBook, labelName, labelWriter, labelPrice, labelSummary;
    JButton btnBack, btnPay;
    JPanel panelBook;
    
//    JTable table; //검색과 전체 보기를 위한 테이블 객체 생성
    public BookView() {
        getContentPane().setLayout(null);
        labelBook = new JLabel("도서 상세 보기");
        labelName = new JLabel("도서명");
        labelWriter = new JLabel("저자명");
        labelPrice = new JLabel("원가");
        labelSummary = new JLabel("줄거리");
        btnBack = new JButton("메인페이지");
        btnPay = new JButton("결제");
        panelBook = new JPanel();
        
        // setBounds
        panelBook.setBounds(133, 54, 1164, 615);
        btnBack.setBounds(20, 13, 105, 27);
        btnPay.setBounds(150, 13, 105, 27);
        labelBook.setBounds(450, 12, 105, 28);
        labelName.setBounds(40, 100, 105, 28);
        labelPrice.setBounds(40, 170, 105, 27);
        labelWriter.setBounds(40, 240, 50, 28);
        labelSummary.setBounds(40, 310, 50, 28);
        
        
        //테이블 객체 생성
        add(new JScrollPane(panelBook = new JPanel()), "Center");
        getContentPane().add(labelBook);
        getContentPane().add(btnBack);
        getContentPane().add(panelBook);
        add(btnPay);
        add(labelName);
        add(labelWriter);
        add(labelPrice);
        add(labelSummary);
        
        setBounds(500,200,1000,700);
        
        
    }
} 
