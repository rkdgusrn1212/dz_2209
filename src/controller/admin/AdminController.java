package controller.admin;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import controller.Controller;
import controller.book.BookController;
import controller.book.BookTableModel;
import controller.member.LoginController;
import model.dao.BookDAO;
import model.dao.MemberDAO;
import model.vo.Book;
import model.vo.Member;
import view.View;
import view.admin.AdminView;

public class AdminController extends Controller implements MouseListener{

    AdminView view;
    private AdminMemberTableModel memberTableModel;
    private AdminBookTableModel bookTableModel;

    public AdminController(Controller controller) {
        super(controller, AdminView.class);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object s = e.getSource();
        if(s==view.btnBack) {
            new LoginController(null);
            finish();
        }else if(s==view.btnSelectAllMember){
            memberTableModel.update(new MemberDAO().selectAll());
            view.table.updateUI();
        }else if(s==view.btnSelectAllBook){
            bookTableModel.update(new BookDAO().selectAllWithPrice());
            view.table2.updateUI();
        }
    }

    @Override
    protected void create(View windowView) {
        view = (AdminView) windowView;
        view.btnSelectAllMember.addActionListener(this);
        view.btnBack.addActionListener(this);
        view.table.setModel(memberTableModel = new AdminMemberTableModel());
        view.table.addMouseListener(this);
        view.btnSelectAllBook.addActionListener(this);
        view.table2.setModel(bookTableModel = new AdminBookTableModel());
        view.table2.addMouseListener(this);
    }

    @Override
    protected void resume(){
        super.resume();
        memberTableModel.update(new MemberDAO().selectAll());
        view.table.updateUI();

        bookTableModel.update(new BookDAO().selectAllWithPrice());
        view.table2.updateUI();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Object s = e.getSource();
        if(s==view.table) {
            Member member = memberTableModel.getModel(view.table.getSelectedRow());
            if(member!=null) {
                int result = JOptionPane.showConfirmDialog(view, member.getId()+" 회원을 삭제 하시겠습니까?", "회원 삭제", JOptionPane.YES_NO_OPTION);
                if(result == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(view, member.getId()+" 회원이 삭제 되었습니다.");
                    memberTableModel.update(new MemberDAO().selectAll());
                    view.table.updateUI();
                }
            }
        }else if(s==view.table2) {
            Book book = bookTableModel.getBook(view.table2.getSelectedRow());
            if(book!=null) {
                int result = JOptionPane.showConfirmDialog(view, book.getBname()+" 도서를 삭제 하시겠습니까?", "도서 삭제", JOptionPane.YES_NO_OPTION);
                if(result == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(view, book.getBname()+" 도서가 삭제 되었습니다.");
                    bookTableModel.update(new BookDAO().selectAllWithPrice());
                    view.table2.updateUI();
                }
            }
        }
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
