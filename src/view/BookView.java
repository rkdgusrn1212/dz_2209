package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;

public class BookView extends JFrame{
    JLabel la_book ;
    JButton bt_back ;
    JButton bt_next ;
    JButton bt_prev;
    JPanel panel_book ;
    public BookView() {
        getContentPane().setLayout(null);
        
        la_book = new JLabel("책 제목");
        bt_back = new JButton("메인페이지");
        panel_book = new JPanel();
        bt_prev = new JButton("이전");
         bt_next = new JButton("다음");
        
         panel_book.setBounds(133, 54, 1164, 615);
         bt_back.setBounds(14, 13, 105, 27);
         bt_prev.setBounds(14, 331, 105, 68);
        la_book.setBounds(417, 12, 640, 28);
        bt_next.setBounds(1301, 331, 105, 68);
        
        getContentPane().add(la_book);
        getContentPane().add(bt_back);
        getContentPane().add(panel_book);
        getContentPane().add(bt_prev);
        getContentPane().add(bt_next);
        
        setVisible(true);
    }
}