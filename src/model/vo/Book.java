package model.vo;

public class Book {
    
    int bookId;
    String isbn;
    int category;
    String bName;
    String writer;
    int pRent;
    int originPrice;
    String summary;
    //	String imange;

    public Book(String bName, String writer, int i, int k) {
        this.bName = bName;
        this.writer = writer;
        this.category = i;
        this.pRent = k;
    }

    public Book(String bName, int originPrice, String writer,String summary ) {
        super();
        this.bName = bName;
        this.originPrice = originPrice;
        this.writer = writer;
        this.summary = summary;
        //		this.imange = imange;
    }

    public Book(String isbn, int category, String bName, String writer, int originPrice, String summary) {
        this.isbn = isbn;
        this.category = category;
        this.bName = bName;
        this.writer = writer;
        this.pRent = 0;
        this.originPrice = originPrice;
        this.summary = summary;
    }
    
    //	public String getImange() {
    //		return imange;
    //	}
    //
    //
    //	public void setImange(String imange) {
    //		this.imange = imange;
    //	}

    public int getBookId() {
        return bookId;
    }
    
    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public String getBname() {
        return bName;
    }

    public void setBname(String bname) {
        this.bName = bname;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public int getPrent() {
        return pRent;
    }

    public void setPRent(int pRent) {
        this.pRent = pRent;
    }


    public int getOriginPrice() {
        return originPrice;
    }

    public void setOriginPrice(int originPrice) {
        this.originPrice = originPrice;
    }

    @Override
    public String toString() {
        return "Book [book_id="+bookId + ", isbn=" + isbn + ", category=" + category + ", b_name=" + bName + ", writer=" + writer + ", p_rent="
                + pRent + ", origin_price=" + originPrice + ", summary=" + summary+ "]";
    }

}
