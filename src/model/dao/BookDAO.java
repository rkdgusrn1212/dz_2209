package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.vo.Book;

public class BookDAO {



    public boolean insertBook(Book b) {

        Connection conn = ConnectionHelper.getConnection();
        PreparedStatement pstmt = null;
        try {

            pstmt = conn.prepareStatement("insert into book (isbn,genre,bname,writer,prent,clearNum,originPrice,summary) "
                    + "values(?,?,?,?,?,?,?,?)");
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
        } finally {
            ConnectionHelper.close(pstmt);//close()에 nullable 처리로직이 구현되있다.
            ConnectionHelper.close(conn);
        }
        return false;
    }
    
    public boolean updatePrent(Book b) {

        Connection conn = ConnectionHelper.getConnection();
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement("update book set prent=?"
                    +"where isbn=?");
            pstmt.setInt(1, b.getPrent() + 1);
            pstmt.setInt(2, b.getIsbn());
            pstmt.executeUpdate();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionHelper.close(pstmt);//close()에 nullable 처리로직이 구현되있다.
            ConnectionHelper.close(conn);
        }
        return false;
    }
    
    public boolean updateclearNum(Book b) {

        Connection conn = ConnectionHelper.getConnection();
        PreparedStatement pstmt = null;
        try {

            pstmt = conn.prepareStatement("update book set clearNum=?"
                    +"where isbn=?");
            pstmt.setInt(1, b.getClearNum() + 1);
            pstmt.setInt(2, b.getIsbn());
            pstmt.executeUpdate();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionHelper.close(pstmt);//close()에 nullable 처리로직이 구현되있다.
            ConnectionHelper.close(conn);
        }
        return false;
    }

    public boolean deleteBook(String isbn) {

        Connection conn = ConnectionHelper.getConnection();
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement("delete from book where isbn=?");
            pstmt.setString(1, isbn);
            int t = pstmt.executeUpdate();
            if(t == 1) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionHelper.close(pstmt);//close()에 nullable 처리로직이 구현되있다.
            ConnectionHelper.close(conn);
        }
        return false;
    }

    public Book selectBook(int isbn) {

        Connection conn = ConnectionHelper.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Book b = null;

        try {
            String sql="select genre, bname, writer, prent, clearNum, originPrice, summary, image "
                    +"where isbn=?";

            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, isbn);
            rs = pstmt.executeQuery();
            if(rs.next()) {
                b = new Book(isbn, 
                        rs.getString("genre"),
                        rs.getString("bname"),
                        rs.getString("writer"),
                        rs.getInt("prent"),
                        rs.getInt("clearNum"),
                        rs.getInt("originPrice"),
                        rs.getString("summary"),
                        rs.getString("image "));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionHelper.close(rs);
            ConnectionHelper.close(pstmt);
            ConnectionHelper.close(conn);
        }
        return b;
    }//selectBook

    public ArrayList<Book> recommendBook(String genre) {

        Connection conn = ConnectionHelper.getConnection();
        PreparedStatement pstmt = null;
        ArrayList<Book> bookList = new ArrayList<>();
        ResultSet rs = null;

        try {
            String sql = "select bname, writer, originPrice, summary from book"
                    +"where genre=?";

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, genre);
            rs = pstmt.executeQuery();
            if(rs.next()) {
                Book b = new Book(
                        rs.getString("bname"),
                        rs.getString("writer"),
                        rs.getInt("originPrice"),
                        rs.getString("summary"));
                bookList.add(b);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionHelper.close(rs);
            ConnectionHelper.close(pstmt);
            ConnectionHelper.close(conn);
        }
        return bookList;
    }//recommendBook

    public ArrayList<Book> selectAllBook() {
        
        Connection conn = ConnectionHelper.getConnection();
        PreparedStatement pstmt = null;
        ArrayList<Book> bookList = new ArrayList<>();
        ResultSet rs = null;
        try {
            String sql = "select isbn, genre, bname, writer, prent, clearNum, originPrice, summary, image from book";

            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while(rs.next()) {
                Book b = new Book(
                        rs.getInt("isbn"),
                        rs.getString("genre"),
                        rs.getString("bname"),
                        rs.getString("writer"),
                        rs.getInt("prent"),
                        rs.getInt("clearNum"),
                        rs.getInt("originPrice"),
                        rs.getString("summary"),
                        rs.getString("image"));
                bookList.add(b);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionHelper.close(rs);
            ConnectionHelper.close(pstmt);
            ConnectionHelper.close(conn);
        }
        return bookList;
    }//selectAllBook


    public boolean selectDuplicatedIsbn(String isbn) {
        Connection conn = ConnectionHelper.getConnection();
        PreparedStatement pstmt = null;

        ResultSet rs = null;
        try {
            String sql = "select count(*) count from book where isbn=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,isbn);
            rs = pstmt.executeQuery();

            rs.next();
            int count = rs.getInt("count");
            if(count==1) return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionHelper.close(rs);
            ConnectionHelper.close(pstmt);
            ConnectionHelper.close(conn);
        }
        return false;
    }//selectDuplicatedIsbn


}
