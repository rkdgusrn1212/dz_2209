package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.util.DBConnManager;
import model.vo.Member;

public class MemberDAO {

    public boolean loginCheck(String id, String pwd) {
        PreparedStatement pstmt = DBConnManager.getInstance().getPreparedStatement(
                "select count(*) from member  where id=? and pwd=?");
        ResultSet rs = null;
        try {
            pstmt.setString(1, id);
            pstmt.setString(2, pwd);
            rs = pstmt.executeQuery();
            rs.next();
            int t = rs.getInt(1);
            if(t>0)
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnManager.close(rs);
            DBConnManager.close(pstmt);
        }
        return false;
    }

    public boolean insertJoin(Member m) {
        PreparedStatement pstmt = DBConnManager.getInstance().getPreparedStatement(
                "insert into member values (?,?,?,?,?,?,?,?)");
        try {
            pstmt.setString(1, m.getId());
            pstmt.setString(2, m.getPass());
            pstmt.setString(3, m.getEname());
            pstmt.setString(4, m.getEmail());
            pstmt.setString(5, m.getGenre());
            pstmt.setInt(6, 3);
            pstmt.setInt(7, 0);
            pstmt.setInt(8, 0);
            int t = pstmt.executeUpdate();
            if (t > 0)
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnManager.close(pstmt);
        }
        return false;
    }

    public Member findIdpwd(String email) {
        PreparedStatement pstmt = DBConnManager.getInstance().getPreparedStatement(
                "select id,pwd from member where email = ?");
        ResultSet rs = null;
        try {
            pstmt.setString(1, email);
            rs = pstmt.executeQuery();
            if(rs.next()) {
                Member m = new Member();
                m.setId(rs.getString("id"));
                m.setPass(rs.getString("pwd"));
                return m;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnManager.close(rs);
            DBConnManager.close(pstmt);
        }
        return null;
    }

    public Member selectMypage(String id) {
        PreparedStatement pstmt = DBConnManager.getInstance().getPreparedStatement(
                "select name, grade, point,cash from member where id=?");
        ResultSet rs = null;
        try {
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Member(rs.getString("name"),
                        rs.getInt("grade"),
                        rs.getInt("point"), 
                        rs.getInt("cash"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnManager.close(rs);
            DBConnManager.close(pstmt);
        }
        return null;
    }

    public String selectGenre(String id) {
        PreparedStatement pstmt = DBConnManager.getInstance().getPreparedStatement(
                "select genre from member where id=?");
        ResultSet rs = null;
        try {
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
            rs.next();
            return rs.getString("genre");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnManager.close(rs);
            DBConnManager.close(pstmt);
        }
        return null;
    }

    public Member selectMemberInfo(String id) {
        PreparedStatement pstmt = DBConnManager.getInstance().getPreparedStatement(
                "select name, email,genre from member");
        ResultSet rs = null;
        try {
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                Member m  = new Member();
                m.setId(id);
                m.setEname(rs.getString("name"));
                m.setEmail(rs.getString("email"));
                m.setGenre(rs.getString("genre"));
                return m;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnManager.close(rs);
            DBConnManager.close(pstmt);
        }
        return null;
    }

    public ArrayList<Member> selectMember(String id){
        PreparedStatement pstmt = DBConnManager.getInstance().getPreparedStatement(
                "select name, email,genre from member");
        ResultSet rs = null;
        ArrayList<Member> list = new ArrayList<>();
        try {
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                Member m  = new Member();
                m.setId(id);
                m.setEname(rs.getString("name"));
                m.setEmail(rs.getString("email"));
                m.setGenre(rs.getString("genre"));
                list.add(m);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnManager.close(rs);
            DBConnManager.close(pstmt);
        }
        return list;
    }

    public ArrayList<Member> selectAllMember(){
        PreparedStatement pstmt = DBConnManager.getInstance().getPreparedStatement(
                "select id, name, email,genre from member");
        ResultSet rs = null;
        ArrayList<Member> list = new ArrayList<>();
        try {
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Member m  = new Member();
                m.setId(rs.getString("id"));
                m.setEname(rs.getString("name"));
                m.setEmail(rs.getString("email"));
                m.setGenre(rs.getString("genre"));
                list.add(m);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnManager.close(rs);
            DBConnManager.close(pstmt);
        }
        return list;
    }

    public boolean updateMemberInfo(String id,String pwd) {
        PreparedStatement pstmt = DBConnManager.getInstance().getPreparedStatement(
                "update member set pwd=? where id=?");
        try {
            pstmt.setString(1, pwd);
            pstmt.setString(2, id);
            int t = pstmt.executeUpdate();
            if(t>0) return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnManager.close(pstmt);
        }
        return false;
    }

    public boolean dupliCheck(String checkStr) {
        String sql;
        if(checkStr.contains("@")) {
            sql = "select count(*) as count from member where email=?";              
        }else {
            sql = "select count(*) as count from member where id=?";
        }
        PreparedStatement pstmt = DBConnManager.getInstance().getPreparedStatement(sql);
        ResultSet rs = null;
        try {
            pstmt.setString(1, checkStr);
            rs = pstmt.executeQuery();
            rs.next();

            int t = rs.getInt("count");
            if(t>0) return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnManager.close(rs);
            DBConnManager.close(pstmt);
        }
        return false;
    }

    public boolean updateGenre(String id,String genre) {

        PreparedStatement pstmt = DBConnManager.getInstance().getPreparedStatement("update member set genre=? where id=?");
        try {
            pstmt.setString(1, genre);
            pstmt.setString(2, id);
            int t = pstmt.executeUpdate();
            if(t>0) return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnManager.close(pstmt);
        }
        return false;
    }

    public boolean updateCashCharge(String id,int cash) { 
        PreparedStatement pstmt = DBConnManager.getInstance().getPreparedStatement(
                "update member set cash=cash+? where id=?");
        try {
            pstmt.setInt(1, cash);
            pstmt.setString(2, id);
            int t = pstmt.executeUpdate();
            if(t>0) return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnManager.close(pstmt);
        }
        return false;
    }

    public boolean updateAfterPay(Member m) {
        PreparedStatement pstmt = DBConnManager.getInstance().getPreparedStatement(
                "update member set cash = cash-?, point = point-? where id=?");
        try {
            pstmt.setInt(1, m.getCash());
            pstmt.setInt(2, m.getPoint());
            pstmt.setString(3, m.getId());
            int t = pstmt.executeUpdate();
            if(t>0) return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnManager.close(pstmt);
        }	
        return false;
    }

    public int selectGrade(String id) {
        PreparedStatement pstmt = DBConnManager.getInstance().getPreparedStatement("select grade from member where id=?");
        ResultSet rs = null;
        try {
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
            if(rs.next()) {
                return rs.getInt("grade");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnManager.close(rs);
            DBConnManager.close(pstmt);
        }
        return 0;
    }

    public boolean updatgrade(String id, int grade) {
        PreparedStatement pstmt = DBConnManager.getInstance().getPreparedStatement("update member set grade=? where id=?");
        ResultSet rs = null;
        try {
            pstmt.setInt(1, grade);
            pstmt.setString(2, id);
            int t = pstmt.executeUpdate();
            if(t>0) return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnManager.close(rs);
            DBConnManager.close(pstmt);
        }
        return false;
    }
}
