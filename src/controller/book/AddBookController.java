package controller.book;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import controller.Controller;
import controller.ImageHelper;
import db.util.DBConnManager;
import model.dao.BookDAO;
import model.vo.Book;
import view.View;
import view.book.AddBookView;

public class AddBookController extends Controller implements MouseListener {

    private AddBookView addbookView;
    private BufferedImage bookImage = null;//불러온 이미지 파일
    private boolean isUpdateMode = false;

    public AddBookController(Controller controller, String id, String bookId) {
        super(controller, AddBookView.class, id, bookId);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object s = e.getSource();
        if(s == addbookView.btnReset) {
            finish();
        } else if (s==addbookView.btnSubmit) {
            BookInputChecker bic = new BookInputChecker();

            //isbn검사
            String isbn=addbookView.tfIsbn.getText();
            if(!bic.isValidISBN(addbookView.tfIsbn, isbn)) return;

            int category=addbookView.cbInterestCategory.getSelectedIndex();

            //bname 검사
            String bName=addbookView.tfBook.getText();
            if(!bic.isValidBName(addbookView.tfBook, bName)) return;

            //writer 검사
            String writer=addbookView.tfWriter.getText();
            if(!bic.isValidWriter(addbookView.tfWriter, writer)) return;

            //가격 검사
            String price = addbookView.tfPrice.getText();
            if(!bic.isValidPrice(addbookView.tfPrice, price))return;

            //줄거리 검사
            String summary=addbookView.taContent.getText();
            if(!bic.isValidSummary(addbookView.taContent, price))return;

            //등록자가 본인이면 수정 호출
            if(isUpdateMode) {
                if(new BookDAO().updateWithBookId(Integer.parseInt(getArgs(1)), isbn, category, bName, writer, Integer.parseInt(price), summary, bookImage)) {
                    JOptionPane.showMessageDialog(addbookView, "도서가 갱신 되었습니다!");
                    finish();
                }else {
                    JOptionPane.showMessageDialog(addbookView, "도서 갱신에 실패하였습니다.");
                }
            }else {
                if(new BookDAO().insertBook(isbn, category, bName, writer, Integer.parseInt(price), summary, bookImage, getArgs(0), null)) {
                    JOptionPane.showMessageDialog(addbookView, "도서가 등록 되었습니다!");
                    finish();
                }else {
                    JOptionPane.showMessageDialog(addbookView, "도서 등록에 실패하였습니다.");
                }
            }
        }
    }

    @Override
    protected void create(View windowView) {
        addbookView = (AddBookView) windowView;
        addbookView.btnReset.addActionListener(this);
        addbookView.btnSubmit.addActionListener(this);
        addbookView.tfImage.addMouseListener(this);
        addbookView.bookImgLabel.setIcon(ImageHelper.getDefaultImageIcon(
                addbookView.bookImgLabel.getBounds().width, addbookView.bookImgLabel.getBounds().height));
    }


    @Override
    protected void resume() {
        super.resume();
        String bookId = getArgs(1);
        isUpdateMode = bookId!=null;
        if(isUpdateMode) {//제공된 bookId가 있으면 도서 수정 유스케이스다
            Book book = new BookDAO().selectBookWithId(Integer.parseInt(bookId));
            if(book==null) {
                JOptionPane.showMessageDialog(addbookView,"도서 정보 쿼리 실패!");
                finish();
            }
            addbookView.tfIsbn.setText(book.getIsbn());
            addbookView.tfBook.setText(book.getBname());
            addbookView.tfWriter.setText(book.getWriter());
            addbookView.tfPrice.setText(""+book.getPrice());
            addbookView.taContent.setText(book.getSummary());
            Image image = book.getImg();
            if(image!=null) {
                addbookView.bookImgLabel.setIcon(ImageHelper.getFitImageIcon(addbookView.bookImgLabel, image));
            }else {
                addbookView.bookImgLabel.setIcon(ImageHelper.getDefaultImageIcon(
                        addbookView.bookImgLabel.getBounds().width, 
                        addbookView.bookImgLabel.getBounds().height));
            }
        }
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
        File file = new File(path);
        Image image = null;
        try {
            image = ImageIO.read(file);
        } catch (IOException e1) {
            e1.printStackTrace();
            JOptionPane.showMessageDialog(null,"이미지를 불러올 수 없습니다.", "경고", JOptionPane.WARNING_MESSAGE);
            return;
        }
        image = image.getScaledInstance(210, 297, Image.SCALE_SMOOTH);
        //210 x 297로 resize된 이미지를 맴버로 저장.
        bookImage = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_ARGB);//입력받은 이미지는 무조건 210x297;
        Graphics2D bGr = bookImage.createGraphics();
        bGr.drawImage(image, 0, 0, null);
        bGr.dispose();
        addbookView.tfImage.setText(path);
        addbookView.bookImgLabel.setIcon(ImageHelper.getFitImageIcon(addbookView.bookImgLabel, bookImage));
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
