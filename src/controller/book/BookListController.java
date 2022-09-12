package controller.book;

import java.awt.event.ActionEvent;

import controller.Controller;
import model.dao.BookDAO;
import view.View;
import view.book.BookListView;

public class BookListController extends Controller{

    private BookListView viewBookList;
    private BookTableModel tableModel;
    
    protected BookListController(Controller controller, String... args) {
        super(controller, BookListView.class, args);
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
    }
    
    @Override
    protected void resume(){
        super.resume();
        tableModel.update(new BookDAO().selectAllBook());
        viewBookList.table.updateUI();
    }
}
