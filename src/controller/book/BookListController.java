package controller.book;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import controller.Controller;
import model.dao.BookDAO;
import model.vo.Book;
import view.View;
import view.book.BookListView;

public class BookListController extends Controller implements MouseListener{

    private BookListView viewBookList;
    private BookTableModel tableModel;

    //filter가 null이면 그냥 전체조회.
    protected BookListController(Controller controller, String id, String filter, String keyword) {
        super(controller, BookListView.class, id, filter, keyword);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        finish();
    }

    @Override
    protected void create(View windowView) {
        viewBookList = (BookListView) windowView;
        viewBookList.btnBack.addActionListener(this);
        viewBookList.table.setModel(tableModel = new BookTableModel());
        viewBookList.table.addMouseListener(this);
    }

    @Override
    protected void resume(){
        super.resume();
        String filter = getArgs(1);
        String keyword = getArgs(2);
        ArrayList<Book> list = null;
        if(filter == null) {
            list = new BookDAO().selectAll();
        }else {
            switch(filter) {
            case "도서명":
                list = new BookDAO().selectWithBName(keyword);
                break;
            case "저자명":
                list = new BookDAO().selectWithWriter(keyword);
                break;
            case "분류":
                list = new BookDAO().selectWithCategory(keyword);
                break;
            case "ISBN":
                list = new BookDAO().selectWithIsbn(keyword);
                break;

            }
        }
        tableModel.update(list);
        viewBookList.table.updateUI();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Book book = tableModel.getBook(viewBookList.table.getSelectedRow());
        if(book!=null) {
            new BookController(this, book.getBookId(), getArgs(0));   
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }
}
