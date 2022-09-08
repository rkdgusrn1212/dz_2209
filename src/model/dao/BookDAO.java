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
                "insert into book (book_id, isbn, category,b_name,writer,p_rent,origin_price,summary) values(?,?,?,?,?,?,?)");
        try {
            pstmt.setString(1, b.getIsbn());
            pstmt.setString(2, b.getIsbn());
            pstmt.setInt(3, b.getCategory());
            pstmt.setString(4, b.getBname());
            pstmt.setString(5, b.getWriter());			  
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
    }//InsertBook


    //mypage에서 사용
    public boolean deleteBook(int bookId) {

        PreparedStatement pstmt = DBConnManager.getInstance().getPreparedStatement("delete from book where book_id =?");
        try {
            pstmt.setInt(1, bookId);
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
    public Book selectSearchBook(String bName) {

        PreparedStatement pstmt = DBConnManager.getInstance().getPreparedStatement(
                "select b_name, writer,category, p_rent from book where bname  like '%' || ? || '%'");
        ResultSet rs = null;
        Book b = null;

        try {
            pstmt.setString(1, bName);
            rs = pstmt.executeQuery();
            if(rs.next()) {
                b = new Book(
                        rs.getString("b_name"),
                        rs.getString("writer"),
                        rs.getInt("category"),
                        rs.getInt("p_rent"));
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
                "select b_name, writer,category, p_rent from book ");
        ArrayList<Book> bookList = new ArrayList<>();
        ResultSet rs = null;
        Book b = null;

        try {
            rs = pstmt.executeQuery();
            while(rs.next()) {
                b = new Book(
                        rs.getString("b_name"),
                        rs.getString("writer"),
                        rs.getInt("category"),
                        rs.getInt("p_rent"));
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
    public Book selectBookWithName(String bName) {

        PreparedStatement pstmt = DBConnManager.getInstance().getPreparedStatement(
                "select b_name,  origin_price, writer, summary from book where bname like '%' || ? || '%'");
        ResultSet rs = null;
        Book b = null;

        try {
            pstmt.setString(1, bName);
            rs = pstmt.executeQuery();
            if(rs.next()) {
                b = new Book(
                        rs.getString("b_name"),
                        rs.getInt("origin_price"),
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

    public ArrayList<Book> selectBookWithMemberIdWithRowNum(String id, int rowNum) {

        PreparedStatement pstmt = DBConnManager.getInstance().getPreparedStatement(
                "select * from book where category = (select interest_category from member where id = ?) and rownum <= ?");
        ResultSet rs = null;
        Book b = null;
        ArrayList<Book> list = new ArrayList<>();

        try {
            pstmt.setString(1, id);
            pstmt.setInt(2, rowNum);
            rs = pstmt.executeQuery();
            while(rs.next()) {
                b = new Book(
                        rs.getInt(1),//book_id
                        rs.getString(2),//isbn
                        rs.getInt(3),//cat
                        rs.getString(4),//b_name
                        rs.getString(5),//wri
                        rs.getInt(6),//prent
                        rs.getInt(7),//price
                        rs.getString(8),
                        rs.getURL(9));
                list.add(b);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnManager.close(rs);
            DBConnManager.close(pstmt);
        }
        return list;
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
