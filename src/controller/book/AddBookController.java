package controller.book;

import java.awt.event.ActionEvent;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import controller.Controller;
import db.util.DBConnManager;
import view.View;
import view.book.AddBookView;

public class AddBookController extends Controller {

    private AddBookView addviewBook;
    public AddBookController(Controller controller, String... args) {
        super(controller, AddBookView.class, args);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object s = e.getSource();
        if(s == addviewBook.btnReset) {
            finish();
        } else if (s==addviewBook.btnSubmit) {
        	
    		String Isbn=addviewBook.tfIsbn.getText();
    		String Category=addviewBook.tfCategory.getText();
    		String Bname=addviewBook.tfBook.getText();
    		String Writer=addviewBook.tfWriter.getText();
    		String OriginPrice=addviewBook.tfPrice.getText();
    		String Summary=addviewBook.taContent.getText();
    		 PreparedStatement pstmt = DBConnManager.getInstance().getPreparedStatement(
                     "insert into book (isbn,category,bname,writer,pRent,originPrice,summary) values(?,?,?,?,?,?,?)");
             try {
                 pstmt.setString(1, Isbn);
                 pstmt.setString(2, Category);
                 pstmt.setString(3, Bname);
                 pstmt.setString(4, Writer);			  
                 pstmt.setInt(5, 0);
                 pstmt.setString(6, OriginPrice);
                 pstmt.setString(7, Summary);
                int res=pstmt.executeUpdate();
                System.out.println(res+"개 등록 완료");
             } catch (SQLException ex) {
                 ex.printStackTrace();
             }finally {
                 DBConnManager.close(pstmt);
    	}
    	}		
        
        
    }

    @Override
    protected void create(View windowView) {
        addviewBook = (AddBookView) windowView;
        addviewBook.btnReset.addActionListener(this);
        addviewBook.btnSubmit.addActionListener(this);
    }

}
