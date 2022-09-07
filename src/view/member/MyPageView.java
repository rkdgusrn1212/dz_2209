package view.member;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.vo.Member;
import view.book.BookSelectView;
import view.history.HistoryView;

public class MyPageView extends JFrame {
    public JLabel labelMsg, labelGrade, labelCash, labelPoint;
    public JButton  btnIdPwFind, btnUpdate, btnHistory, btnCash, btnLogout, btnBack;
    
    public MyPageView() {
        setTitle("MypageView");
        setLayout(null);
        labelMsg = new JLabel("membername + 님 환영합니다.");
        labelGrade = new JLabel("등급: VIP");
        labelCash = new JLabel("등급: 10000 원");
        labelPoint = new JLabel("잔여포인트: 7500 P");
        
        
        //button
        btnBack = new JButton("도서선택창으로");
        btnIdPwFind = new JButton("ID/PW 찾기");
        btnUpdate = new JButton("비밀번호 수정");
        btnHistory = new JButton("이용내역 조회");
        btnCash = new JButton("캐쉬 충전");
        btnLogout = new JButton("로그아웃");
        
        
        //setBounds
        btnBack.setBounds(66,10,150,30);
//        labelMsg.setBounds(10, 50, 500, 30);
        labelMsg.setHorizontalAlignment(JLabel.CENTER);
        labelGrade.setBounds(50, 90, 150, 30);
        labelCash.setBounds(50, 140, 150, 30);
        labelPoint.setBounds(50, 190, 150, 30);

        btnIdPwFind.setBounds(66, 190, 150, 30);
        btnUpdate.setBounds(66, 230, 150, 30);
        btnHistory.setBounds(66, 280, 150, 30);
        btnCash.setBounds(66, 330, 150, 30);
        btnLogout.setBounds(66, 380, 150, 30);

        add(btnBack);
        add(labelMsg);
        add(labelGrade);
        add(labelCash);
        add(labelPoint);

        add(btnIdPwFind);
        add(btnUpdate);
        add(btnCash);
        add(btnHistory);
        add(btnLogout);

//        setSize(800,800);
        setBounds(800,100,300,600);
        setVisible(true);
        
        
        
        //이벤트 (버튼 클릭시 화면전환)
        //도서선택창으로
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new BookSelectView();
                setVisible(false);
            }
        });
        
        //ID/PW 찾기
        btnIdPwFind.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FindIdPass();
            }
        });
        
        //비밀번호 수정
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PwdUpdateView();
            }
        });

        //이용내역 조회
        btnHistory.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new HistoryView();
            }
        });
        
        //캐쉬 충전
        btnCash.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CashView();
            }
        });
        
    }
    
    public static void main(String[] args) {
        new MyPageView().setVisible(true);
    }
    
    //showInputMsg
    public String showInputMsg(String msg) { return JOptionPane.showInputDialog(this, msg);}
    
}