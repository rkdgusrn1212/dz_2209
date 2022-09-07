package view.admin;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.vo.Member;

public class AdminView extends JFrame {
    public static void main(String args[]) {
        new AdminView().setVisible(true);
    }
    DefaultTableModel dtm, dtm2;
    public JTable table, table2;
    JLabel la_id, la_book;
    public JScrollPane sp, sp2;
    public JButton btnBack, btnAddQuiz, btnSelectMember, btnAddBook, btnSelectBook, btnSelectAllMember, btnSelectAllBook;
    Object rowData[][]= new String[0][5];
    Object columnnames[] = {"아이디", "이름", "이메일", "장르"};

    Object rowData2[][]= new String[0][6];
    Object columnnames2[] = {"도서명", "저자명", "줄거리", "장르", "퀴즈", "답"};
    public AdminView() {
        setTitle("AdminView");
        setLayout(null);

        la_id = new JLabel("회원 정보");
        la_book = new JLabel("도서 정보");      
        btnBack = new JButton("로그아웃");
        btnAddQuiz = new JButton("퀴즈 변경");
        btnSelectMember = new JButton("회원 조회");
        btnAddBook = new JButton("도서 추가");
        btnSelectBook = new JButton("도서 조회");
        btnSelectAllMember = new JButton("회원 전체 조회");
        btnSelectAllBook = new JButton("도서 전체 조회");

        //member table
        dtm = new DefaultTableModel(rowData,columnnames);
        table = new JTable(dtm);
        sp = new JScrollPane(table);
        //book table
        dtm2 = new DefaultTableModel(rowData2,columnnames2);
        table2 = new JTable(dtm2);
        sp2 = new JScrollPane(table2);

        table.setFillsViewportHeight(true);
        table2.setFillsViewportHeight(true);        
        //setBounds 
        la_id.setBounds(50, 20, 100, 30);
        la_book.setBounds(550, 20, 100, 30);
        sp.setBounds(20, 50, 380, 300);
        sp2.setBounds(550, 50, 380, 300);
        btnBack.setBounds(20, 400, 100, 30);
        btnAddQuiz.setBounds(620, 400, 100, 30);
        btnAddBook.setBounds(760, 400, 100, 30);        
        btnSelectBook.setBounds(690, 10, 100, 30);      
        btnSelectAllBook.setBounds(810, 10, 120, 30);       
        btnSelectMember.setBounds(160, 10, 100, 30);
        btnSelectAllMember.setBounds(280, 10, 120, 30);
        //add
        add(la_id);
        add(la_book);
        add(sp);
        add(sp2);
        add(btnBack);
        add(btnAddQuiz);
        add(btnAddBook);
        add(btnSelectBook);
        add(btnSelectMember);
        add(btnSelectAllBook);
        add(btnSelectAllMember);

        setVisible(false);
        setSize(1000, 530);
    }
    public void displayTable(ArrayList<Member> list) {
        dtm.setRowCount(0);//출력될 시작행의 위치 0 ---> 첫번째행

        for(int i=0; i< list.size(); i++) {
            Member m = list.get(i);
            Object rowData[]= {m.getId(),m.getEname(),m.getEmail(),m.getGenre()};
            dtm.addRow(rowData);
        }//for
    }//displayTable
    public String showInputMsg(String msg) {
        return JOptionPane.showInputDialog(this, msg);
    }

}


