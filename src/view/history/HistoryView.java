package view.history;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import view.member.MyPageView;
import view.quiz.QuizView;

public class HistoryView extends JFrame {
	public static void main(String[] args) {
		new HistoryView().setVisible(true);
	}
    DefaultTableModel dtm;
    public JTable table;
    public JButton btnBack, btnQuiz, btnRead;
    public JLabel labelMsg;
    Object rowData[][]= new String[0][3];
    Object columnnames[] = {"ISBN", "도서명", "저자명"};
    public HistoryView() {
        setTitle("이용내역");
        setLayout(null);
        
        labelMsg = new JLabel("도서 이용 내역");
        btnBack = new JButton("마이페이지");
        btnQuiz = new JButton("퀴즈");
        //btnRead = new JButton("도서 읽기"); // 도서 읽기 뭐랑 연결해야할지 난감해 주석처리
        dtm = new DefaultTableModel(rowData,columnnames);
        table = new JTable(dtm);

        JScrollPane sp = new JScrollPane(table);
        table.setFillsViewportHeight(true);

        sp.setBounds(40, 60, 450, 400);
        btnBack.setBounds(40, 470, 140, 35);
        btnQuiz.setBounds(350, 470, 140, 35);
        labelMsg.setBounds(210, 10, 140, 35);
        
        //btnRead.setBounds(300, 400, 100, 30);
        
        Font font=new Font("맑은고딕", Font.BOLD, 16);
        btnBack.setFont(font);
        btnQuiz.setFont(font);
        labelMsg.setFont(font);
        
        add(sp);
        add(btnBack);
        add(btnQuiz);
        add(labelMsg);
        //add(btnRead);

        setBounds(700,200,550,580);

        
  }// end HistoryView 
    
    public void displayTable(ArrayList<Object> list) {
        dtm.setRowCount(0);//출력될 시작행의 위치 0 ---> 첫번째행

        for(int i=0; i< list.size(); i++) {
            Object p = list.get(i);
            //         Object rowData[]= {p.getNo(),p.getName(),p.getAge(),p.getJob()};
            dtm.addRow(rowData);
        }//for
    }//displayTable
}

