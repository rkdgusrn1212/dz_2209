package controller.book;

import java.awt.event.ActionEvent;

import controller.Controller;
import controller.member.CashController;
import view.View;
import view.book.BookPayView;

public class BookPayController extends Controller {

    private BookPayView viewBookPay;
    public BookPayController(Controller controller, String... args) {
        super(controller, BookPayView.class, args);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object s = e.getSource();
        if(s == viewBookPay.btnBack) {
            finish();
        }else if(s==viewBookPay.btnPay) {
        	
        }else if(s==viewBookPay.btnCash) {
        	new CashController(this);
        }
    }

    @Override
    protected void create(View windowView) {
        viewBookPay = (BookPayView) windowView;
        viewBookPay.btnBack.addActionListener(this);
        viewBookPay.btnPay.addActionListener(this);
        viewBookPay.btnCash.addActionListener(this);
    }

}