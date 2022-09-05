package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.vo.Member;

public class MemberDAO {

    public boolean loginCheck(String id, String pass) {
        Connection conn = ConnectionHelper.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            pstmt = conn.prepareStatement("select count(*) from member  where id=? and pass=?");
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
            ConnectionHelper.close(rs);
            ConnectionHelper.close(pstmt);
            ConnectionHelper.close(conn);
        }
        return false;
    }

    public boolean insertJoin(Member m) {
        Connection conn = ConnectionHelper.getConnection();
        PreparedStatement pstmt = null;
        try { 
            pstmt = conn.prepareStatement("insert into member (id,pass,ename,email,genre)"
                    + " values (?,?,?,?,?)");
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
            ConnectionHelper.close(pstmt);
            ConnectionHelper.close(conn);
        }
        return false;
    }

    public Member findIdPass(String email) {

        Connection conn = ConnectionHelper.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = conn.prepareStatement("select id,pass from member where email = ?");
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
            ConnectionHelper.close(rs);
            ConnectionHelper.close(pstmt);
            ConnectionHelper.close(conn);
        }
        return null;
    }

    public Member selectMypage(String id) {
        Connection conn = ConnectionHelper.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = conn.prepareStatement("select ename, egrade, point,cash from member"
                    + " where id=?");
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
            ConnectionHelper.close(rs);
            ConnectionHelper.close(pstmt);
            ConnectionHelper.close(conn);
        }
        return null;
    }

    public String selectGenre(String id) {
        Connection conn = ConnectionHelper.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = conn.prepareStatement( "select genre from member where id=?");
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
            rs.next();
            return rs.getString("genre");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionHelper.close(rs);
            ConnectionHelper.close(pstmt);
            ConnectionHelper.close(conn);
        }
        return null;
    }

    public Member selectMemberInfo(String id) {//ȸ������ ���� Ŭ���� ���� ����

        Connection conn = ConnectionHelper.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = conn.prepareStatement( "select ename, email,genre from member"
                    + " where id=?");
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
            ConnectionHelper.close(rs);
            ConnectionHelper.close(pstmt);
            ConnectionHelper.close(conn);
        }
        return null;
    }

    public ArrayList<Member> selectMember(String id){
        Connection conn = ConnectionHelper.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<Member> list = new ArrayList<>();
        try {
            pstmt = conn.prepareStatement("select ename, email,genre from member"
                    + " where id=?");
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
            ConnectionHelper.close(rs);
            ConnectionHelper.close(pstmt);
            ConnectionHelper.close(conn);
        }
        return list;
    }

    public ArrayList<Member> selectAllMember(){
        Connection conn = ConnectionHelper.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<Member> list = new ArrayList<>();
        try {
            pstmt = conn.prepareStatement("select id, ename, email,genre from member");
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
            ConnectionHelper.close(rs);
            ConnectionHelper.close(pstmt);
            ConnectionHelper.close(conn);
        }
        return list;
    }

    public boolean updateMemberInfo(String id,String pass) {
        Connection conn = ConnectionHelper.getConnection();
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement("update member set pass=? where id=?");
            pstmt.setString(1, pass);
            pstmt.setString(2, id);
            int t = pstmt.executeUpdate();
            if(t>0) return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionHelper.close(pstmt);
            ConnectionHelper.close(conn);
        }
        return false;
    }

    public boolean dupliCheck(String checkStr) {
        Connection conn = ConnectionHelper.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            String sql;
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
            ConnectionHelper.close(rs);
            ConnectionHelper.close(pstmt);
            ConnectionHelper.close(conn);
        }
        return false;
    }

    public boolean updateGenre(String id,String genre) {

        Connection conn = ConnectionHelper.getConnection();
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement("update member set genre=? where id=?");
            pstmt.setString(1, genre);
            pstmt.setString(2, id);
            int t = pstmt.executeUpdate();
            if(t>0) return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionHelper.close(pstmt);
            ConnectionHelper.close(conn);
        }
        return false;
    }

    public boolean updateCashCharge(String id,int cash) { 
        Connection conn = ConnectionHelper.getConnection();
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement("update member set cash=cash+? where id=?");
            pstmt.setInt(1, cash);
            pstmt.setString(2, id);
            int t = pstmt.executeUpdate();
            if(t>0) return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionHelper.close(pstmt);
            ConnectionHelper.close(conn);
        }
        return false;
    }

    public boolean updateAfterPay(Member m) {
        Connection conn = ConnectionHelper.getConnection();
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement("update member set cash = cash-?, point = point-?"
                    + " where id=?");
            pstmt.setInt(1, m.getCash());
            pstmt.setInt(2, m.getPoint());
            pstmt.setString(3, m.getId());
            int t = pstmt.executeUpdate();
            if(t>0) return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionHelper.close(pstmt);
            ConnectionHelper.close(conn);
        }	
        return false;
    }

    public int selectGrade(String id) {
        Connection conn = ConnectionHelper.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = conn.prepareStatement("select egrade from member where id=?");
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
            if(rs.next()) {
                return rs.getInt("egrade");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionHelper.close(rs);
            ConnectionHelper.close(pstmt);
            ConnectionHelper.close(conn);
        }
        return 0;
    }

    public boolean updateGrade(String id, int egrade) {
        Connection conn = ConnectionHelper.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = conn.prepareStatement("update member set egrade=? where id=?");
            pstmt.setInt(1, egrade);
            pstmt.setString(2, id);
            int t = pstmt.executeUpdate();
            if(t>0) return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionHelper.close(rs);
            ConnectionHelper.close(pstmt);
            ConnectionHelper.close(conn);
        }
        return false;
    }
}
