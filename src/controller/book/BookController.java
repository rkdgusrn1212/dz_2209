package controller.book;

import java.awt.Image;
import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

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
        }else if(s == viewBook.btnUpdate) {
            new AddBookController(this, getArgs(0));
        }else if(s==viewBook.btnDelete) {
            if(new BookDAO().deleteBook(Integer.parseInt(getArgs(0)))) {
                JOptionPane.showMessageDialog(viewBook,"등록된 도서가 삭제되었습니다.");
                finish();
            }else {
                JOptionPane.showMessageDialog(viewBook,"도서 삭제 실패!");
            }
        }
    }

    @Override
    protected void create(View windowView) {
        viewBook = (BookView) windowView;
        viewBook.btnBack.addActionListener(this);
        viewBook.btnPay.addActionListener(this);
        viewBook.btnUpdate.addActionListener(this);
        viewBook.btnDelete.addActionListener(this);
    }
    
    @Override
    protected void resume() {
        super.resume();
        Book book = new BookDAO().selectBookWithId(Integer.parseInt(getArgs(0)));
        if(book==null) {
            JOptionPane.showMessageDialog(viewBook,"도서 정보 쿼리 실패!");
            finish();
        }
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
        //등록자가 본인일때
        if(book.getRegisterId().equals(getArgs(1))) {
            viewBook.btnUpdate.setVisible(true);
            viewBook.btnDelete.setVisible(true);
        }else {//아닐때
            viewBook.btnUpdate.setVisible(false);
            viewBook.btnDelete.setVisible(false);
        }
    }

}
