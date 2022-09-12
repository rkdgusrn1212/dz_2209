package controller.book;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import controller.Controller;
import db.util.DBConnManager;
import model.dao.BookDAO;
import model.vo.Book;
import util.ImageHelper;
import view.View;
import view.book.AddBookView;

public class AddBookController extends Controller implements MouseListener {

    private AddBookView addbookView;
    public AddBookController(Controller controller, String id) {
        super(controller, AddBookView.class, id);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object s = e.getSource();
        if(s == addbookView.btnReset) {
            finish();
        } else if (s==addbookView.btnSubmit) {
    		String isbn=addbookView.tfIsbn.getText();
    		int category=addbookView.cbInterestCategory.getSelectedIndex();
    		String bName=addbookView.tfBook.getText();
    		String writer=addbookView.tfWriter.getText();
    		int originPrice=Integer.parseInt(addbookView.tfPrice.getText());
    		String summary=addbookView.taContent.getText();
    		new BookDAO().insertBook(new Book(isbn, category, bName, writer, originPrice, summary));
        }
    }

    @Override
    protected void create(View windowView) {
        addbookView = (AddBookView) windowView;
        addbookView.btnReset.addActionListener(this);
        addbookView.btnSubmit.addActionListener(this);
        addbookView.tfImage.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(new FileNameExtensionFilter("JPG & PNG", "jpg", "png"));
        int ret = chooser.showOpenDialog(addbookView);
        if(ret != JFileChooser.APPROVE_OPTION) {
            JOptionPane.showMessageDialog(null,"파일을 선택하지 않았습니다.", "경고", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String path = chooser.getSelectedFile().getPath();
        addbookView.tfImage.setText(path);
        
        addbookView.bookImgLabel.setIcon(
                ImageHelper.getResizedImageIcon(
                        new ImageIcon(path), addbookView.bookImgLabel.getWidth(), addbookView.bookImgLabel.getHeight()));
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
