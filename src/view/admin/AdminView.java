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
import view.quiz.AddQuizView;
import view.book.AddBookView;

public class AdminView extends JFrame {
    DefaultTableModel dtm, dtm2;
    public JTable table, table2;
    JLabel labelMember, labelBook;
    public JScrollPane sp, sp2;
    public JButton btnSelectAllMember, btnSelectMember, btnDeleteMember, btnSelectAllBook, btnSelectBook, btnDeleteBook, btnAddQuiz, btnBack; //btnAddBook 삭제
    Object rowData[][]= new String[0][4];
    Object columnnames[] = {"아이디", "이름", "이메일", "관심 분야"};
    
    Object rowData2[][]= new String[0][4];
    Object columnnames2[] = {"도서명", "저자명", "줄거리", "분류"};
    
    public AdminView() {
        setTitle("AdminView");
        setLayout(null);
        
        btnSelectAllMember = new JButton("회원 전체 조회");
        btnSelectMember = new JButton("회원 조회");
        btnDeleteMember =  new JButton("회원 삭제");
        labelMember = new JLabel("<회원 정보>");
        
        btnSelectAllBook = new JButton("도서 전체 조회");
        btnSelectBook = new JButton("도서 조회");
        btnDeleteBook =  new JButton("도서 삭제");
        labelBook = new JLabel("<도서 정보>"); 
        
//        btnAddBook = new JButton("도서 추가");
        btnAddQuiz = new JButton("퀴즈 추가");
        
        btnBack = new JButton("로그아웃");
     
        
        
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
        btnSelectAllMember.setBounds(22, 10, 120, 30); //회원 전체 조회
        btnSelectMember.setBounds(160, 10, 110, 30); //회원 조회
        btnDeleteMember.setBounds(290, 10, 110, 30); //회원 삭제
        sp.setBounds(20, 50, 380, 300); //회원 테이블
        labelMember.setBounds(180, 20, 100, 750); //<회원정보>
        
        btnSelectAllBook.setBounds(550, 10, 120, 30); //도서 전체 조회
        btnSelectBook.setBounds(690, 10, 110, 30); //도서 조회  
        btnDeleteBook.setBounds(820, 10, 110, 30); //도서 삭제
        sp2.setBounds(550, 50, 380, 300); //도서 테이블
        labelBook.setBounds(710, 20, 100, 750); //<도서정보>
        
        btnAddQuiz.setBounds(430, 380, 100, 30); //퀴즈 추가
//      btnAddBook.setBounds(830, 380, 100, 30); //도서 추가
        
        btnBack.setBounds(20, 450, 100, 30);  
        
        
        
        //add
        add(btnSelectAllMember);
        add(btnSelectMember);
        add(btnDeleteMember);
        add(sp);
        add(labelMember);
        
        add(btnSelectAllBook);
        add(btnSelectBook);
        add(btnDeleteBook);
        add(sp2);
        add(labelBook);
        
//        add(btnAddBook);
        add(btnAddQuiz);
        
        add(btnBack);
        
        setVisible(false);
        setSize(1000, 530);
        
        
        
        //이벤트 (버튼 클릭시 화면전환)
        btnAddQuiz.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new view.quiz.AddQuizView();
            }
            
        });
        
//      btnAddBook.addActionListener(new ActionListener() {
//
//          @Override
//          public void actionPerformed(ActionEvent e) {
//              new AddBookView();
//          }
//          
//      });
        
        
    } //end AdminView()
    
    public static void main(String[] args) {
        new AdminView().setVisible(true);
    }

    
    //displayTable
    public void displayTable(ArrayList<Member> list) {
           dtm.setRowCount(0);//출력될 시작행의 위치 0 ---> 첫번째행
             
           for(int i=0; i< list.size(); i++) {
           Member m = list.get(i);
           Object rowData[]= {m.getId(),m.getName(),m.getEmail(),m.getInterestCategory()};
           dtm.addRow(rowData);
           }//for
        }
    
    //showInputMsg
    public String showInputMsg(String msg) { return JOptionPane.showInputDialog(this, msg);}
    
} //end AdminView Class


