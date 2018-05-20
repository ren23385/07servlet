package book.biz.impl;

import java.util.List;

import book.biz.BookBiz;
import book.dao.BookDao;
import book.dao.impl.BookDaoJdbcImpl;
import book.vo.BookVo;


public class BookBizImpl implements BookBiz {

	@Override
	public int saveBook(BookVo bookvo) {
		BookDao bookDao=new BookDaoJdbcImpl();
		return bookDao.save(bookvo);
	}

	@Override
	public List<BookVo> findAllBooks(int pageNo,String name,int id) {
		BookDao bookDao=new BookDaoJdbcImpl();
		return  bookDao.findAll(pageNo,name,id);
	}

	@Override
	public int findTotal(String name ,int tid) {
		BookDao bookDao=new BookDaoJdbcImpl();
		return bookDao.getTotal(name,tid);
	}

	@Override
	public boolean bookdel(int id) {
		BookDao bookDao = new BookDaoJdbcImpl();
		return bookDao.del(id);
	}

	@Override
	public BookVo findById(int id) {
		BookDao bookDao = new BookDaoJdbcImpl();
		
		return bookDao.findById(id);
	}

}
