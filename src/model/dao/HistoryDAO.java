package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.vo.History;

public class HistoryDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	public ArrayList<History> selectHistory(String id) { //����� �����丮 ���� �����ֱ�
	    ArrayList<History> list = new ArrayList<>();
		try {
	         connect();
	         String sql = "select * from history where id=? ";
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, id);
	         rs = pstmt.executeQuery();
	         while (rs.next()) {
	        	 list.add(new History(rs.getString("id"),
	        			 			  rs.getInt("isbn"),
	        			 			  rs.getInt("price"),
	        			 			  rs.getInt("clear")));
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         disconnect();
	      }
		return list;
	}
	
	public ArrayList<History> selectAllHistory() { //�����ڿ� ��ü ȸ���� ���� �����丮
		 ArrayList<History> list = new ArrayList<>();
			try {
		         connect();
		         String sql = "select * from history";
		         pstmt = conn.prepareStatement(sql);
		         rs = pstmt.executeQuery();
		         while (rs.next()) {
		        	 list.add(new History(rs.getString("id"),
		        			 			  rs.getInt("isbn"),
		        			 			  rs.getInt("price"),
		        			 			  rs.getInt("clear")));
		         }
		      } catch (SQLException e) {
		         e.printStackTrace();
		      } finally {
		         disconnect();
		      }
			return list;
	}
	
	public boolean insertHistory(History h) {//�����丮 ������ �޾Ƽ� �߰�
	    try {
	         connect();
	         String sql = "insert into history values (?,?,?,?)";
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, h.getId());
	         pstmt.setInt(2, h.getIsbn());
	         pstmt.setInt(3, h.getPrice());
	         pstmt.setInt(4, h.getClear());
	         int t = pstmt.executeUpdate();
	         if(t>0) return true;
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         disconnect();
	      }
	    return false;
	}
	
	public boolean updateHistory(History h) {//�����丮 ���� �޾Ƽ�  ȸ�� ��޿� ���� price�� clear ������Ʈ
	    try {
	         connect();
	         String sql = "update history set price= ?, clear=? where id=? and isbn=?";
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setInt(1, h.getPrice());
	         pstmt.setInt(2, h.getClear());
	         pstmt.setString(3, h.getId());
	         pstmt.setInt(4, h.getIsbn());
	         int t = pstmt.executeUpdate();
	         if(t>0) return true;
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         disconnect();
	      }
	    return false;
	}
	
	public int countClear(String id) {//�ش� ȸ���� �ϵ��� ���� �˷��ֱ�
	    try {
	         connect();
	         String sql = "select count(*) as count from history"
	         		+ " where id=?";
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, id);
	         rs = pstmt.executeQuery();
	         rs.next();
	         return rs.getInt("count");
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         disconnect();
	      }
		return 0;
	}
	
	public void connect() {
		conn = new MyClassDriver().getConnection();
	}

	public void disconnect() {
		try {
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
