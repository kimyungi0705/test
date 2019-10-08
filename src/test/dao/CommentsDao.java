package test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jdbc.JdbcUtil;
import test.vo.CommentsVo;

public class CommentsDao {
	private static CommentsDao commentsDao = new CommentsDao();
	public static CommentsDao getCommentsDao() {
		return commentsDao;
	}
	private CommentsDao() {}
	
	public int insert(CommentsVo vo) {
		Connection con=null;
		PreparedStatement pstmt=null;
		String sql=
			"insert into comments values(comments_seq.nextval,?,?,?)";
		try {
			con=JdbcUtil.getConn();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,vo.getMnum());
			pstmt.setString(2,vo.getId());
			pstmt.setString(3,vo.getComments());
			return pstmt.executeUpdate();
		}catch(SQLException se) {
			System.out.println(se.getMessage());
			return -1;
		}finally {
			JdbcUtil.close(con, pstmt,null);
		}	
	}
	public ArrayList<CommentsVo> list(int mnum){
		String sql="select * from comments where mnum=?";
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=JdbcUtil.getConn();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,mnum);
			rs=pstmt.executeQuery();
			ArrayList<CommentsVo> commList=new ArrayList<CommentsVo>();
			while(rs.next()) { 
				CommentsVo vo=new CommentsVo(rs.getInt("num"),
						rs.getInt("mnum"), 
						rs.getString("id"), 
						rs.getString("comments"));
				commList.add(vo);
			}
			return commList;
		}catch(SQLException se) {
			System.out.println(se.getMessage());
			return null;
		}finally {
			JdbcUtil.close(con, pstmt, rs);
		}
	}
		
	
}








