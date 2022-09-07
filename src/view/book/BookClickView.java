package view.book;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;

public class BookClickView extends JPanel {
    public JToggleButton tglBtnImage;
    public JLabel labelName, labelWriter, labelPrice;
    public JTextArea taContent;
    public BookClickView() {
        setLayout(null);
        //new
        tglBtnImage = new JToggleButton(new ImageIcon("image/sample.jpg"));
        labelName = new JLabel("도서명");
        labelWriter = new JLabel("저자명");
        taContent = new JTextArea("간단줄거리");
        labelPrice = new JLabel("가격");
        //setBounds
        tglBtnImage.setBounds(25, 25, 200, 200);
        labelName.setBounds(100, 270, 80, 30);
        labelWriter.setBounds(100, 340, 80, 30);
        labelPrice.setBounds(100, 410, 80, 30);
        //      ta_content.setBounds(25, 350, 200, 150);
        taContent.setBounds(25, 250, 200, 300);
        //add
        add(tglBtnImage);
        add(taContent);
        add(labelName);
        add(labelWriter);
        add(labelPrice);

        taContent.setFocusable(true);
        taContent.setVisible(false);

        setSize(250,500);
    }
}

