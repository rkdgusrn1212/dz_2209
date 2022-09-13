package view.admin;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import model.vo.Member;
import view.View;
import view.book.AddBookView;

public class AdminView extends View {
    DefaultTableModel dtm, dtm2;
    public JTable table, table2;
    public JLabel labelMember, labelBook;
    public JTextField tfMemberSearch, tfBookSearch;
    public JScrollPane sp, sp2;
    public JButton btnSelectAllMember, btnSelectMember, btnDeleteMember, btnSelectAllBook, btnSelectBook, btnDeleteBook, btnBack; //btnAddBook 삭제
    public JComboBox<String> cbSearchMember, cbSearchBook;
    
    public AdminView() {
        setTitle("관리자 메뉴");
        setLayout(null);
        
        btnSelectAllMember = new JButton("회원 전체 조회");
        btnSelectMember = new JButton("회원 조회");
        btnDeleteMember =  new JButton("회원 삭제");
        tfMemberSearch = new JTextField("입력");
        labelMember = new JLabel("<회원 정보>");
        
        btnSelectAllBook = new JButton("도서 전체 조회");
        btnSelectBook = new JButton("도서 조회");
        btnDeleteBook =  new JButton("도서 삭제");
        tfBookSearch = new JTextField("입력");
        labelBook = new JLabel("<도서 정보>"); 
        
        btnBack = new JButton("로그아웃");
     
        //member table
        table = new JTable(dtm);
        sp = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        //book table
        table2 = new JTable(dtm2);
        sp2 = new JScrollPane(table2);
        table2.setFillsViewportHeight(true);   
        
        
        //setBounds 
        btnSelectAllMember.setBounds(40, 460, 140, 35); //회원 전체 조회
        btnSelectMember.setBounds(410, 460, 110, 35); //회원 조회
        btnDeleteMember.setBounds(380, 510, 140, 35); //회원 삭제
        sp.setBounds(40, 60, 480, 380); //회원 테이블
        labelMember.setBounds(230, 15, 100, 35); //<회원정보>
        tfMemberSearch.setBounds(283, 460, 125, 35); // 회원 정보 조회
        
        btnSelectAllBook.setBounds(560, 460, 140, 35); //도서 전체 조회
        btnSelectBook.setBounds(930, 460, 110, 35); //도서 조회  
        btnDeleteBook.setBounds(900, 510, 140, 35); //도서 삭제
        sp2.setBounds(560, 60, 480, 380); //도서 테이블
        labelBook.setBounds(770, 15, 100, 35); //<도서정보>
        tfBookSearch.setBounds(804, 460, 125, 35); // 도서 정보 조회
        
        btnBack.setBounds(910, 15, 130, 35); // 로그아웃  
        
        Font font=new Font("맑은고딕", Font.BOLD, 16);
        Font font2=new Font("맑은고딕", Font.ITALIC, 16);
        btnSelectAllMember.setFont(font);
        btnSelectMember.setFont(font);
        btnDeleteMember.setFont(font);
        labelMember.setFont(font);
        tfMemberSearch.setFont(font2);
        
        btnSelectAllBook.setFont(font);
        btnSelectBook.setFont(font);
        btnDeleteBook.setFont(font);
        labelBook.setFont(font);
        tfBookSearch.setFont(font2);
        btnBack.setFont(font);
        
        //add
        add(btnSelectAllMember);
        //add(btnSelectMember);
        //add(btnDeleteMember);
        add(sp);
        add(labelMember);
        //add(tfMemberSearch);
        //add(cbSearchMember);
        add(btnSelectAllBook);
        //add(btnSelectBook);
        //add(btnDeleteBook);
        add(sp2);
        add(labelBook);
        //add(tfBookSearch);
        //add(cbSearchBook);
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


