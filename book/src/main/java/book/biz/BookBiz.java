package book.biz;

import java.util.Date;

public interface BookBiz {

	int saveBook(String name, String descri, double price, String author, int tid, String newFileName, Date pubDate);

}
