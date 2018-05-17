package book.biz.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import book.biz.adminBiz;
import book.util.DsUtil;

public class adminImpl  implements adminBiz{

	public boolean checkuser(String name, String pwd) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		boolean ts = false;
		try {
			conn = DsUtil.getConn();
			String sql = "select * from user where username = ? and password = ? ";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, name);
			stmt.setString(2, pwd);
			rs = stmt.executeQuery();
			if(rs.next()) {
				ts = true;
			}
		} catch (SQLException e) {
			
		}finally {
			DsUtil.free(rs, stmt, conn);
		}
		return ts;
	}

}
