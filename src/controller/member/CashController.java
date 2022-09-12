package controller.member;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import controller.Controller;
import model.dao.MemberDAO;
import view.View;
import view.member.CashView;

public class CashController extends Controller {

    private CashView viewCash;
    public CashController(Controller controller, String id) {
        super(controller, CashView.class, id);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object s = e.getSource();
        if(s == viewCash.btnBack) {
            finish();
        }else if(s==viewCash.btnSubmit) {
            int cash;
            try {
                cash =  Integer.parseInt(viewCash.tfCash.getText());
            }catch(NumberFormatException ex) {
                JOptionPane.showMessageDialog(viewCash, "충전 금액은 자연수로만 입력해주세요.");
                viewCash.btnSubmit.requestFocus();
                return;
            }
            if(cash<=0) {
                JOptionPane.showMessageDialog(viewCash, "충전 금액은 0보다 커야합니다.");
                viewCash.btnSubmit.requestFocus();
                return;
            }
            if(cash>1000000) {
                JOptionPane.showMessageDialog(viewCash, "충전 금액은 1000000을 넘을 수 없습니다.");
                viewCash.btnSubmit.requestFocus();
                return;
            }
            if(new MemberDAO().updateCashCharge(getArgs(0), cash)) {
                JOptionPane.showMessageDialog(viewCash, cash+"₩ 을 충전하였습니다.");
                finish();
            }else {
                JOptionPane.showMessageDialog(viewCash, "충전 실패");
            }
        }
    }

    @Override
    protected void create(View windowView) {
        viewCash = (CashView) windowView;
        viewCash.btnBack.addActionListener(this);
        viewCash.btnSubmit.addActionListener(this);
    }

}
