package controller.admin;

import java.awt.event.ActionEvent;

import controller.Controller;
import view.View;
import view.admin.AdminView;

public class AdminController extends Controller {
    
    AdminView view;

    public AdminController(Controller controller) {
        super(controller, AdminView.class);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    protected void create(View windowView) {
        view = (AdminView) windowView;
    }

}
