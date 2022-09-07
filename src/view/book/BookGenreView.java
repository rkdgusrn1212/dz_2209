package view.book;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class BookGenreView extends JFrame {
    public JLabel la_msg;
    public JRadioButton rBtnFiction, rBtnAssay, rb_3;
    public ButtonGroup bg;
    public JButton btnSelect;
    public BookGenreView() {
        setTitle("BookGenreView");
        setLayout(null);
        //new
        la_msg = new JLabel("장르를 선택하세요");
        rBtnFiction = new JRadioButton("소설");
        rBtnAssay = new JRadioButton("수필");
        rb_3 = new JRadioButton("스릴러");
        bg = new ButtonGroup();
        btnSelect = new JButton("장르 선택");
        bg.add(rBtnFiction);
        bg.add(rBtnAssay);
        bg.add(rb_3);
        //setBounds
        la_msg.setBounds(80, 30, 120, 30);
        rBtnFiction.setBounds(20, 100 , 80, 30);
        rBtnAssay.setBounds(120, 100 , 80, 30);
        rb_3.setBounds(200, 100 , 80, 30);
        btnSelect.setBounds(90, 200, 100, 30);
        // frame
        add(la_msg);
        add(rBtnFiction);
        add(rBtnAssay);
        add(rb_3);
        add(btnSelect);

        rBtnFiction.setSelected(true);
        setSize(300, 300);
        setVisible(false);
    }
}
