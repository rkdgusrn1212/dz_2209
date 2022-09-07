package view;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class HistoryView extends JFrame {
    DefaultTableModel dtm;
    public JTable table;
    public JButton btnBack, bt_quiz, bt_read;
    Object rowData[][]= new String[0][3];
    Object columnnames[] = {"도서명", "저자명", "완독여부"};
    public HistoryView() {
        setTitle("HistoryView");
        setLayout(null);

        btnBack = new JButton("마이페이지창으로");
        bt_quiz = new JButton("퀴즈");
        bt_read = new JButton("도서 읽기");
        dtm = new DefaultTableModel(rowData,columnnames);
        table = new JTable(dtm);

        JScrollPane sp = new JScrollPane(table);
        table.setFillsViewportHeight(true);

        sp.setBounds(50, 50, 300, 300);
        btnBack.setBounds(20, 400, 150, 30);
        bt_quiz.setBounds(200, 400, 80, 30);
        bt_read.setBounds(300, 400, 100, 30);
        add(sp);
        add(btnBack);
        add(bt_quiz);
        add(bt_read);

        setSize(600, 600);
    }
    public void displayTable(ArrayList<Object> list) {
        dtm.setRowCount(0);//출력될 시작행의 위치 0 ---> 첫번째행

        for(int i=0; i< list.size(); i++) {
            Object p = list.get(i);
            //         Object rowData[]= {p.getNo(),p.getName(),p.getAge(),p.getJob()};
            dtm.addRow(rowData);
        }//for
    }//displayTable
}

