package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.vo.History;

public class HistoryDAO {

    public ArrayList<History> selectHistory(String id) {

        Connection conn = ConnectionHelper.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        ArrayList<History> list = new ArrayList<>();
        try {
            pstmt = conn.prepareStatement("select * from history where id=? ");
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
            ConnectionHelper.close(rs);
            ConnectionHelper.close(pstmt);
            ConnectionHelper.close(conn);
        }
        return list;
    }

    public ArrayList<History> selectAllHistory() { 
        Connection conn = ConnectionHelper.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<History> list = new ArrayList<>();
        try {
            pstmt = conn.prepareStatement("select * from history");
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
            ConnectionHelper.close(rs);
            ConnectionHelper.close(pstmt);
            ConnectionHelper.close(conn);
        }
        return list;
    }

    public boolean insertHistory(History h) {
        Connection conn = ConnectionHelper.getConnection();
        PreparedStatement pstmt = null;

        try {
            pstmt = conn.prepareStatement("insert into history values (?,?,?,?)");
            pstmt.setString(1, h.getId());
            pstmt.setInt(2, h.getIsbn());
            pstmt.setInt(3, h.getPrice());
            pstmt.setInt(4, h.getClear());
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

    public boolean updateHistory(History h) {
        Connection conn = ConnectionHelper.getConnection();
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement("update history set price= ?, clear=? where id=? and isbn=?");
            pstmt.setInt(1, h.getPrice());
            pstmt.setInt(2, h.getClear());
            pstmt.setString(3, h.getId());
            pstmt.setInt(4, h.getIsbn());
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

    public int countClear(String id) {
        Connection conn = ConnectionHelper.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
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
            ConnectionHelper.close(rs);
            ConnectionHelper.close(pstmt);
            ConnectionHelper.close(conn);
        }
        return 0;
    }
}
