package controller.member;

import java.awt.event.ActionEvent;
import java.util.Properties;

import controller.Controller;
import view.View;
import view.member.FindIdPwdView;

public class FindIdPwdController extends Controller{
    FindIdPwdView viewFindIdPwd;
    public FindIdPwdController(Controller controller) {
        super(controller, FindIdPwdView.class);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    @Override
    protected void create(View windowView) {
        viewFindIdPwd = (FindIdPwdView) windowView;
    }
}
