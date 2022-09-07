package view.member;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import view.quiz.AddQuizView;
public class CashView extends JFrame{
  
  //객체 선언
    public JLabel labelMsg, labelNowcash, labelAftercash;
    public JButton btnSubmit, btnBack;
    public JTextField tfCash;
   
    public CashView() {
    
        setTitle("CashView");
        setLayout(null);
        labelMsg = new JLabel("충전할 금액을 입력하세요");
        labelNowcash = new JLabel("현재 캐시: 10000");
        labelAftercash = new JLabel("충전 후 캐시: ");
        tfCash = new JTextField("");
        btnSubmit = new JButton("충전");
        btnBack = new JButton("취소");
        
        //각각의 사이즈 위치설정 및 내용 띄우기
        labelMsg.setBounds(65, 40, 150, 30);
        labelNowcash.setBounds(80, 70, 150, 30);
        tfCash.setBounds(60, 100, 150, 30);
        labelAftercash.setBounds(75,130,150,30);
        btnSubmit.setBounds(20, 190, 100, 30);
        btnBack.setBounds(160, 190, 100, 30);
        add(labelMsg);
        add(labelNowcash);
        add(labelAftercash);
        add(tfCash);
        add(btnSubmit);
        add(btnBack);
        
        
        //메인 창 출력 위치
        setBounds(800,300,300,300);
        setVisible(true);
        
        
        
        //버튼클릭시 화면 전환       
        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "충전되었습니다.");
            }
            
        });
        
        
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MyPageView();
                setVisible(false);
                
            }
            
        });
        
              
    }
    public void showMsg(String msg) {
        JOptionPane.showMessageDialog(this, msg);
    }
    
    public static void main(String[] args) {
        new CashView().setVisible(true);
    }
}
