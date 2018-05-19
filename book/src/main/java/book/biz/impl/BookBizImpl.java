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
	public List<BookVo> findAllBooks(int pageNo) {
		BookDao bookDao=new BookDaoJdbcImpl();
		return  bookDao.findAll(pageNo);
	}

	@Override
	public int findTotal() {
		BookDao bookDao=new BookDaoJdbcImpl();
		return bookDao.getTotal();
	}

}
