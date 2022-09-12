package view.book;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JToggleButton;

import controller.ImageHelper;

public class BookClickView extends JPanel {
    public JToggleButton tglBtnImage;
    public JLabel labelName, labelWriter, labelPrice;
    public JScrollPane spContent;
    public JTextArea taContent;
    public JButton btnPick;
    public BookClickView() {
        setLayout(null);
        
        //new
        int btnWidth = 142;
        int btnHeight = 200;
        tglBtnImage = new JToggleButton();
        labelName = new JLabel("도서명");
        labelWriter = new JLabel("저자명");
        spContent = new JScrollPane(taContent = new JTextArea("간단줄거리"));
        taContent.setLineWrap(true);
        labelPrice = new JLabel("가격");
        btnPick = new JButton("자세히 보기");
        
        //setBounds
        tglBtnImage.setBounds(35, 100, btnWidth, btnHeight);
        labelName.setBounds(10, 320, 250, 35);
        labelWriter.setBounds(10, 370, 230, 35);
        labelPrice.setBounds(10, 420, 230, 35);
        spContent.setBounds(10, 300, 200, 200);
        btnPick.setBounds(45, 60, 120, 35);
        
        //폰트 추가
        Font font=new Font("맑은고딕", Font.BOLD, 15);
        tglBtnImage.setFont(font);
        labelName.setFont(font);
        labelWriter.setFont(font);
        labelPrice.setFont(font);
        btnPick.setFont(font);
        

        Font fontContent=new Font("맑은고딕", Font.PLAIN, 14);
        taContent.setFont(fontContent);
        
        //add
        add(btnPick);
        add(tglBtnImage);
        add(spContent);
        add(labelName);
        add(labelWriter);
        add(labelPrice);
        spContent.setFocusable(true);
        spContent.setVisible(false);
        //메인 창 출력 위치
        setSize(250,500);
    }
}
