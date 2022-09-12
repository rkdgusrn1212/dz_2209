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

    
    public Book(int bookId, String isbn, int category, String bName, String writer, int originPrice, String summary, Image img) {
        this.bookId =  bookId;
        this.isbn = isbn;
        this.category = category;
        this.bName = bName;
        this.writer = writer;
        this.originPrice = originPrice;
        this.summary = summary;
        this.img = img;
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
