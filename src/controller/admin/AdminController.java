package controller.admin;

import java.awt.event.ActionEvent;

import controller.Controller;
import view.View;
import view.admin.AdminView;

public class AdminController extends Controller {
    
    AdminView view;

    protected AdminController(Controller controller, Class viewClass, String[] args) {
        super(controller, viewClass, args);
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
