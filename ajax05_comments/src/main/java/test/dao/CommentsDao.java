package test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.JdbcUtil;
import test.vo.CommentsVo;

public class CommentsDao {
	private static CommentsDao instance = new CommentsDao();

	private CommentsDao() {
	}

	public static CommentsDao getInstance() {
		return instance;
	}
	

	public int delete(int num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		con = JdbcUtil.getCon();
		try {
			String sql = "delete from comments where num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			int n = pstmt.executeUpdate();
			return n;
		} catch (SQLException s) {
			s.printStackTrace();
			return -1;
		} finally {
			JdbcUtil.close(con, pstmt, null);
		}
	}

	public int insert(CommentsVo vo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		con = JdbcUtil.getCon();
		try {
			String sql = "insert into comments values(comments_seq.nextval,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, vo.getMnum());
			pstmt.setString(2, vo.getId());
			pstmt.setString(3, vo.getComments());
			int n = pstmt.executeUpdate();
			return n;
		} catch (SQLException s) {
			s.printStackTrace();
			return -1;
		} finally {
			JdbcUtil.close(con, pstmt, null);
		}
	}

	public ArrayList<CommentsVo> cList(int mnum) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		con = JdbcUtil.getCon();
		try {
			String sql = "select * from comments where mnum=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, mnum);
			rs = pstmt.executeQuery();
			ArrayList<CommentsVo> list = new ArrayList<CommentsVo>();
			while (rs.next()) {
				int num = rs.getInt("num");
				String id = rs.getString("id");
				String comments = rs.getString("comments");
				CommentsVo vo = new CommentsVo(num, mnum, id, comments);
				list.add(vo);
			}
			return list;
		} catch (SQLException s) {
			s.printStackTrace();
			return null;
		} finally {
			JdbcUtil.close(con, pstmt, rs);
		}
	}
	
	public ArrayList<CommentsVo> cList(int mnum,int startRow, int endRow) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		con = JdbcUtil.getCon();
		try {
			String sql = "select * from ("
					+ "select com.*,rownum rnum from ("
					+ "select * from comments where mnum=? order by num decs"
					+ ")com"
					+ ") where rnum >=? and rnum<=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, mnum);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			rs = pstmt.executeQuery();
			ArrayList<CommentsVo> list = new ArrayList<CommentsVo>();
			while (rs.next()) {
				int num = rs.getInt("num");
				String id = rs.getString("id");
				String comments = rs.getString("comments");
				CommentsVo vo = new CommentsVo(num, mnum, id, comments);
				list.add(vo);
			}
			return list;
		} catch (SQLException s) {
			s.printStackTrace();
			return null;
		} finally {
			JdbcUtil.close(con, pstmt, rs);
		}
	}
	public int getCount(int mnum) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		con = JdbcUtil.getCon();
		try {
			String sql="selecct nvl(count(*),0) from comments where mnum=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, mnum);
			rs=pstmt.executeQuery();
			rs.next();
			return rs.getInt(1);
		}catch(SQLException se){
			se.printStackTrace();
			return -1;
		}finally {
			JdbcUtil.close(con, pstmt, rs);
		}
	}
}
