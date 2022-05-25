package test.dao;

import db.JdbcUtil;
import test.vo.Member;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberDao {
    public ArrayList<Member> selectAll(){
        Connection con=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        try {
            con=JdbcUtil.getCon();
            String sql="select * from member2";
            pstmt=con.prepareStatement(sql);
            rs=pstmt.executeQuery();
            ArrayList<Member> list=new ArrayList<Member>();
            while(rs.next()) {
                String id=rs.getString("id");
                String pwd=rs.getString("pwd");
                String email=rs.getString("email");
                int age=rs.getInt("age");
                Date regdate=rs.getDate("regdate");
                Member member=new Member(id, pwd, email, age, regdate);
                list.add(member);
            }
            return list;
        }catch(SQLException s) {
            s.printStackTrace();
            return null;
        }finally {
            JdbcUtil.close(con, pstmt, rs);
        }
    }
    public int insert(Member vo) {
        Connection con=null;
        PreparedStatement pstmt=null;
        try {
            con=JdbcUtil.getCon();
            String sql="insert into member2 values(?,?,?,?,sysdate)";
            pstmt=con.prepareStatement(sql);
            pstmt.setString(1,vo.getId());
            pstmt.setString(2,vo.getPwd());
            pstmt.setString(3,vo.getEmail());
            pstmt.setInt(4,vo.getAge());
            return pstmt.executeUpdate();
        }catch(SQLException s) {
            s.printStackTrace();
            return -1;
        }finally {
            JdbcUtil.close(con, pstmt, null);
        }
    }

}