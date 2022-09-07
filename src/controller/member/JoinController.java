package controller.member;


import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import controller.Controller;
import model.dao.MemberDAO;
import model.vo.Member;
import view.View;
import view.member.JoinView;
public class JoinController extends Controller{
    
    JoinView viewJoin;

    JoinController(Controller controller){
        super(controller, JoinView.class);
    }

    @Override
    protected void create(View windowView) {
        viewJoin = (JoinView) windowView;
        viewJoin.tfId.setText("");
        viewJoin.tfName.setText("");
        viewJoin.tfPwd.setText("");
        viewJoin.tfPwd2.setText("");
        viewJoin.tfEmail.setText("");
        viewJoin.btnSubmit.addActionListener(this);
        viewJoin.btnReset.addActionListener(this);
    }

    @Override
    protected void resume() {
        super.resume();
        viewJoin.tfId.requestFocus();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object s = e.getSource();
        if(s==viewJoin.btnReset) {
            finish();
        }else if(s == viewJoin.btnSubmit) {
            Member m = new Member();
            m.setId(viewJoin.tfId.getText());
            m.setPass(new String(viewJoin.tfPwd.getPassword()));
            m.setEname(viewJoin.tfName.getText());
            m.setEmail(viewJoin.tfEmail.getText());
            m.setGenre(viewJoin.cbGenre.getSelectedItem().toString());
            if (new MemberDAO().insertJoin(m)) {
                viewJoin.showMsg("환영합니다^^");
                finish();
            } else {
                viewJoin.showMsg("가입할 수 없습니다!");
            }
        }
    }

}
