package model.vo;
import java.awt.Image;
import java.io.File;

public class Book {
    
    private int bookId;
    private String isbn;
    private int category;
    private String bName;
    private String writer;
    private int originPrice;
    private String summary;
    private Image img;
    private String registerId;
    private String lendId;

    public Book(int bookId, String bName, String writer, int category, String lendId) {
        this.bookId = bookId;
        this.bName = bName;
        this.writer = writer;
        this.category = category;
        this.lendId = lendId;
    }
    
    public Book(int bookId, String isbn, int category, String bName, String writer, int originPrice, String summary, Image img, String registerId, String lendId) {
        this.bookId =  bookId;
        this.isbn = isbn;
        this.category = category;
        this.bName = bName;
        this.writer = writer;
        this.originPrice = originPrice;
        this.summary = summary;
        this.img = img;
        this.registerId = registerId;
        this.lendId = lendId;
    }
    
    public String getLendId() {
        return lendId;
    }
    
    public String getRegisterId() {
        return registerId;
    }
    
    public Image getImg() {
        return img;
    }

    public int getBookId() {
        return bookId;
    }

    public String getSummary() {
        return summary;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getCategory() {
        return category;
    }

    public String getBname() {
        return bName;
    }

    public String getWriter() {
        return writer;
    }


    public int getOriginPrice() {
        return originPrice;
    }
}
