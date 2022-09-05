package model.vo;

public class History {
	private String id;
	private int isbn;
	private int price;
	private int clear; 
	
	public History() {
		// TODO Auto-generated constructor stub
	}

	public History(String id, int isbn, int price, int clear) {
		super();
		this.id = id;
		this.isbn = isbn;
		this.price = price;
		this.clear = clear;
	}

	@Override
	public String toString() {
		return "History [id=" + id + ", isbn=" + isbn + ", price=" + price + ", clear=" + clear + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getClear() {
		return clear;
	}

	public void setClear(int clear) {
		this.clear = clear;
	}
	
	
}
