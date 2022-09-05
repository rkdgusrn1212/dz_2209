package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.vo.Quiz;

public class QuizDAO {
    
    public Quiz selectQuiz() {//전체 도서별 퀴즈 조회

        Connection conn = ConnectionHelper.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
             pstmt = conn.prepareStatement("select * from quiz");
             rs = pstmt.executeQuery();
             while (rs.next()) {
                 Quiz q = new Quiz(rs.getInt("isbn"),
                                   rs.getString("quiz"),
                                   rs.getString("answer"));
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
    
    public boolean insertQuiz(Quiz q) {//도서별 퀴즈 입력
        Connection conn = ConnectionHelper.getConnection();
        PreparedStatement pstmt = null;
         try {
             pstmt = conn.prepareStatement("insert into quiz values (?,?,?)");
             pstmt.setInt(1, q.getIsbn());
             pstmt.setString(2, q.getQuiz());
             pstmt.setString(3, q.getAnswer());
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
    
    public boolean updateQuiz(Quiz q) {//도서별 퀴즈 변경  <--만약 필요할 때 사용
        Connection conn = ConnectionHelper.getConnection();
        PreparedStatement pstmt = null;
        try {
             pstmt = conn.prepareStatement("update quiz set quiz=?,answer=? where isbn=?");
             pstmt.setString(1, q.getQuiz());
             pstmt.setString(2, q.getAnswer());
             pstmt.setInt(3, q.getIsbn());
             
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
    
    
    
    public boolean deleteQuiz(int isbn) {//해당 도서 퀴즈 삭제
        Connection conn = ConnectionHelper.getConnection();
        PreparedStatement pstmt = null;
        try {
             pstmt = conn.prepareStatement("delete from quiz where isbn=?");
             pstmt.setInt(1, isbn);
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
}
