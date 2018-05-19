package book.biz;

import java.util.List;

import book.vo.BookVo;

public interface BookBiz {

	int saveBook(BookVo bookvo);
	List<BookVo> findAllBooks(int pageNo);

	int findTotal();

}
