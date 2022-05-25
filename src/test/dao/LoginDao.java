package test.dao;


import db.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

/*
[ 싱글톤 패턴]
-객체가 하나만 생성되게 하는 기법. 객체를 공유해서 사용한다.
-만드는 방법
1.객체자신을 static멤버로 생성한다.
2.생성자를 private로 만들어 외부에서는 생성하지 못하도록 한다.
3.1에서 생성힌 객체를 리턴하는 static 메소드를 만든다.
 */

public class LoginDao {
    //1.객체자신을 static멤버로 생성한다.
    private static LoginDao instance = new LoginDao();

    //2.생성자를 private로 만든다.
    private LoginDao() {}

    //3.1에서 생성한 객체를 리턴하는 메소드
    public static LoginDao getInstance(){
        return instance;
    }

    public boolean isMember(HashMap<String, String> map){
        String id= map.get("id");
        String pwd = map.get("pwd");
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            con = JdbcUtil.getCon();
            String sql = "select * from member2 where id=? and pwd=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1,id);
            pstmt.setString(2,pwd);
            rs= pstmt.executeQuery();
            if(rs.next()){
                return true;
            }
            return false;
        }catch (SQLException se){
            se.printStackTrace();
        }finally {
            JdbcUtil.close(con,pstmt,rs);
        }
        return false;
    }
}
