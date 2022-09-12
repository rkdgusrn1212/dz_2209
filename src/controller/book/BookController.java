package controller.book;

import java.awt.event.ActionEvent;

import controller.Controller;
import view.View;
import view.book.BookView;

public class BookController extends Controller {

    private BookView viewBook;
    private int bookId;
    private String id;
    
    public BookController(Controller controller, int bookId , String id) {
        super(controller, BookView.class);
        this.bookId = bookId;
        this.id = id;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object s = e.getSource();
        if(s == viewBook.btnBack) {
            finish();
        }else if(s==viewBook.btnPay) {
        	new BookPayController(this);
        }
    }

    @Override
    protected void create(View windowView) {
        viewBook = (BookView) windowView;
        viewBook.btnBack.addActionListener(this);
        viewBook.btnPay.addActionListener(this);
    }

}
