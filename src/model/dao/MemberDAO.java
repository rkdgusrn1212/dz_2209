package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.vo.Member;

public class MemberDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	public boolean loginCheck(String id, String pass) {// 1.�α��� 2.ȸ������ ���� �� ���� ��й�ȣ�� ������ check
		try {
			connect();
			String sql = "select count(*) from member  where id=? and pass=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pass);
			rs = pstmt.executeQuery();
			rs.next();
			int t = rs.getInt(1);
			if(t>0)
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return false;
	}

	public boolean insertJoin(Member m) {// ȸ������
		try {
			connect();
			String sql = "insert into member (id,pass,ename,email,genre)"
					   + " values (?,?,?,?,?)"; 
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getId());
			pstmt.setString(2, m.getPass());
			pstmt.setString(3, m.getEname());
			pstmt.setString(4, m.getEmail());
			pstmt.setString(5, m.getGenre());
			int t = pstmt.executeUpdate();
			if (t > 0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return false;
	}

	public Member findIdPass(String email) { //���̵�, ��й�ȣ ã��
	    try {
	         connect();
	         String sql = "select id,pass from member where email = ?";
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, email);
	         rs = pstmt.executeQuery();
	         if(rs.next()) {
	        	 Member m = new Member();
	        	 	m.setId(rs.getString("id"));
	        	 	m.setPass(rs.getString("pass"));
	        	 return m;
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         disconnect();
	      }
	    return null;
	}

	public Member selectMypage(String id) { //������������ ���� �̸�, ���, ����Ʈ, ĳ��
		try {
			connect();
			String sql = "select ename, egrade, point,cash from member"
						+ " where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return new Member(rs.getString("ename"),
								  rs.getInt("egrade"),
								  rs.getInt("point"), 
								  rs.getInt("cash"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return null;
	}
	
	public String selectGenre(String id) {//���̵� �ش��ϴ� �帣 �ѷ��ֱ�
	    try {
	         connect();
	         String sql = "select genre from member where id=?";
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, id);
	         rs = pstmt.executeQuery();
	         rs.next();
	         return rs.getString("genre");
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         disconnect();
	      }
	    return null;
	}
	
	public Member selectMemberInfo(String id) {//ȸ������ ���� Ŭ���� ���� ����
		try {
			connect();
			String sql = "select ename, email,genre from member"
						+ " where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				Member m  = new Member();
					   m.setId(id);
					   m.setEname(rs.getString("ename"));
					   m.setEmail(rs.getString("email"));
					   m.setGenre(rs.getString("genre"));
				return m;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return null;
	}
	
	public ArrayList<Member> selectMember(String id){
		ArrayList<Member> list = new ArrayList<>();
		try {
			connect();
			String sql = "select ename, email,genre from member"
						+ " where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				Member m  = new Member();
					   m.setId(id);
					   m.setEname(rs.getString("ename"));
					   m.setEmail(rs.getString("email"));
					   m.setGenre(rs.getString("genre"));
				list.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}
	
	public ArrayList<Member> selectAllMember(){
		ArrayList<Member> list = new ArrayList<>();
		try {
			connect();
			String sql = "select id, ename, email,genre from member";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Member m  = new Member();
				m.setId(rs.getString("id"));
				m.setEname(rs.getString("ename"));
				m.setEmail(rs.getString("email"));
				m.setGenre(rs.getString("genre"));
				list.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}
	
	public boolean updateMemberInfo(String id,String pass) {//��й�ȣ ����
	    try {
	         connect();
	         String sql = "update member set pass=? where id=?";
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, pass);
	         pstmt.setString(2, id);
	         int t = pstmt.executeUpdate();
	         if(t>0) return true;
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         disconnect();
	      }
	    return false;
	}
	
	public boolean dupliCheck(String checkStr) { //id�� email�� �ߺ�üũ
	    String sql;
		try {
	         connect();
	         if(checkStr.contains("@")) {
	        	 sql = "select count(*) as count from member where email=?";	        	 
	         }else {
	        	 sql = "select count(*) as count from member where id=?";
	         }
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, checkStr);
	         rs = pstmt.executeQuery();
	         rs.next();
	       
	         int t = rs.getInt("count");
	         if(t>0) return true;
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         disconnect();
	      }
	   return false;
	}
	
	public boolean updateGenre(String id,String genre) {//�帣 ���� 
	    try {
	         connect();
	         String sql = "update member set genre=? where id=?";
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, genre);
	         pstmt.setString(2, id);
	         int t = pstmt.executeUpdate();
	         if(t>0) return true;
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         disconnect();
	      }
	    return false;
	}
	
	public boolean updateCashCharge(String id,int cash) {//cash�����ϱ� 
	    try {
	         connect();
	         String sql = "update member set cash=cash+? where id=?";
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setInt(1, cash);
	         pstmt.setString(2, id);
	         int t = pstmt.executeUpdate();
	         if(t>0) return true;
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         disconnect();
	      }
	    return false;
	}
	
	public boolean updateAfterPay(Member m) {//id, cash,point �޾� ������Ʈ�ϱ�
		try {
	         connect();
	         String sql = "update member set cash = cash-?, point = point-?"
	         		+ " where id=?";
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setInt(1, m.getCash());
	         pstmt.setInt(2, m.getPoint());
	         pstmt.setString(3, m.getId());
	         int t = pstmt.executeUpdate();
	         if(t>0) return true;
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         disconnect();
	      }	
	    return false;
	}
	
	public int selectGrade(String id) {//���̵� �̿��Ͽ� ��� �˾Ƴ���
	    try {
	         connect();
	         String sql = "select egrade from member where id=?";
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, id);
	         rs = pstmt.executeQuery();
	         if(rs.next()) {
	        	 return rs.getInt("egrade");
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         disconnect();
	      }
	    return 0;
	}
	
	public boolean updateGrade(String id, int egrade) {//���̵� ���� ��� ����
	    try {
	         connect();
	         String sql = "update member set egrade=? where id=?";
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setInt(1, egrade);
	         pstmt.setString(2, id);
	         int t = pstmt.executeUpdate();
	         if(t>0) return true;
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         disconnect();
	      }
	    return false;
	}
	
	public void connect() {
		conn = MyClassDriver.getConnection();
		System.out.println("DB����");
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
