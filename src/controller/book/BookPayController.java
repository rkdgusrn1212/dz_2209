package controller.book;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controller.Controller;
import controller.member.CashController;
import model.dao.BookDAO;
import model.dao.MemberDAO;
import model.vo.Book;
import model.vo.Member;
import view.View;
import view.book.BookPayView;

public class BookPayController extends Controller {

    private BookPayView viewBookPay;
    public BookPayController(Controller controller, String id, String bookId) {
        super(controller, BookPayView.class, id, bookId);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object s = e.getSource();
        if(s == viewBookPay.btnBack) {
            finish();
        }else if(s==viewBookPay.btnPay) {
            if(new MemberDAO().pay(getArgs(0), Integer.parseInt(getArgs(1)))) {
                JOptionPane.showMessageDialog(viewBookPay,"구매 완료");
                finish();
            }else {
                JOptionPane.showMessageDialog(viewBookPay,"구매 실패");
            }
        }else if(s==viewBookPay.btnCash) {
            new CashController(this, getArgs(0));
        }
    }

    @Override
    protected void create(View windowView) {
        viewBookPay = (BookPayView) windowView;
        viewBookPay.btnBack.addActionListener(this);
        viewBookPay.btnPay.addActionListener(this);
        viewBookPay.btnCash.addActionListener(this);
    }


    @Override
    protected void resume() {
        super.resume();
        Member member = new model.dao.MemberDAO().selectWithId(getArgs(0));
        if(member==null) {
            JOptionPane.showMessageDialog(viewBookPay,"계정정보 쿼리 실패!");
            finish();
        }
        Book book = new BookDAO().selectBookWithId(Integer.parseInt(getArgs(1)));
        if(member==null) {
            JOptionPane.showMessageDialog(viewBookPay,"도서정보 쿼리 실패!");
            finish();
        }
        viewBookPay.labelId.setText("회원 ID : "+member.getId());
        viewBookPay.labelCash.setText("회원 보유 캐쉬 : "+member.getCash()+"₩");
        viewBookPay.labelLend.setText("회원 ID : "+member.getName());
        viewBookPay.labelUseCash.setText("결제 후 보유 캐쉬 : "+(member.getCash()-book.getPrice())+"₩");
        viewBookPay.labelLend.setText("대여 가격 : "+book.getPrice());
    }
}
