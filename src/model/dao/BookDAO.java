package model.dao;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import db.util.DBConnManager;
import model.vo.Book;

public class BookDAO {

    public boolean insertBook(String isbn, int category, String bName, String writer, int price, String summary, BufferedImage image, String registerId, String lendId) {

        PreparedStatement pstmt = DBConnManager.getInstance().getPreparedStatement(
                "insert into book values(book_id.nextVal,?,?,?,?,?,?,?)");
        try {
            pstmt.setString(1, isbn);
            pstmt.setInt(2, category);
            pstmt.setString(3, bName);
            pstmt.setString(4, writer);
            pstmt.setInt(5, price);
            pstmt.setString(6, summary);
            try {
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ImageIO.write(image, "png", baos);
                ByteArrayInputStream is = new ByteArrayInputStream(baos.toByteArray());
                pstmt.setBinaryStream(7, is);
                System.out.println("이미지 성공");
            } catch (IOException e1) {
                System.out.println("이미지 실패");
                pstmt.setNull(7, java.sql.Types.BLOB);
                e1.printStackTrace();
            }
            pstmt.setString(8, registerId);
            pstmt.setString(9, lendId);
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
    /*public boolean deleteBook(int bookId) {

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
*/

    // 도서 전체 리스트 검색 booklistView 실패시 빈 리스트 반환.
    public ArrayList<Book> selectAllBook() {

        PreparedStatement pstmt = DBConnManager.getInstance().getPreparedStatement(
                "select book_id, b_name, writer, category, lend_id from book ");
        ArrayList<Book> bookList = new ArrayList<>();
        ResultSet rs = null;
        Book b = null;
        ArrayList<Book> list = new ArrayList<>();
        try {
            rs = pstmt.executeQuery();
            while(rs.next()) {
                list.add(new Book(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5)));
                bookList.add(b);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnManager.close(rs);
            DBConnManager.close(pstmt);
        }
        return list;
    }//SelectAllBook

    //도서상세내용 조회  => booksearchview
    /*public Book selectBookWithName(String bName) {

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
    }*/

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
                InputStream imageStream = rs.getBinaryStream(8);
                Image image = null;
                if(imageStream != null) {
                   try {
                       image = ImageIO.read(imageStream);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                b = new Book(
                        rs.getInt(1),//book_id
                        rs.getString(2),//isbn
                        rs.getInt(3),//cat
                        rs.getString(4),//b_name
                        rs.getString(5),//wri
                        rs.getInt(6),//price
                        rs.getString(7),//summ
                        image,
                        rs.getString(9),
                        rs.getString(10));//reg_id
                        
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
