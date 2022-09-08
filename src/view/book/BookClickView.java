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
        tglBtnImage = new JToggleButton(new ImageIcon("asset/dooboo.jpg"));
        labelName = new JLabel("도서명");
        labelWriter = new JLabel("저자명");
        taContent = new JTextArea("간단줄거리");
        labelPrice = new JLabel("가격");
        
        //setBounds
        tglBtnImage.setBounds(25, 25, 200, 200);
        labelName.setBounds(20, 270, 80, 30);
        labelWriter.setBounds(20, 340, 80, 30);
        labelPrice.setBounds(20, 410, 80, 30);
//        taContent.setBounds(25, 350, 200, 150);
        taContent.setBounds(25, 250, 200, 300);
        
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
