package view.admin;

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
import view.AddQuizView;
import view.book.AddBookView;

public class AdminView extends JFrame {
    DefaultTableModel dtm, dtm2;
    public JTable table, table2;
    JLabel labelMember, labelBook;
    public JScrollPane sp, sp2;
    public JButton btnSelectMember, btnSelectAllMember, btnSelectBook, btnSelectAllBook, btnAddBook, btnAddQuiz; //btnBack 삭제
    Object rowData[][]= new String[0][5];
    Object columnnames[] = {"아이디", "이름", "이메일", "장르"};
    
    Object rowData2[][]= new String[0][6];
    Object columnnames2[] = {"도서명", "저자명", "줄거리", "장르"};
    
    public AdminView() {
        setTitle("AdminView");
        setLayout(null);
        
        labelMember = new JLabel("회원 정보");
        btnSelectMember = new JButton("회원 조회");
        btnSelectAllMember = new JButton("회원 전체 조회");
        
        labelBook = new JLabel("도서 정보"); 
        btnSelectBook = new JButton("도서 조회");
        btnSelectAllBook = new JButton("도서 전체 조회");
        
        btnAddBook = new JButton("도서 추가");
        btnAddQuiz = new JButton("퀴즈 추가");
        
//      bt_back = new JButton("로그아웃");
     
        
        
        //member table
        dtm = new DefaultTableModel(rowData,columnnames);
        table = new JTable(dtm);
        sp = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        
        //book table
        dtm2 = new DefaultTableModel(rowData2,columnnames2);
        table2 = new JTable(dtm2);
        sp2 = new JScrollPane(table2);
        table2.setFillsViewportHeight(true);   
        
        
        
        //setBounds 
        labelMember.setBounds(50, 20, 100, 30);
        btnSelectMember.setBounds(160, 10, 100, 30);
        btnSelectAllMember.setBounds(280, 10, 120, 30);
        sp.setBounds(20, 50, 380, 300);
        
        labelBook.setBounds(550, 20, 100, 30);
        btnSelectBook.setBounds(690, 10, 100, 30);      
        btnSelectAllBook.setBounds(810, 10, 120, 30);       
        sp2.setBounds(550, 50, 380, 300);
        
        btnAddBook.setBounds(620, 400, 100, 30);
        btnAddQuiz.setBounds(760, 400, 100, 30); 
        
//      bt_back.setBounds(20, 400, 100, 30);  
        
        
        
        //add
        add(labelMember);
        add(btnSelectMember);
        add(btnSelectAllMember);
        add(sp);
        
        add(labelBook);
        add(btnSelectBook);
        add(btnSelectAllBook);
        add(sp2);
        
        add(btnAddBook);
        add(btnAddQuiz);
        
//      add(bt_back);
        
        setVisible(false);
        setSize(1000, 530);
        
        
        
        //이벤트 (버튼 클릭시 화면전환)
        btnAddBook.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new AddBookView();
                setVisible(false); 
            }
            
        });
        
        btnAddQuiz.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new AddQuizView();
                setVisible(false); 
            }
            
        });
        
        
    } //end AdminView()
    
    public static void main(String[] args) {
        new AdminView().setVisible(true);
    }

    
    //displayTable
    public void displayTable(ArrayList<Member> list) {
           dtm.setRowCount(0);//출력될 시작행의 위치 0 ---> 첫번째행
             
           for(int i=0; i< list.size(); i++) {
           Member m = list.get(i);
           Object rowData[]= {m.getId(),m.getEname(),m.getEmail(),m.getGenre()};
           dtm.addRow(rowData);
           }//for
        }
    
    //showInputMsg
    public String showInputMsg(String msg) { return JOptionPane.showInputDialog(this, msg);}
    
} //end AdminView Class


