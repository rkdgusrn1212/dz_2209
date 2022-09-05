package model.vo;

public class Book {
	
	int isbn;
	String genre;
	String bname;
	String writer;
	int prent;
	int clearNum;
	int originPrice;
	String summary;
	String imange;
	
	
	public Book(String bname, String writer, int originPrice, String summary) {
		this.bname = bname;
		this.writer = writer;
		this.originPrice = originPrice;
		this.summary = summary;
	}

    public Book(int isbn, String genre, String bname, String writer, int prent, int clearNum, int originPrice,
			String summary, String imange) {
		super();
		this.isbn = isbn;
		this.genre = genre;
		this.bname = bname;
		this.writer = writer;
		this.prent = prent;
		this.clearNum = clearNum;
		this.originPrice = originPrice;
		this.summary = summary;
		this.imange = imange;
	}
    
	public String getImange() {
		return imange;
	}


	public void setImange(String imange) {
		this.imange = imange;
	}

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

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
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

	public int getClearNum() {
		return clearNum;
	}

	public void setClearNum(int clearNum) {
		this.clearNum = clearNum;
	}

	public int getOriginPrice() {
		return originPrice;
	}

	public void setOriginPrice(int originPrice) {
		this.originPrice = originPrice;
	}

	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", genre=" + genre + ", bname=" + bname + ", writer=" + writer + ", prent="
				+ prent + ", clearNum=" + clearNum + ", originPrice=" + originPrice + ", summary=" + summary
				+ ", imange=" + imange + "]";
	}

}
