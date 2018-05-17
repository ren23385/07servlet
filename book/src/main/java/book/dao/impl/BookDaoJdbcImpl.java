package book.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import book.dao.BookDao;
import book.util.DsUtil;

public class BookDaoJdbcImpl implements BookDao {

	@Override
	public int save(String name, String descri, double price, String author, int tid, String newFileName,Date pubDate) {
		Connection conn=null;
		PreparedStatement stmt=null;
		try {
			conn=DsUtil.getConn();
			String sql="insert into bookdetails(tid,bookname,bookdesc,bookauthor,bookprice,booktime,bookphoto) values(?,?,?,?,?,?,?)";
			stmt=conn.prepareStatement(sql);
			stmt.setInt(1, tid);
			stmt.setString(2, name);
			stmt.setString(3, descri);
			stmt.setString(4, author);
			stmt.setDouble(5, price);
			stmt.setDate(6, new java.sql.Date(pubDate.getTime()));
			stmt.setString(7, newFileName);
			
			int ret=stmt.executeUpdate();
			return ret;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DsUtil.free(stmt, conn);
		}
		
		return 0;
	}

}
