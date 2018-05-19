package book.dao;

import java.util.List;

import book.vo.BookVo;

public interface BookDao {

	//int save(String name, String descri, double price, String author, int tid, String newFileName, Date pubDate);
	public int save (BookVo bookvo);
	List<BookVo> findAll(int pageNo);

	int getTotal();
}
