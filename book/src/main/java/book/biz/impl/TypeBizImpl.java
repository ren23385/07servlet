package book.biz.impl;

import java.util.List;

import book.biz.TypeBiz;
import book.dao.TypeDao;
import book.dao.impl.TypeDaoJdbcImpl;
import book.vo.TypeVo;

public class TypeBizImpl implements TypeBiz {

	@Override
	public List<TypeVo> findAllTypes() {
		TypeDao typeDao=new TypeDaoJdbcImpl();
		return typeDao.findAll();
	}

}
