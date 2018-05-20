package book.biz;

import java.util.List;

import book.vo.BookVo;

public interface BookBiz {

	int saveBook(BookVo bookvo);
	List<BookVo> findAllBooks(int pageNo, String name, int id);

	int findTotal(String name, int id);
	boolean bookdel(int id);
	BookVo findById(int id);

}
