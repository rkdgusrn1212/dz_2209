package view.book;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import view.member.MyPageView;
public class BookGenreView extends JFrame {
    public JLabel labelMsg;
    public JRadioButton rBtnFiction, rBtnAssay, rBtnThriller;
    public ButtonGroup btnGroup;
    public JButton btnSelect;
    public BookGenreView() {
        setTitle("BookGenreView");
        setLayout(null);
        //new
        labelMsg = new JLabel("장르를 선택하세요");
        rBtnFiction = new JRadioButton("소설");
        rBtnAssay = new JRadioButton("수필");
        rBtnThriller = new JRadioButton("스릴러");
        btnGroup = new ButtonGroup();
        btnSelect = new JButton("장르 선택");
        btnGroup.add(rBtnFiction);
        btnGroup.add(rBtnAssay);
        btnGroup.add(rBtnThriller);
        //setBounds
        labelMsg.setBounds(90, 30, 120, 30);
        rBtnFiction.setBounds(20, 100 , 80, 30);
        rBtnAssay.setBounds(115, 100 , 80, 30);
        rBtnThriller.setBounds(200, 100 , 80, 30);
        btnSelect.setBounds(90, 200, 100, 30);
        // frame
        add(labelMsg);
        add(rBtnFiction);
        add(rBtnAssay);
        add(rBtnThriller);
        add(btnSelect);
        
        //메인 창 출력 위치
        rBtnFiction.setSelected(true);
        setBounds(800,300,300,300);
        setVisible(true);
        
        //버튼클릭시 화면 전환  
        btnSelect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {               
                JOptionPane.showMessageDialog(null, "장르가 선택되었습니다"); 
                new BookSelectView();
                setVisible(false); 
            }
        });      
        
    }
  
    public static void main(String[] args) {
        new BookGenreView().setVisible(true);
    }
    
}
