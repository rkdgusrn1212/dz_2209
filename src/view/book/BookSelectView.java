package view.book;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import view.member.CashView;
import view.member.MyPageView;
public class BookSelectView extends JFrame {
    public JLabel labelMsg, labelId;
    public JButton btnSelect, btnGenre, btnBack;
    public BookClickView[] viewBookClick;
    public JButton btnMyPage, btnLogout;
    public BookSelectView() {
        setTitle("BookSelectView");
        setLayout(null);
        //new   
        labelMsg = new JLabel("도서를 선택하세요");
        labelId = new JLabel("id");
        btnSelect = new JButton("도서 선택");
        btnGenre = new JButton("장르 선택");
//        btnBack = new JButton("로그 아웃");
        
        viewBookClick = new BookClickView[3];
        btnMyPage = new JButton("마이페이지");
        btnLogout = new JButton("로그아웃");
    
        //setBounds
        labelId.setBounds(100, 20, 80, 30);
        labelMsg.setBounds(500, 20, 120, 30);
        btnSelect.setBounds(250, 700, 100, 30);
        btnGenre.setBounds(580, 700, 100, 30);
        btnMyPage.setBounds(680, 20, 100, 30);
        btnLogout.setBounds(820, 20, 100, 30);
        
        //add
        add(labelId);
        add(labelMsg);
        add(btnSelect);
        add(btnGenre);
        add(btnMyPage);
        add(btnLogout);
        
        //add BookClickView
        for(int i=0; i<viewBookClick.length; i++) {
            viewBookClick[i] = new BookClickView();
            viewBookClick[i].setBounds(310*i+60, 100, 250, 500);
            add(viewBookClick[i]);
        }
        setBounds(500,100,1000,800);
        setVisible(true);
        
        //버튼클릭시 화면 전환       
        btnSelect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "도서가 선택되었습니다");
                new BookPayView();
                setVisible(false);
            }        
        });
        
        btnGenre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {               
                new BookGenreView();
                setVisible(false); 
            }
        });
        
        btnMyPage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MyPageView();
                setVisible(false);              
            }        
        });
        
        btnLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {               
                JOptionPane.showMessageDialog(null, "로그아웃되었습니다");
                System.exit(0);
            }
        });
        
    }
    public static void main(String[] args) {
        new BookSelectView().setVisible(true);
    }
}