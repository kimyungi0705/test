package test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.JdbcUtil;
import test.vo.MovieVo;

public class MovieDao {
	private static MovieDao movieDao=new MovieDao();
	public static MovieDao getMovieDao() {
		return movieDao;
	}
	private MovieDao() {}
	
	public MovieVo getinfo(int mnum) {
		String sql="select * from movie where mnum=?";
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=JdbcUtil.getConn();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,mnum);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				String title=rs.getString("title");
				String content=rs.getString("content");
				String director=rs.getString("director");
				MovieVo vo=new MovieVo(mnum, title, content, director);
				return vo;
			}
			return null;
		}catch(SQLException se) {
			System.out.println(se.getMessage());
			return null;
		}finally {
			JdbcUtil.close(con, pstmt, rs);
		}
	}
}













