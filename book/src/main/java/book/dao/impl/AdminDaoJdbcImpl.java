package book.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import book.dao.AdminDao;
import book.util.DsUtil;

public class AdminDaoJdbcImpl implements AdminDao {

	@Override
	public boolean get(String name, String pwd) {
		Connection conn = null;
		PreparedStatement stmt=null;
		ResultSet rs = null;
		boolean ret = false;
		try {
			conn = DsUtil.getConn();
			String  sql="select * from t_admin where name=? and pwd=?";
			System.out.println(sql);
			//stmt = conn.createStatement();
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, name);
			stmt.setString(2, pwd);
			rs=stmt.executeQuery();
			if (rs.next()) {
				ret = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DsUtil.free(rs, stmt, conn);
		}
		return ret;
	}

}
