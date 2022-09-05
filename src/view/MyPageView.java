package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyPageView extends JFrame {
    public JLabel la_msg, la_grade, la_cash, la_point;
    public JButton  bt_update, bt_history, bt_cash, bt_logout, bt_back;
    public MyPageView() {
        setTitle("MypageView");
        setLayout(null);
        la_msg = new JLabel("id님 환영합니다.");
        la_grade = new JLabel("등급: VIP");
        la_cash = new JLabel("등급: 10000 원");
        la_point = new JLabel("잔여포인트: 7500 P");
        
        bt_update = new JButton("비밀번호 수정");
        bt_history = new JButton("이용 내역");
        bt_cash = new JButton("캐쉬 충전");
        bt_logout = new JButton("로그아웃");
        bt_back = new JButton("도서선택창으로");
//setBounds
        bt_back.setBounds(66,10,150,30);
        la_msg.setBounds(50, 50, 150, 30);
        la_grade.setBounds(50, 90, 150, 30);
        la_cash.setBounds(50, 140, 150, 30);
        la_point.setBounds(50, 190, 150, 30);
        
        bt_update.setBounds(66, 230, 150, 30);
        bt_history.setBounds(66, 280, 150, 30);
        bt_cash.setBounds(66, 330, 150, 30);
        bt_logout.setBounds(66, 380, 150, 30);
        
        add(la_msg);
        add(la_grade);
        add(la_cash);
        add(la_point);
        
        add(bt_update);
        add(bt_cash);
        add(bt_history);
        add(bt_logout);
        add(bt_back);
        
        setSize(300,500);
        setVisible(false);
    }
}