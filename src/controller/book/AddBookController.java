package controller.book;

import java.awt.event.ActionEvent;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import controller.Controller;
import db.util.DBConnManager;
import model.dao.BookDAO;
import model.vo.Book;
import view.View;
import view.book.AddBookView;

public class AddBookController extends Controller {

    private AddBookView addviewBook;
    public AddBookController(Controller controller, String... args) {
        super(controller, AddBookView.class, args);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object s = e.getSource();
        if(s == addviewBook.btnReset) {
            finish();
        } else if (s==addviewBook.btnSubmit) {
    		String isbn=addviewBook.tfIsbn.getText();
    		int category=Integer.parseInt(addviewBook.tfCategory.getText());
    		String bName=addviewBook.tfBook.getText();
    		String writer=addviewBook.tfWriter.getText();
    		int originPrice=Integer.parseInt(addviewBook.tfPrice.getText());
    		String summary=addviewBook.taContent.getText();
    		new BookDAO().insertBook(new Book(isbn, category, bName, writer, originPrice, summary));
        }
    }

    @Override
    protected void create(View windowView) {
        addviewBook = (AddBookView) windowView;
        addviewBook.btnReset.addActionListener(this);
        addviewBook.btnSubmit.addActionListener(this);
    }

}
