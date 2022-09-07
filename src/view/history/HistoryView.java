package view.history;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
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
    Object rowData[][]= new String[0][3];
    Object columnnames[] = {"도서명", "저자명", "완독여부"};
    public HistoryView() {
        setTitle("HistoryView");
        setLayout(null);

        btnBack = new JButton("마이페이지");
        btnQuiz = new JButton("퀴즈");
        //btnRead = new JButton("도서 읽기"); // 도서 읽기 뭐랑 연결해야할지 난감해 주석처리
        dtm = new DefaultTableModel(rowData,columnnames);
        table = new JTable(dtm);

        JScrollPane sp = new JScrollPane(table);
        table.setFillsViewportHeight(true);

        sp.setBounds(50, 50, 300, 300);
        btnBack.setBounds(47, 400, 140, 30);
        btnQuiz.setBounds(210, 400, 140, 30);
        //btnRead.setBounds(300, 400, 100, 30);
        add(sp);
        add(btnBack);
        add(btnQuiz);
        //add(btnRead);

        setSize(410, 500);
        setVisible(true);
        
        // 버튼 이벤트 처리(화면 전환)
        btnQuiz.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            new QuizView();
            setVisible(false); 
        }
    });
        // 버튼 이벤트 처리(화면 전환)
        btnBack.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            new MyPageView();
            setVisible(false);
        }
    });


        
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

