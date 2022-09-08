package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.util.DBConnManager;
import model.vo.Book;
import model.vo.Quiz;

public class QuizDAO {
    
//    public Quiz selectQuiz() {//전체 퀴즈 조회 
//        PreparedStatement pstmt = DBConnManager.getInstance().getPreparedStatement(
//                "select * from quiz");
//        ResultSet rs = null;
//        try {
//             rs = pstmt.executeQuery();
//             while (rs.next()) {
//                 Quiz q = new Quiz(
//                                   rs.getInt("quizId"),
//                                   rs.getInt("isbn"),
//                                   rs.getString("question"),
//                                   rs.getString("answer"));
//             }
//          } catch (SQLException e) {
//             e.printStackTrace();
//          } finally {
//              DBConnManager.close(rs);
//              DBConnManager.close(pstmt);
//          }
//        return null;
//    }
    
    //퀴즈 문제 출력 (select question from quiz where quizId=1)
    //(bookSelectView에서의 '도서 퀴즈' 버튼 클릭 시)
    public Quiz selectQuizQuestion(int quizId) {
        PreparedStatement pstmt = DBConnManager.getInstance().getPreparedStatement(
                "select question from quiz where quizId = ?");
        ResultSet rs = null;
        Quiz q = null;
        
        try {
//            pstmt.setInt(1, quizId);
             rs = pstmt.executeQuery();
             while (rs.next()) {
                 q = new Quiz( rs.getString("question"));
             }
          } catch (SQLException e) {
             e.printStackTrace();
          } finally {
              DBConnManager.close(rs);
              DBConnManager.close(pstmt);
          }
        return q;
    }
    
    //퀴즈 정답 도출 (select question from quiz where quizId=1)
    //뽑아낸 정답(=Answer)과 '라디오버튼 체크한 값'이 같은지 검사하기 위함
    public Quiz selectQuizAnswer(int quizId) {
        PreparedStatement pstmt = DBConnManager.getInstance().getPreparedStatement(
                "select answer from quiz where quizId = ?");
        ResultSet rs = null;
        Quiz q = null;
        
        try {
//            pstmt.setInt(1, quizId);
             rs = pstmt.executeQuery();
             while (rs.next()) {
                 q = new Quiz( rs.getString("answer"));
             }
             
//             return q;
          } catch (SQLException e) {
             e.printStackTrace();
          } finally {
              DBConnManager.close(rs);
              DBConnManager.close(pstmt);
          }
        return q;
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
    
    
    
//    public void insertQuiz(Quiz q) {//AdminView에서의 퀴즈 추가  
//        PreparedStatement pstmt = DBConnManager.getInstance().getPreparedStatement(
//                "insert into quiz values (?,?,?,?)");
//         try {
//             pstmt.setInt(1, q.getQuizId());
//             pstmt.setInt(2, q.getIsbn());
//             pstmt.setString(3, q.getQuestion());
//             pstmt.setString(4, q.getAnswer());
////             int t = pstmt.executeUpdate();
////             if(t>0) return true;
//          } catch (SQLException e) {
//             e.printStackTrace();
//          } finally {
//              DBConnManager.close(pstmt);
//          }
////        return false;
//    }
    
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
