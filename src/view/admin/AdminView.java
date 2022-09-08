package view.admin;

import java.awt.Font;
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
        setTitle("관리자 메뉴");
        setLayout(null);
        
        btnSelectAllMember = new JButton("회원 전체 조회");
        btnSelectMember = new JButton("회원 조회");
        btnDeleteMember =  new JButton("회원 삭제");
        labelMember = new JLabel("<회원 정보>");
        
        btnSelectAllBook = new JButton("도서 전체 조회");
        btnSelectBook = new JButton("도서 조회");
        btnDeleteBook =  new JButton("도서 삭제");
        labelBook = new JLabel("<도서 정보>"); 
        
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
        btnSelectAllMember.setBounds(40, 15, 140, 35); //회원 전체 조회
        btnSelectMember.setBounds(210, 15, 140, 35); //회원 조회
        btnDeleteMember.setBounds(380, 15, 140, 35); //회원 삭제
        sp.setBounds(40, 60, 480, 380); //회원 테이블
        labelMember.setBounds(230, 90, 100, 750); //<회원정보>
        
        btnSelectAllBook.setBounds(560, 15, 140, 35); //도서 전체 조회
        btnSelectBook.setBounds(730, 15, 140, 35); //도서 조회  
        btnDeleteBook.setBounds(900, 15, 140, 35); //도서 삭제
        sp2.setBounds(560, 60, 480, 380); //도서 테이블
        labelBook.setBounds(770, 90, 100, 750); //<도서정보>
        
        btnAddQuiz.setBounds(750, 500, 130, 35); //퀴즈 추가
        btnBack.setBounds(910, 500, 130, 35);  
        
        Font font=new Font("맑은고딕", Font.BOLD, 16);
        btnSelectAllMember.setFont(font);
        btnSelectMember.setFont(font);
        btnDeleteMember.setFont(font);
        labelMember.setFont(font);
        btnSelectAllBook.setFont(font);
        btnSelectBook.setFont(font);
        btnDeleteBook.setFont(font);
        labelBook.setFont(font);
        btnAddQuiz.setFont(font);
        btnBack.setFont(font);
        
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
        
        setBounds(500,250,1100,600); 
        
        
    } //end AdminView()
    
    
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


