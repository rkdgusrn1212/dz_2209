package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.util.DBConnManager;

public class AdminDAO {
    public boolean checkIdPwd(String id, String pwd) {

        PreparedStatement pstmt = DBConnManager.getInstance().getPreparedStatement(
                "select pwd from admin where id = ?");
        try {
            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()) {
                if(rs.getString(1).equals(pwd)) {
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBConnManager.close(pstmt);
        }
        return false;
    }
}
