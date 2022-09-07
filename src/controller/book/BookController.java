package controller.book;

import java.awt.event.ActionEvent;

import controller.Controller;
import view.View;
import view.book.BookView;

public class BookController extends Controller {

    private BookView viewBook;
    public BookController(Controller controller, String... args) {
        super(controller, BookView.class, args);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object s = e.getSource();
        if(s == viewBook.btnBack) {
            finish();
        }
    }

    @Override
    protected void create(View windowView) {
        viewBook = (BookView) windowView;
        viewBook.btnBack.addActionListener(this);
    }

}
