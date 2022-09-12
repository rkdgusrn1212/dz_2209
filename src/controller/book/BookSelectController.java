package controller.book;

import java.awt.event.ActionEvent;
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
import controller.quiz.QuizController;
import model.dao.BookDAO;
import model.vo.Book;
import view.View;
import view.book.BookClickView;
import view.book.BookSelectView;

public class BookSelectController extends Controller {

    private BookSelectView viewBookSelect;

    public BookSelectController(Controller controller, String id) {
        super(controller, BookSelectView.class,  id);
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
            new BookListController(this);
        }else if(s==viewBookSelect.btnAdd) {
            new AddBookController(this, getArgs(0));
        }else if(s==viewBookSelect.btnPick1) {
            new BookController(this);
        }else if(s==viewBookSelect.btnPick2) {
            new BookController(this);
        }else if(s==viewBookSelect.btnPick3) {
            new BookController(this);
        }else if(s==viewBookSelect.btnSearch) {
        	new BookListController(this);
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
        viewBookSelect.btnPick1.addActionListener(this);
        viewBookSelect.btnPick2.addActionListener(this);
        viewBookSelect.btnPick3.addActionListener(this);
        viewBookSelect.btnSearch.addActionListener(this);
        for (int i = 0; i < viewBookSelect.viewBookClick.length; i++) {
            viewBookSelect.viewBookClick[i].tglBtnImage.addItemListener(new BSCItemListener(
                    viewBookSelect.viewBookClick[i].spContent));
        }
    }
    
    @Override
    protected void resume() {
        super.resume();
        ArrayList<Book> list = new BookDAO().selectBookWithMemberIdWithRowNum(getArgs(0), 3);
        for(int i=0 ;i<list.size(); i++) {
            Book book = list.get(i);
            BookClickView view = viewBookSelect.viewBookClick[i];
            if(book.getImg()!=null) {
                view.tglBtnImage.setIcon(ImageHelper.getFitImageIcon(view.tglBtnImage, book.getImg()));
            }else {
                view.tglBtnImage.setIcon(ImageHelper.getDefaultImageIcon(
                        view.tglBtnImage.getBounds().width, view.tglBtnImage.getBounds().height));
            }
            
            view.labelName.setText(book.getBname());
            view.labelWriter.setText(book.getWriter());
            view.labelPrice.setText(book.getOriginPrice()+"₩");
            view.taContent.setText(book.getSummary());
        }
    }
    
    private class BSCItemListener implements ItemListener{
        JScrollPane taContent;
        
        BSCItemListener(JScrollPane taContent){
            this.taContent = taContent;
        }

        @Override
        public void itemStateChanged(ItemEvent e) {  
            if(e.getStateChange()==e.SELECTED) {
                taContent.setVisible(true);
            }else {
                taContent.setVisible(false);
            }
        }
        
    }
}
