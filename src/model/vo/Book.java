package model.vo;

public class Book {
	
	int isbn;
	int category;
	String bname;
	String writer;
	int prent;
	int originPrice;
	String summary;
//	String imange;
	
	
	public Book(int i, String j, String writer, int k) {
	    this.isbn = i;
		this.bname = j;
		this.writer = writer;
		this.prent = k;
	}

    public Book(int isbn, int category, String bname, String writer, int prent, int originPrice,
			String summary ) {
		super();
		this.isbn = isbn;
		this.category = category;
		this.bname = bname;
		this.writer = writer;
		this.prent = prent;
		this.originPrice = originPrice;
		this.summary = summary;
//		this.imange = imange;
	}
    
//	public String getImange() {
//		return imange;
//	}
//
//
//	public void setImange(String imange) {
//		this.imange = imange;
//	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public int getPrent() {
		return prent;
	}

	public void setPrent(int prent) {
		this.prent = prent;
	}


	public int getOriginPrice() {
		return originPrice;
	}

	public void setOriginPrice(int originPrice) {
		this.originPrice = originPrice;
	}

	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", category=" + category + ", bname=" + bname + ", writer=" + writer + ", prent="
				+ prent + ", originPrice=" + originPrice + ", summary=" + summary
				//+ ", imange=" + imange 
				+ "]";
	}

}
