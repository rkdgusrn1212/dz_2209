package view.member;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import view.View;
public class CashView extends View{
  
  //객체 선언
    public JLabel labelMsg, labelNowcash, labelAftercash;
    public JButton btnSubmit, btnBack;
    public JTextField tfCash;
   
    public CashView() {
        setTitle("캐시충전");
        setLayout(null);
        labelMsg = new JLabel("충전 금액");
        labelNowcash = new JLabel("");
        //labelAftercash = new JLabel("충전 후 캐시: "); //충전 후 캐시는 팝업으로 띄워주는게 나을듯?
        tfCash = new JTextField("");
        btnSubmit = new JButton("충전");
        btnBack = new JButton("취소");
        
        labelMsg.setBounds(30, 98, 300, 35);
        labelNowcash.setBounds(30, 40, 200, 35);
        tfCash.setBounds(120, 100, 180, 30);
        //labelAftercash.setBounds(30, 160,200,35);
        btnSubmit.setBounds(30, 220, 130, 35);
        btnBack.setBounds(250, 220, 130, 35);
        add(labelMsg);
        add(labelNowcash);
        //add(labelAftercash);
        add(tfCash);
        add(btnSubmit);
        add(btnBack);
        
        Font font=new Font("맑은고딕", Font.BOLD, 16);
        labelMsg.setFont(font);
        labelNowcash.setFont(font);
        //labelAftercash.setFont(font);
        tfCash.setFont(font);
        btnSubmit.setFont(font);
        btnBack.setFont(font);
        
        //메인 창 출력 위치
        setBounds(800,300,425,350);
        
        
        
              
    }
    public void showMsg(String msg) {
        JOptionPane.showMessageDialog(this, msg);
    }
    public static void main(String[] args) {
		new CashView().setVisible(true);
	}
}
