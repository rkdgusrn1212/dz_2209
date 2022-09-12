package view.book;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controller.ImageHelper;
import view.View;

public class AddBookView extends View 
{
    public JTextField tfIsbn, tfBook, tfWriter, tfPrice, tfImage; 
    public JTextArea taContent;
    public JButton btnSubmit, btnReset;
    JLabel labelIsbn,labelBook,labelImage, labelWriter,labelCategory,labelPrice, labelContent;
    public JLabel bookImgLabel;
    public JComboBox<String> cbInterestCategory;
    JScrollPane sp;
    String items[] = {"총류", "철학, 심리학, 윤리학", "종교", "사회과학", "순수과학", "기술과학", "예술", "어학", "문학", "역사, 지리, 관광"};

    public AddBookView(){   
        setTitle("도서추가");

        tfIsbn = new JTextField();
        tfBook = new JTextField();
        tfWriter = new JTextField();
        tfPrice = new JTextField();
        taContent = new JTextArea();
        tfImage = new JTextField();

        btnSubmit = new JButton("등록");
        btnReset = new JButton("취소");

        labelIsbn = new JLabel("도서번호");
        labelBook = new JLabel("도서명");
        labelWriter = new JLabel("저자명");
        labelCategory = new JLabel("도서장르");
        labelPrice = new JLabel("도서원가"); 
        labelContent = new JLabel("줄거리");
        labelImage = new JLabel("도서 사진");
        bookImgLabel = new JLabel();
        
        cbInterestCategory = new JComboBox<>(items);

        //setBounds 
        tfIsbn.setBounds(150,30,200,35);
        tfBook.setBounds(150,80,200,35);
        tfWriter.setBounds(150,130,200,35);

        cbInterestCategory.setBounds(150,180,200,35);
        tfPrice.setBounds(150,230,200,35);
        sp = new JScrollPane(taContent);
        sp.setBounds(150,280,200,145);
        tfImage.setBounds(150, 440, 200, 35);

        tfImage.setFocusable(false);

        btnSubmit.setBounds(40,500,130,35);
        btnReset.setBounds(220,500,130,35);

        labelIsbn.setBounds(40,30,100,35);
        labelBook.setBounds(40,80,100,35);
        labelWriter.setBounds(40,130,100,35);
        labelCategory.setBounds(40, 180, 100,35);
        labelPrice.setBounds(40, 230, 100, 35);
        labelContent.setBounds(40, 273, 100, 35);
        labelContent.setBounds(40, 273, 100, 35);
        labelImage.setBounds(40, 440, 100, 35);
        bookImgLabel.setBounds(400, 25, 350, 495);

        Font font=new Font("맑은고딕", Font.BOLD, 16);
        tfIsbn.setFont(font);
        tfBook.setFont(font);
        tfWriter.setFont(font);
        cbInterestCategory.setFont(font);
        tfPrice.setFont(font);
        sp.setFont(font);
        btnSubmit.setFont(font);
        btnReset.setFont(font);
        labelIsbn.setFont(font);
        labelBook.setFont(font);
        labelWriter.setFont(font);
        labelCategory.setFont(font);
        labelPrice.setFont(font);
        labelContent.setFont(font);
        labelImage.setFont(font);



        //add
        setLayout(null);
        add(tfIsbn);
        add(tfBook);
        add(tfWriter);
        add(tfPrice);
        //          add(taContent);

        add(btnSubmit);
        add(btnReset);

        add(labelIsbn); 
        add(labelBook); 
        add(labelWriter); 
        add(labelCategory);
        add(labelPrice);
        add(labelContent);
        add(sp);
        add(cbInterestCategory);
        add(tfImage);
        add(labelImage);
        add(bookImgLabel);

        setBounds(700,200,800,600);
    }


    //생성자  
    public void showMsg(String msg) {
        JOptionPane.showMessageDialog(this, msg);
    }
}//AdsdBookView
