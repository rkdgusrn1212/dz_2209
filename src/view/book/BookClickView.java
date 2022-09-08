package view.book;
import java.awt.Font;

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
        tglBtnImage = new JToggleButton(new ImageIcon("asset/dooboo.jpg"));
        labelName = new JLabel("도서명");
        labelWriter = new JLabel("저자명");
        taContent = new JTextArea("간단줄거리");
        labelPrice = new JLabel("가격");
        
        //setBounds
        tglBtnImage.setBounds(25, 100, 200, 200);
        labelName.setBounds(25, 320, 80, 30);
        labelWriter.setBounds(25, 370, 80, 30);
        labelPrice.setBounds(25, 420, 80, 30);
//        taContent.setBounds(25, 350, 200, 150);
        taContent.setBounds(25, 250, 200, 300);
        
        //폰트 추가
        Font font=new Font("맑은고딕", Font.BOLD, 13);
        tglBtnImage.setFont(font);
        labelName.setFont(font);
        labelWriter.setFont(font);
        labelPrice.setFont(font);
        
        //add
        add(tglBtnImage);
        add(taContent);
        add(labelName);
        add(labelWriter);
        add(labelPrice);
        taContent.setFocusable(true);
        taContent.setVisible(false);
        //메인 창 출력 위치
        setSize(250,500);
    }
    public static void main(String[] args) {
        new BookClickView().setVisible(true);
    }
    
}
