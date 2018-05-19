package book.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import book.dao.TypeDao;
import book.util.DsUtil;
import book.vo.TypeVo;

public class TypeDaoJdbcImpl implements TypeDao {

	@Override
	public List<TypeVo> findAll() {
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			conn=DsUtil.getConn();
			stmt=conn.createStatement();
			rs=stmt.executeQuery("select * from type");
			List<TypeVo> ls=new ArrayList<>();
			while (rs.next()) {
				TypeVo typeVo=new TypeVo();
				typeVo.setId(rs.getInt("id"));
				typeVo.setName(rs.getString("typename"));
				ls.add(typeVo);
			}
			return ls;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
			DsUtil.free(rs, stmt, conn);
		}
		
		return null;
	}

}
