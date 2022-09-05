package view;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;

public class BookClickView extends JPanel {
    public JToggleButton tbt_image;
    public JLabel la_name, la_writer, la_price;
    public JTextArea ta_content;
    public BookClickView() {
        setLayout(null);
//new
        tbt_image = new JToggleButton(new ImageIcon("image/sample.jpg"));
        la_name = new JLabel("도서명");
        la_writer = new JLabel("저자명");
        ta_content = new JTextArea("간단줄거리");
        la_price = new JLabel("가격");
//setBounds
        tbt_image.setBounds(25, 25, 200, 200);
        la_name.setBounds(100, 270, 80, 30);
        la_writer.setBounds(100, 340, 80, 30);
        la_price.setBounds(100, 410, 80, 30);
//      ta_content.setBounds(25, 350, 200, 150);
        ta_content.setBounds(25, 250, 200, 300);
//add
        add(tbt_image);
        add(ta_content);
        add(la_name);
        add(la_writer);
        add(la_price);
        
        ta_content.setFocusable(true);
        ta_content.setVisible(false);
        
        setSize(250,500);
    }
}

