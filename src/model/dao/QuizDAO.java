package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.util.DBConnManager;
import model.vo.Quiz;

public class QuizDAO {
    
    public Quiz selectQuiz() {//전체 퀴즈 조회
        PreparedStatement pstmt = DBConnManager.getInstance().getPreparedStatement(
                "select * from quiz");
        ResultSet rs = null;
        try {
             rs = pstmt.executeQuery();
             while (rs.next()) {
                 Quiz q = new Quiz(
                                   rs.getInt("quizId"),
                                   rs.getInt("isbn"),
                                   rs.getString("question"),
                                   rs.getString("answer"));
             }
          } catch (SQLException e) {
             e.printStackTrace();
          } finally {
              DBConnManager.close(rs);
              DBConnManager.close(pstmt);
          }
        return null;
    }
    
    public boolean insertQuiz(Quiz q) {//AdminView에서의 퀴즈 추가  
        PreparedStatement pstmt = DBConnManager.getInstance().getPreparedStatement(
                "insert into quiz values (?,?,?,?)");
         try {
             pstmt.setInt(1, q.getQuizId());
             pstmt.setInt(2, q.getIsbn());
             pstmt.setString(3, q.getQuestion());
             pstmt.setString(4, q.getAnswer());
             int t = pstmt.executeUpdate();
             if(t>0) return true;
          } catch (SQLException e) {
             e.printStackTrace();
          } finally {
              DBConnManager.close(pstmt);
          }
        return false;
    }
    
//    public boolean insertQuiz(Quiz q) {//도서별 퀴즈 입력
//        PreparedStatement pstmt = DBConnManager.getInstance().getPreparedStatement(
//                "insert into quiz values (?,?,?)");
//         try {
//             pstmt.setInt(1, q.getIsbn());
//             pstmt.setString(2, q.getQuiz());
//             pstmt.setString(3, q.getAnswer());
//             int t = pstmt.executeUpdate();
//             if(t>0) return true;
//          } catch (SQLException e) {
//             e.printStackTrace();
//          } finally {
//              DBConnManager.close(pstmt);
//          }
//        return false;
//    }
//    
//    public boolean updateQuiz(Quiz q) {//도서별 퀴즈 변경  <--만약 필요할 때 사용
//        PreparedStatement pstmt = DBConnManager.getInstance().getPreparedStatement(
//                "update quiz set quiz=?,answer=? where isbn=?");
//        try {
//             pstmt.setString(1, q.getQuiz());
//             pstmt.setString(2, q.getAnswer());
//             pstmt.setInt(3, q.getIsbn());
//             
//             int t = pstmt.executeUpdate();
//             if(t>0) return true;
//          } catch (SQLException e) {
//             e.printStackTrace();
//          } finally {
//              DBConnManager.close(pstmt);
//          }
//        return false;
//    }
//    
//    
//    
//    public boolean deleteQuiz(int isbn) {//해당 도서 퀴즈 삭제
//        PreparedStatement pstmt = DBConnManager.getInstance().getPreparedStatement(
//                "delete from quiz where quizId=?");
//        try {
//             pstmt.setInt(1, isbn);
//             int t = pstmt.executeUpdate();
//             if(t>0) return true;
//          } catch (SQLException e) {
//             e.printStackTrace();
//          } finally {
//              DBConnManager.close(pstmt);
//          }
//        return false;
//    }
}
