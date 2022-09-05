package model.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import model.vo.Book;

public class BookDAO {

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	Properties pro;
	
	public BookDAO() {
		 try {
			  pro = new Properties();
			  pro.load(new FileReader("conn/conn.properties"));
			  Class.forName(pro.getProperty("driver"));
		  } catch (Exception e) {
			e.printStackTrace();
		  }
	}
	
	private void connect() {
		   try {
			conn = DriverManager.getConnection(pro.getProperty("url"),pro);
		   } catch (SQLException e) {
			e.printStackTrace();
		  }	
		}//connect
	private void disconnect() {
		try {
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}//disconnect
	
	public boolean insertBook(Book b) {
		
		connect();
		
		try {
			String sql = "insert into book (isbn,genre,bname,writer,prent,clearNum,originPrice,summary) "
					+ "values(?,?,?,?,?,?,?,?)";
			
			pstmt = conn.prepareStatement(sql);
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
			disconnect();
		}
		return false;
	}//insertbook
	
	public boolean updatePrent(Book b) {
		
		connect();
		
		try {
			String sql = "update book set prent=?"
					    +"where isbn=?";
			
			pstmt = conn.prepareStatement(sql);
			  pstmt.setInt(1, b.getPrent() + 1);
			  pstmt.setInt(2, b.getIsbn());
			pstmt.executeUpdate();
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return false;
	}//updatePrent
	
	public boolean updateclearNum(Book b) {
		
		connect();
		
		try {
			String sql = "update book set clearNum=?"
				        +"where isbn=?";
	
			pstmt = conn.prepareStatement(sql);
			  pstmt.setInt(1, b.getClearNum() + 1);
			  pstmt.setInt(2, b.getIsbn());
			pstmt.executeUpdate();
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return false;
	}
	
	public boolean deleteBook(String isbn) {
		
		connect();
		
		try {
			String sql="delete from book where isbn=?";
			
			pstmt = conn.prepareStatement(sql);
			  pstmt.setString(1, isbn);
			int t = pstmt.executeUpdate();
			if(t == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return false;
	}//deleteBook
	
	public Book selectBook(int isbn) {
		
		connect();
		Book b = null;
		
		try {
			String sql="select genre, bname, writer, prent, clearNum, originPrice, summary, image "
					  +"where isbn=?";
		 
			pstmt = conn.prepareStatement(sql);
			  pstmt.setInt(1, isbn);
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
			disconnect();
		}
		return b;
	}//selectBook
	
	public ArrayList<Book> recommendBook(String genre) {
		
		connect();
		ArrayList<Book> bookList = new ArrayList<>();
		
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
			disconnect();
		}
		return bookList;
	}//recommendBook
	
	public ArrayList<Book> selectAllBook() {
		
		connect();
		ArrayList<Book> bookList = new ArrayList<>();
		
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
			disconnect();
		}
		return bookList;
	}//selectAllBook
	
	
	public boolean selectDuplicatedIsbn(String isbn) {
		connect(); 
		
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
			disconnect();
		}
		return false;
	}//selectDuplicatedIsbn
	
	
}
