package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.util.DBConnManager;
import model.vo.History;

public class HistoryDAO {

    public ArrayList<History> selectHistory(String id) {

        PreparedStatement pstmt = DBConnManager.getInstance().getPreparedStatement("select * from history where id=? ");
        ResultSet rs = null;
        ArrayList<History> list = new ArrayList<>();
        try {
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
            DBConnManager.close(rs);
            DBConnManager.close(pstmt);
        }
        return list;
    }

    public ArrayList<History> selectAllHistory() {
        PreparedStatement pstmt = DBConnManager.getInstance().getPreparedStatement("select * from history");
        ResultSet rs = null;
        ArrayList<History> list = new ArrayList<>();
        try {
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
            DBConnManager.close(rs);
            DBConnManager.close(pstmt);
        }
        return list;
    }

    public boolean insertHistory(History h) {
        PreparedStatement pstmt = DBConnManager.getInstance().getPreparedStatement("insert into history values (?,?,?,?)");
        try {
            pstmt.setString(1, h.getId());
            pstmt.setInt(2, h.getIsbn());
            pstmt.setInt(3, h.getPrice());
            pstmt.setInt(4, h.getClear());
            int t = pstmt.executeUpdate();
            if(t>0) return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnManager.close(pstmt);
        }
        return false;
    }

    public boolean updateHistory(History h) {
        PreparedStatement pstmt = DBConnManager.getInstance().getPreparedStatement("update history set price= ?, clear=? where id=? and isbn=?");
        try {
            pstmt.setInt(1, h.getPrice());
            pstmt.setInt(2, h.getClear());
            pstmt.setString(3, h.getId());
            pstmt.setInt(4, h.getIsbn());
            int t = pstmt.executeUpdate();
            if(t>0) return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnManager.close(pstmt);
        }
        return false;
    }

    public int countClear(String id) {
        PreparedStatement pstmt = DBConnManager.getInstance().getPreparedStatement(
            "select count(*) as count from history where id=?");
        ResultSet rs = null;
        try {
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
            rs.next();
            return rs.getInt("count");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnManager.close(rs);
            DBConnManager.close(pstmt);
        }
        return 0;
    }
}
