package controller.member;

import java.awt.event.ActionEvent;

import controller.Controller;
import view.View;
import view.member.CashView;

public class CashController extends Controller {

    private CashView viewCash;
    public CashController(Controller controller, String... args) {
        super(controller, CashView.class, args);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object s = e.getSource();
        if(s == viewCash.btnBack) {
            finish();
        }else if(s==viewCash.btnSubmit) {
        	
        }
    }

    @Override
    protected void create(View windowView) {
        viewCash = (CashView) windowView;
        viewCash.btnBack.addActionListener(this);
        viewCash.btnSubmit.addActionListener(this);
    }

}
