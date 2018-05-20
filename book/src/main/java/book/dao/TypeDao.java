package book.dao;

import java.util.List;

import book.vo.TypeVo;

public interface TypeDao {

	List<TypeVo> findAll();

	List<TypeVo> findone(int id);

}
