package db.util;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.io.IOException;
/**
 * 싱글톤 패턴의 DB연결 관리 클래스
 * @author 강현구
 *
 */
public class DBConnManager {

    private static DBConnManager mInstance = null;
    private Connection mConn = null;
    private String mDsn;
    private String mUser;
    private String mPwd;

    /**
     * DBConnManager 인스턴스가 생성될때 인스턴스가 가질 Connection객체를 생성한다. 또한 생성에 필요한 문자열을 프로퍼티로 불러들인다.
     */
    private DBConnManager(){
        try {
            Properties pro = new Properties();
            pro.load(new FileReader("db.properties"));
            mDsn = pro.getProperty("dsn");
            mUser = pro.getProperty("user");
            mPwd = pro.getProperty("pwd");
            Class.forName(pro.getProperty("driver"));
            System.out.println("드라이버를 로드 완료!");
        } catch (IOException e) {
            System.out.println("프로퍼티를 불러오는데 실패하였습니다.");
            e.printStackTrace();
        }catch (ClassNotFoundException e) {
            System.out.println("드라이버를 찾을 수 없습니다.");
            e.printStackTrace();
        }
    }

    /**
     * DBConnManager의 유일한 인스턴스를 반환한다. 아직 생성이 안되었스면 생성한다.
     * @return DBConnManager가 유지하고 있는 DBConnManager의 인스턴스.
     */
    public static DBConnManager getInstance() {
        if(mInstance==null) {
            mInstance = new DBConnManager();
        }
        return mInstance;
    }

    /**
     * @return 현재 연결된 connection 객체를 반환, 기존 연결이 없거나 closed 상태라면 새로 연결생성 후 반환, 도중에 오류가 발생하면 null을 반환한다.
     */
    private Connection getConnection() {
        try {
            if(mConn==null||mConn.isClosed()) {//mConn객체가 GC 대상(혹은 진짜 없거나)이거나, 닫혀있다면.
                mConn = DriverManager.getConnection(mDsn, mUser, mPwd);//새로 연결해서 래퍼런스 저장.
            }
        } catch (SQLException e) {
            System.out.println("DB 연결 생성 실패");
            e.printStackTrace();
        }
        return mConn;
    }

    /**
     * DBConnManager를 더이상 사용하지 않을때 호출. 즉 앱이 종료될때 모든 연결을 종료하기 위해 호출한다.
     * 인스턴스가 가진 연결을 종료하고 인스턴스 레퍼런스를 삭제한다.
     */
    public static void dismiss() {
        if(mInstance != null) {
            try {
                if(mInstance.mConn!=null&&!mInstance.mConn.isClosed()) {
                    mInstance.mConn.close();
                    mInstance.mConn = null;
                }
            } catch (SQLException e) {
                System.out.println("DB 연결 닫기 실패");
                e.printStackTrace();
            }
            mInstance = null;
        }
    }

    /**
     * 싱글톤 클래스 인스턴스의 유일한 connection을 통해 생성한다.
     * @return 유일한 connection 객체를 통해 생성된 statement 객체;
     */
    public Statement getStatement() {
        try {
            return getConnection().createStatement();
        } catch (SQLException e) {
            System.out.println("Statement 생성에 실패");
            e.printStackTrace();
        }
        return null;
    }
    
    /**
    * 싱글톤 클래스 인스턴스의 유일한 connection을 통해 생성한다.
    * @return 유일한 connection 객체를 통해 생성된 prepareStatement 객체;
    */
    public PreparedStatement getPreparedStatement(String sql) {
        try {
            return getConnection().prepareStatement(sql);
        } catch (SQLException e) {
            System.out.println("Statement 생성에 실패");
            e.printStackTrace();
        }
        return null;
    }
    
    /**
     * 중복되는 statement close()호출부를 대신할 메소드다.
     * @param statement 닫을 statement
     */
    public static void close(Statement statement) {
        try {
            statement.close();
        } catch (SQLException e) {
            System.out.println("Statement 닫기 실패");
            e.printStackTrace();
        }
    }
    /**
     * 중복되는 ResultSet close()호출부를 대신할 메소드다.
     * @param resultSet 닫을 ResultSet
     */
    public static void close(ResultSet resultSet) {
        try {
            resultSet.close();
        } catch (SQLException e) {
            System.out.println("ResultSet 닫기 실패");
            e.printStackTrace();
        }
    }
}