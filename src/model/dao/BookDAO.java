package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.util.DBConnManager;
import model.vo.Book;

public class BookDAO {



    public boolean insertBook(Book b) {

        PreparedStatement pstmt = DBConnManager.getInstance().getPreparedStatement(
                "insert into book (isbn,genre,b_name,writer,p_rent,clear_num,origin_price,summary) values(?,?,?,?,?,?,?,?)");
        try {
            pstmt.setInt(1, b.getIsbn());
            pstmt.setString(2, b.getGenre());
            pstmt.setString(3, b.getBname());
            pstmt.setString(4, b.getWriter());			  
            pstmt.setInt(5, 0);
            pstmt.setInt(6, 0);
            pstmt.setInt(7, b.getOriginPrice());
            pstmt.setString(8, b.getSummary());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBConnManager.close(pstmt);
        }
        return false;
    }
    
     public boolean updatePrent(Book b) {

        PreparedStatement pstmt = DBConnManager.getInstance().getPreparedStatement("update book set p_rent=?"
                    +"where isbn=?");
        try {
            pstmt.setInt(1, b.getPrent() + 1);
            pstmt.setInt(2, b.getIsbn());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnManager.close(pstmt);
        }
        return false;
    }
    
    public boolean updateClearNum(Book b) {

        PreparedStatement pstmt = DBConnManager.getInstance().getPreparedStatement("update book set clear_num=?"
                +"where isbn=?");
        try {

            pstmt.setInt(1, b.getClearNum() + 1);
            pstmt.setInt(2, b.getIsbn());
            pstmt.executeUpdate();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnManager.close(pstmt);
        }
        return false;
    }

    public boolean deleteBook(String isbn) {

        PreparedStatement pstmt = DBConnManager.getInstance().getPreparedStatement("delete from book where isbn=?");
        try {
            pstmt.setString(1, isbn);
            int t = pstmt.executeUpdate();
            if(t == 1) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnManager.close(pstmt);
        }
        return false;
    }

    public Book selectBook(int isbn) {

        PreparedStatement pstmt = DBConnManager.getInstance().getPreparedStatement(
                "select genre, b_name, writer, p_rent, clear_num, origin_price, summary, image where isbn=?");
        ResultSet rs = null;
        Book b = null;

        try {
            pstmt.setInt(1, isbn);
            rs = pstmt.executeQuery();
            if(rs.next()) {
                b = new Book(isbn, 
                        rs.getString("genre"),
                        rs.getString("b_name"),
                        rs.getString("writer"),
                        rs.getInt("p_rent"),
                        rs.getInt("clear_num"),
                        rs.getInt("origin_price"),
                        rs.getString("summary"),
                        rs.getString("image "));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnManager.close(rs);
            DBConnManager.close(pstmt);
        }
        return b;
    }//selectBook

    public ArrayList<Book> recommendBook(String genre) {

        PreparedStatement pstmt = DBConnManager.getInstance().getPreparedStatement(
                "select b_name, writer, origin_price, summary from book where genre=?");
        ArrayList<Book> bookList = new ArrayList<>();
        ResultSet rs = null;

        try {
            pstmt.setString(1, genre);
            rs = pstmt.executeQuery();
            if(rs.next()) {
                Book b = new Book(
                        rs.getString("b_name"),
                        rs.getString("writer"),
                        rs.getInt("origin_price"),
                        rs.getString("summary"));
                bookList.add(b);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnManager.close(rs);
            DBConnManager.close(pstmt);
        }
        return bookList;
    }//recommendBook

    public ArrayList<Book> selectAllBook() {

        PreparedStatement pstmt = DBConnManager.getInstance().getPreparedStatement(
                "select isbn, genre, b_name, writer, p_rent, clear_num, origin_price, summary, image from book");
        ArrayList<Book> bookList = new ArrayList<>();
        ResultSet rs = null;
        try {
            rs = pstmt.executeQuery();
            while(rs.next()) {
                Book b = new Book(
                        rs.getInt("isbn"),
                        rs.getString("genre"),
                        rs.getString("b_name"),
                        rs.getString("writer"),
                        rs.getInt("p_rent"),
                        rs.getInt("clear_num"),
                        rs.getInt("origin_price"),
                        rs.getString("summary"),
                        rs.getString("image"));
                bookList.add(b);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnManager.close(rs);
            DBConnManager.close(pstmt);
        }
        return bookList;
    }//selectAllBook


    public boolean selectDuplicatedIsbn(String isbn) {
        PreparedStatement pstmt = DBConnManager.getInstance().getPreparedStatement(
                "select count(*) count from book where isbn=?");
        ResultSet rs = null;
        try {
            pstmt.setString(1,isbn);
            rs = pstmt.executeQuery();
            rs.next();
            int count = rs.getInt("count");
            if(count==1) return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnManager.close(rs);
            DBConnManager.close(pstmt);
        }
        return false;
    }//selectDuplicatedIsbn


}
