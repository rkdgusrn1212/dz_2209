package controller.book;

import java.awt.Image;
import java.awt.event.ActionEvent;

import controller.Controller;
import controller.ImageHelper;
import model.dao.BookDAO;
import model.vo.Book;
import view.View;
import view.book.BookView;

public class BookController extends Controller {

    private BookView viewBook;
    
    public BookController(Controller controller, int bookId , String id) {
        super(controller, BookView.class, ""+bookId, id);
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
    
    @Override
    protected void resume() {
        super.resume();
        Book book = new BookDAO().selectBookWithId(Integer.parseInt(getArgs(0)));
        viewBook.tfName.setText(book.getBname());
        viewBook.tfWriter.setText(book.getWriter());
        viewBook.tfPrice.setText(book.getPrice()+"₩");
        viewBook.taSummary.setText(book.getSummary());
        Image image = book.getImg();
        if(image!=null) {
            viewBook.labelImage.setIcon(ImageHelper.getFitImageIcon(viewBook.labelImage, image));
        }else {
            viewBook.labelImage.setIcon(ImageHelper.getDefaultImageIcon(
                    viewBook.labelImage.getBounds().width, 
                    viewBook.labelImage.getBounds().height));
        }
    }

}
