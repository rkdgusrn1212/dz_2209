package controller.quiz;

import java.awt.event.ActionEvent;

import controller.Controller;
import view.View;
import view.quiz.QuizView;

public class QuizController extends Controller{

    QuizView quizView;
    
    public QuizController(Controller controller, String id) {
        super(controller, QuizView.class, id);
    }

    @Override
    public void actionPerformed(ActionEvent e) { 
        Object s = e.getSource();
        if(s == quizView.btnCancel) {
            finish();
        }else if(s==quizView.btnConfirm) {
           
        }
    }

    @Override
    protected void create(View windowView) {
        quizView = (QuizView)windowView;
        quizView.btnCancel.addActionListener(this);
        quizView.btnConfirm.addActionListener(this);
    }
}
