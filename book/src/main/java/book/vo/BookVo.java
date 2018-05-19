package book.vo;

import java.io.Serializable;
import java.util.Date;

public class BookVo implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private int tid;
	private String name;
	private String desc;
	private String author;
	private double price;
	private Date date;
	private String photo;
	
	
	public BookVo() {
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getTid() {
		return tid;
	}


	public void setTid(int tid) {
		this.tid = tid;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDesc() {
		return desc;
	}


	public void setDesc(String desc) {
		this.desc = desc;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public Date getdate() {
		return date;
	}


	public void setdate(Date date) {
		this.date = date;
	}


	public String getPhoto() {
		return photo;
	}


	public void setPhoto(String photo) {
		this.photo = photo;
	}

}
