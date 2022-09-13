package controller.book;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import controller.Controller;
import controller.ImageHelper;
import controller.member.LoginController;
import controller.member.MyPageController;
import model.dao.BookDAO;
import model.vo.Book;
import view.View;
import view.book.BookClickView;
import view.book.BookSelectView;

public class BookSelectController extends Controller {

    private BookSelectView viewBookSelect;
    private ClickPickListener cpListener;
    private SelectTglBtnListener stbListener;

    public BookSelectController(Controller controller, String id) {
        super(controller, BookSelectView.class, id);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object s = e.getSource();
        if (s == viewBookSelect.btnLogout) {
            finish();
            new LoginController(null);
        }else if (s == viewBookSelect.btnMyPage) {
            new MyPageController(this, getArgs(0));
        }else if(s==viewBookSelect.btnAllList) {  
            new BookListController(this, getArgs(0), null, null);
        }else if(s==viewBookSelect.btnAdd) {
            new AddBookController(this, getArgs(0), null);
        }else if(s==viewBookSelect.btnSearch) {
        	new BookListController(this, getArgs(0), viewBookSelect.cbSearchBook.getSelectedItem().toString(), viewBookSelect.tfSearch.getText());
        }
    }
    
    @Override
    protected void create(View windowView) { 
        viewBookSelect = (BookSelectView) windowView;
        viewBookSelect.labelId.setText(getArgs(0) + "님");
        viewBookSelect.btnLogout.addActionListener(this);
        viewBookSelect.btnMyPage.addActionListener(this);
        viewBookSelect.btnAllList.addActionListener(this);
        viewBookSelect.btnAdd.addActionListener(this);
        viewBookSelect.btnSearch.addActionListener(this);
        stbListener = new SelectTglBtnListener();
        cpListener = new ClickPickListener();
        for(int i=0 ;i<3; i++) {
            BookClickView view = viewBookSelect.viewBookClick[i];
            view.btnPick.addActionListener(cpListener);
            view.tglBtnImage.addItemListener(stbListener);
        }
    }
    
    @Override
    protected void resume() {
        super.resume();
        ArrayList<Book> list = new BookDAO().selectBookWithMemberIdWithRowNum(getArgs(0), 3);
        int i=0;
        for(;i<list.size(); i++) {
            Book book = list.get(i);
            BookClickView view = viewBookSelect.viewBookClick[i];
            stbListener.update(view.spContent);
            cpListener.update(this,book.getBookId(), getArgs(0));
           
            if(book.getImg()!=null) {
                view.tglBtnImage.setIcon(ImageHelper.getFitImageIcon(view.tglBtnImage, book.getImg()));
            }else {
                view.tglBtnImage.setIcon(ImageHelper.getDefaultImageIcon(
                        view.tglBtnImage.getBounds().width, view.tglBtnImage.getBounds().height));
            }
            
            view.labelName.setText(book.getBname());
            view.labelWriter.setText(book.getWriter());
            view.labelPrice.setText(book.getPrice()+"₩");
            view.taContent.setText(book.getSummary());
        }
        //데이터가 없으면 남은 칸은 지운다.
        for(;i<3; i++) {
            viewBookSelect.viewBookClick[i].setVisible(false);
        }
        
    }
    
    private static class SelectTglBtnListener implements ItemListener{

        private JScrollPane spContent;
        
        void update(JScrollPane spContent){
            this.spContent = spContent;
        }
        @Override
        public void itemStateChanged(ItemEvent e) {  
            if(e.getStateChange()==e.SELECTED) {
                spContent.setVisible(true);
            }else {
                spContent.setVisible(false);
            }
        }
        
    }
    
    private static class ClickPickListener implements ActionListener{
        
        private int bookId;
        private String id;
        private Controller controller;
        void update(Controller controller, int bookId, String id){
            this.bookId = bookId;
            this.id = id;
            this.controller = controller;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            new BookController(controller, bookId, id);
        }
        
    }
}
