package view.book;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;

public class BookView extends JFrame{
    JLabel labelBook ;
    JButton btbBack ;
    JButton btnNext ;
    JButton btnPrev;
    JPanel panelBook ;
    public BookView() {
        getContentPane().setLayout(null);

        labelBook = new JLabel("책 제목");
        btbBack = new JButton("메인페이지");
        panelBook = new JPanel();
        btnPrev = new JButton("이전");
        btnNext = new JButton("다음");

        panelBook.setBounds(133, 54, 1164, 615);
        btbBack.setBounds(14, 13, 105, 27);
        btnPrev.setBounds(14, 331, 105, 68);
        labelBook.setBounds(417, 12, 640, 28);
        btnNext.setBounds(1301, 331, 105, 68);

        getContentPane().add(labelBook);
        getContentPane().add(btbBack);
        getContentPane().add(panelBook);
        getContentPane().add(btnPrev);
        getContentPane().add(btnNext);

        setSize(300,500);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new BookView().setVisible(true);
    }
}