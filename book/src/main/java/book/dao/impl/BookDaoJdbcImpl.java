package book.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import book.dao.BookDao;
import book.util.DsUtil;
import book.util.PageConstant;
import book.vo.BookVo;

public class BookDaoJdbcImpl implements BookDao {

	@Override
	public int save(BookVo bookvo) {
		Connection conn=null;
		PreparedStatement stmt=null;
		try {
			conn=DsUtil.getConn();
			String sql="insert into bookdetails(tid,bookname,bookdesc,bookauthor,bookprice,booktime,bookphoto) values(?,?,?,?,?,?,?)";
			stmt=conn.prepareStatement(sql);
			stmt.setInt(1, bookvo.getTid());
			stmt.setString(2, bookvo.getName());
			stmt.setString(3, bookvo.getDesc());
			stmt.setString(4, bookvo.getAuthor());
			stmt.setDouble(5, bookvo.getPrice());
			stmt.setDate(6, new java.sql.Date(bookvo.getdate().getTime()));
			//stmt.setDate(6, new java.sql.Date(bookvo.getdate().getTime()));
			stmt.setString(7, bookvo.getPhoto());
			int ret=stmt.executeUpdate();
			return ret;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DsUtil.free(stmt, conn);
		}
		
		return 0;
	}

	@Override
	public List<BookVo> findAll(int pageNo,String name ,int tid) {
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			conn=DsUtil.getConn();
			stmt=conn.createStatement();
			String sql = "select * from bookdetails where 1 = 1";
			
			//4种情况执行
		
			if(tid != -1) {
				sql += " and tid = "+tid;
			}
			if(name!=null && !name.equals("")) {
				sql += " and bookname like '%"+name+"%'";
			}		
			
			sql += " limit "+((pageNo-1)*PageConstant.PAGE_SIZE+1-1)+","+PageConstant.PAGE_SIZE;
			rs=stmt.executeQuery(sql);
			List<BookVo> ls=new ArrayList<>();
			while (rs.next()) {//
				//tid,bookname,bookdesc,bookauthor,bookprice,booktime,bookphoto
		      BookVo bookVo=new BookVo();
		      bookVo.setAuthor(rs.getString("bookauthor"));
		      bookVo.setDesc(rs.getString("bookdesc"));
		      bookVo.setId(rs.getInt("id"));
		      bookVo.setName(rs.getString("bookname"));
		      bookVo.setPhoto(rs.getString("bookphoto"));
		      bookVo.setPrice(rs.getDouble("bookprice"));
		      bookVo.setdate(rs.getDate("booktime"));
		      bookVo.setTid(rs.getInt("tid"));
		      ls.add(bookVo);
			}
			return ls;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
			DsUtil.free(rs, stmt, conn);
		}
		
		return null;
	}

	@Override
	public int getTotal(String name,int tid) {
		Connection conn = null;
		PreparedStatement stmt=null;
		ResultSet rs = null;
		try {
			conn = DsUtil.getConn();			
			String  sql="select count(*) from bookdetails where 1 = 1";
			
			if(tid != -1) {
				sql+= " and tid = "+tid;
			}
			if(name != null && !name.equals("")) {
				sql += " and bookname like '%"+name+"%'";
			}
			
			stmt=conn.prepareStatement(sql);			
			rs=stmt.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DsUtil.free(rs, stmt, conn);
		}
		return 0;
	}

	@Override
	public boolean del(int id) {
		Connection conn = null;
		PreparedStatement stmt=null;
		boolean rs = false;
		try {
			conn = DsUtil.getConn();			
			String  sql="delete  from bookdetails where id = "+id;
			System.out.println(sql);			
			stmt=conn.prepareStatement(sql);			
			rs = stmt.execute();
			if(rs)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DsUtil.free( stmt, conn);
		}
		return false;
	}

	@Override
	public BookVo findById(int id) {
		
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			conn=DsUtil.getConn();
			stmt=conn.createStatement();
			String sql = "select * from bookdetails where id ="+id;
			rs=stmt.executeQuery(sql);
			List<BookVo> ls=new ArrayList<>();
			while (rs.next()) {//
		      BookVo bookVo=new BookVo();
		      ls.add(bookVo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
			DsUtil.free(rs, stmt, conn);
		}
		
		
		return null;
	}
}
