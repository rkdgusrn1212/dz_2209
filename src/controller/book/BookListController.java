package controller.book;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import controller.Controller;
import model.dao.BookDAO;
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
        tableModel.update(new BookDAO().selectAllBook());
        viewBookList.table.updateUI();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        new BookController(this, tableModel.getBook(viewBookList.table.getSelectedRow()).getBookId(), getArgs(0));
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
