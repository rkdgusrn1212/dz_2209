package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class CashView extends JFrame{
    public JLabel la_msg, la_nowcash, la_aftercash;
    public JButton bt_submit, bt_back;
    public JTextField tf_cash;
    public CashView() {
        setTitle("CashView");
        setLayout(null);
        la_msg = new JLabel("충전할 금액을 입력하세요");
        la_nowcash = new JLabel("현재 캐시: 10000원");
        la_aftercash = new JLabel("충전 후 캐시: 10000원");
        tf_cash = new JTextField("충전 금액");
        bt_submit = new JButton("충전");
        bt_back = new JButton("취소");
        
        la_msg.setBounds(30, 30, 150, 30);
        la_nowcash.setBounds(30, 60, 150, 30);
        tf_cash.setBounds(30, 90, 150, 30);
        la_aftercash.setBounds(30,120,150,30);
        bt_submit.setBounds(10, 150, 100, 30);
        bt_back.setBounds(150, 150, 100, 30);
        
        add(la_msg);
        add(la_nowcash);
        add(la_aftercash);
        add(tf_cash);
        add(bt_submit);
        add(bt_back);
        
        
        setSize(300,300);
    }
      public void showMsg(String msg) {
      JOptionPane.showMessageDialog(this, msg);
     }
}
