package book.biz.impl;

import java.util.Date;

import book.biz.BookBiz;
import book.dao.BookDao;
import book.dao.impl.BookDaoJdbcImpl;


public class BookBizImpl implements BookBiz {

	@Override
	public int saveBook(String name, String descri, double price, String author, int tid, String newFileName,Date pubDate) {
		BookDao bookDao=new BookDaoJdbcImpl();
		return bookDao.save(name,descri,price,author,tid,newFileName,pubDate);
	}

}
