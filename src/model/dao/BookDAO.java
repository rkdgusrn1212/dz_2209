package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



import db.util.DBConnManager;
import model.vo.Book;

public class BookDAO {


//addbookview와 mypage에 활용
    public boolean insertBook(Book b) {

        PreparedStatement pstmt = DBConnManager.getInstance().getPreparedStatement(
                "insert into book (isbn,category,bname,writer,pRent,originPrice,summary) values(?,?,?,?,?,?,?)");
        try {
            pstmt.setInt(1, b.getIsbn());
            pstmt.setInt(2, b.getCategory());
            pstmt.setString(3, b.getBname());
            pstmt.setString(4, b.getWriter());			  
            pstmt.setInt(5, 0);
            pstmt.setInt(6, b.getOriginPrice());
            pstmt.setString(7, b.getSummary());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBConnManager.close(pstmt);
        }
        return false;
    }//InsertBook


//mypage에서 사용
    public boolean deleteBook(int isbn) {

        PreparedStatement pstmt = DBConnManager.getInstance().getPreparedStatement("delete from book where isbn=?");
        try {
            pstmt.setInt(1, isbn);
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
    }//DeleteBook

//도서검색 조회  => booksearchview
    public Book selectSearchBook(String bname) {

        PreparedStatement pstmt = DBConnManager.getInstance().getPreparedStatement(
                "select bname, writer,category, pRent from book where bname  like '%' || ? || '%'");
        ResultSet rs = null;
        Book b = null;

        try {
            pstmt.setString(1, bname);
            rs = pstmt.executeQuery();
            if(rs.next()) {
              b = new Book(
                      rs.getString("bname"),
                      rs.getString("writer"),
                      rs.getInt("category"),
                      rs.getInt("prent"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnManager.close(rs);
            DBConnManager.close(pstmt);
        }
        return b;
    }//SelectSearchBook

    
  // 도서 전체 리스트 검색 booklistView  
    public Book selectAllBook() {

        PreparedStatement pstmt = DBConnManager.getInstance().getPreparedStatement(
                "select bname, writer,category, pRent from book ");
        ArrayList<Book> bookList = new ArrayList<>();
        ResultSet rs = null;
        Book b = null;

        try {
            rs = pstmt.executeQuery();
            while(rs.next()) {
                b = new Book(
                        rs.getString("bname"),
                        rs.getString("writer"),
                        rs.getInt("category"),
                        rs.getInt("prent"));
                bookList.add(b);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnManager.close(rs);
            DBConnManager.close(pstmt);
        }
        return b;
    }//SelectAllBook

  //도서상세내용 조회  => booksearchview
    public Book selectBook(String bname) {

        PreparedStatement pstmt = DBConnManager.getInstance().getPreparedStatement(
                "select bname,  originPrice, writer, summary from book where bname like '%' || ? || '%'");
        ResultSet rs = null;
        Book b = null;

        try {
            pstmt.setString(1, bname);
            rs = pstmt.executeQuery();
            if(rs.next()) {
              b = new Book(
                        rs.getString("bname"),
                        rs.getInt("originPrice"),
                        rs.getString("writer"),
                        rs.getString("summary"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnManager.close(rs);
            DBConnManager.close(pstmt);
        }
        return b;
    }//SelectSearchBook


    
    
    
//  public boolean updatePrent(Book b) {
//
//     PreparedStatement pstmt = DBConnManager.getInstance().getPreparedStatement("update book set p_rent=?"
//                 +"where isbn=?");
//     try {
//         pstmt.setInt(1, b.getPrent() + 1);
//         pstmt.setInt(2, b.getIsbn());
//         pstmt.executeUpdate();
//         return true;
//     } catch (SQLException e) {
//         e.printStackTrace();
//     } finally {
//         DBConnManager.close(pstmt);
//     }
//     return false;
// }

//  public ArrayList<Book> recommendBook(String genre) {
//
//      PreparedStatement pstmt = DBConnManager.getInstance().getPreparedStatement(
//              "select b_name, writer, origin_price, summary from book where genre=?");
//      ArrayList<Book> bookList = new ArrayList<>();
//      ResultSet rs = null;
//
//      try {
//          pstmt.setString(1, genre);
//          rs = pstmt.executeQuery();
//          if(rs.next()) {
//              Book b = new Book(
//                      rs.getString("b_name"),
//                      rs.getString("writer"),
//                      rs.getInt("origin_price"),
//                      rs.getString("summary"));
//              bookList.add(b);
//          }
//      } catch (SQLException e) {
//          e.printStackTrace();
//      } finally {
//          DBConnManager.close(rs);
//          DBConnManager.close(pstmt);
//      }
//      return bookList;
//  }//recommendBook
    
//    public boolean selectDuplicatedIsbn(String isbn) {
//        PreparedStatement pstmt = DBConnManager.getInstance().getPreparedStatement(
//                "select count(*) count from book where isbn=?");
//        ResultSet rs = null;
//        try {
//            pstmt.setString(1,isbn);
//            rs = pstmt.executeQuery();
//            rs.next();
//            int count = rs.getInt("count");
//            if(count==1) return true;
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            DBConnManager.close(rs);
//            DBConnManager.close(pstmt);
//        }
//        return false;
//    }//selectDuplicatedIsbn


}
