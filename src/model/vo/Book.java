package model.vo;
import java.awt.image.BufferedImage;

public class Book {
    
    private int bookId;
    private String isbn;
    private int category;
    private String bName;
    private String writer;
    private int price;
    private String summary;
    private BufferedImage img;
    private String registerId;
    private String lendId;

    public Book(int bookId, String bName, String writer, int category, String lendId) {
        this.bookId = bookId;
        this.bName = bName;
        this.writer = writer;
        this.category = category;
        this.lendId = lendId;
    }
    
    public Book(int bookId, String bName, String writer, int category, int price) {
        this.bookId = bookId;
        this.bName = bName;
        this.writer = writer;
        this.category = category;
        this.price = price;
    }
    
    
    public Book(int bookId, String isbn, int category, String bName, String writer, int price, String summary, BufferedImage img, String registerId, String lendId) {
        this.bookId =  bookId;
        this.isbn = isbn;
        this.category = category;
        this.bName = bName;
        this.writer = writer;
        this.price = price;
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
    
    public BufferedImage getImg() {
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


    public int getPrice() {
        return price;
    }
}
