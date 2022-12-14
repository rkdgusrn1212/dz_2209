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

    public boolean updateWithBookId(int bookId, String isbn, int category, String bName, String writer, int price, String summary, BufferedImage image) {

        PreparedStatement pstmt = DBConnManager.getInstance().getPreparedStatement(
                "update book set isbn=?, category=?, b_name=?, writer=?, price = ?, summary=?, image=? where book_id = ?");
        try {
            pstmt.setString(1, isbn);
            pstmt.setInt(2, category);
            pstmt.setString(3, bName);
            pstmt.setString(4, writer);
            pstmt.setInt(5, price);
            pstmt.setString(6, summary);
            pstmt.setInt(8, bookId);
            boolean success = false;
            if(image!=null) {
                try {
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    ImageIO.write(image, "png", baos);
                    ByteArrayInputStream is = new ByteArrayInputStream(baos.toByteArray());
                    pstmt.setBinaryStream(7, is);
                    success = true;
                } catch (IOException e1) {
                    e1.printStackTrace();
                }   
            }
            if(!success) {
                pstmt.setNull(7, java.sql.Types.BLOB);
            }
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBConnManager.close(pstmt);
        }
        return false;
    }

    public boolean insertBook(String isbn, int category, String bName, String writer, int price, String summary, BufferedImage image, String registerId, String lendId) {

        PreparedStatement pstmt = DBConnManager.getInstance().getPreparedStatement(
                "insert into book values(book_id.nextVal,?,?,?,?,?,?,?,?,?)");
        try {
            pstmt.setString(1, isbn);
            pstmt.setInt(2, category);
            pstmt.setString(3, bName);
            pstmt.setString(4, writer);
            pstmt.setInt(5, price);
            pstmt.setString(6, summary);
            pstmt.setString(8, registerId);
            pstmt.setString(9, lendId);
            System.out.println("image??? null??? ??????");
            boolean imgSuccess = false;
            if(image!=null) {
                try {
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    ImageIO.write(image, "png", baos);
                    ByteArrayInputStream is = new ByteArrayInputStream(baos.toByteArray());
                    pstmt.setBinaryStream(7, is);
                    imgSuccess = true;
                } catch (IOException e1) {
                    System.out.println("????????? ??????");
                    e1.printStackTrace();
                }   
            }
            if(!imgSuccess) {
                pstmt.setNull(7, java.sql.Types.BLOB);
            }
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBConnManager.close(pstmt);
        }
        return false;
    }//InsertBook



    public boolean deleteBook(int bookId) {

        PreparedStatement pstmt = DBConnManager.getInstance().getPreparedStatement("delete from book where book_id =?");
        try {
            pstmt.setInt(1, bookId);
            int t = pstmt.executeUpdate();
            if(t >0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnManager.close(pstmt);
        }
        return false;
    }//DeleteBook

    public ArrayList<Book> selectWithIsbn(String isbn) {

        PreparedStatement pstmt = DBConnManager.getInstance().getPreparedStatement(
                "select book_id, b_name, writer, category, lend_id from book where isbn = ?");
        ArrayList<Book> bookList = new ArrayList<>();
        ResultSet rs = null;
        Book b = null;
        ArrayList<Book> list = new ArrayList<>();
        try {
            pstmt.setString(1,isbn);
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
    }

    public ArrayList<Book> selectWithRegisterId(String rId) {

        PreparedStatement pstmt = DBConnManager.getInstance().getPreparedStatement(
                "select book_id, b_name, writer, category, lend_id from book where register_id = ?");
        ArrayList<Book> bookList = new ArrayList<>();
        ResultSet rs = null;
        Book b = null;
        ArrayList<Book> list = new ArrayList<>();
        try {
            pstmt.setString(1, rId);
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
    }

    public ArrayList<Book> selectWithWriter(String writer) {

        PreparedStatement pstmt = DBConnManager.getInstance().getPreparedStatement(
                "select book_id, b_name, writer, category, lend_id from book where writer like '%'||?||'%'");
        ArrayList<Book> bookList = new ArrayList<>();
        ResultSet rs = null;
        Book b = null;
        ArrayList<Book> list = new ArrayList<>();
        try {
            pstmt.setString(1, writer);
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
    }
    public ArrayList<Book> selectWithCategory(String category) {

        PreparedStatement pstmt = DBConnManager.getInstance().getPreparedStatement(
                "select book_id, b_name, writer, category, lend_id from book where category = ?");
        ArrayList<Book> bookList = new ArrayList<>();
        ResultSet rs = null;
        Book b = null;
        ArrayList<Book> list = new ArrayList<>();
        try {
            pstmt.setString(1, category);
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
    }

    public ArrayList<Book> selectWithBName(String bName) {

        PreparedStatement pstmt = DBConnManager.getInstance().getPreparedStatement(
                "select book_id, b_name, writer, category, lend_id from book where b_name like '%'||?||'%'");
        ArrayList<Book> bookList = new ArrayList<>();
        ResultSet rs = null;
        Book b = null;
        ArrayList<Book> list = new ArrayList<>();
        try {
            pstmt.setString(1, bName);
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
    }

    // ?????? ?????? ????????? ?????? booklistView ????????? ??? ????????? ??????.
    public ArrayList<Book> selectAll() {

        PreparedStatement pstmt = DBConnManager.getInstance().getPreparedStatement(
                "select book_id, b_name, writer, category, lend_id from book ");
        ResultSet rs = null;
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

    public ArrayList<Book> selectAllWithPrice() {

        PreparedStatement pstmt = DBConnManager.getInstance().getPreparedStatement(
                "select book_id, b_name, writer, category, price from book ");
        ResultSet rs = null;
        ArrayList<Book> list = new ArrayList<>();
        try {
            rs = pstmt.executeQuery();
            while(rs.next()) {
                list.add(new Book(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5)));
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

    public Book selectBookWithId(int bookId) {

        PreparedStatement pstmt = DBConnManager.getInstance().getPreparedStatement(
                "select * from book where book_id = ?");
        ResultSet rs = null;
        Book b = null;

        try {
            pstmt.setInt(1, bookId);
            rs = pstmt.executeQuery();
            if(rs.next()) {
                InputStream imageStream = rs.getBinaryStream(8);
                BufferedImage image = null;
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
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnManager.close(rs);
            DBConnManager.close(pstmt);
        }
        return b;
    }



    public boolean returnBook(int bookId) {

        PreparedStatement pstmt = DBConnManager.getInstance().getPreparedStatement(
                "update book set lend_id = null where book_id = ?");
        try {
            pstmt.setInt(1, bookId);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBConnManager.close(pstmt);
        }
        return false;
    }

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
                BufferedImage image = null;
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
    }
}
