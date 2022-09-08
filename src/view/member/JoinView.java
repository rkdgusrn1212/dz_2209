package view.member;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.Controller;
import view.View;

public class JoinView extends View 
{
    public JTextField tfId,tfName,tfEmail;
    public JPasswordField tfPwd,tfPwdConfirm;
    public JButton btnSubmit,btnReset,btnCheckId;
    JLabel labelId,labelPwd,labelPwd2,labelName,labelEmail, labelInterestCategory;
    public JComboBox<String> cbInterestCategory;
    String items[] = {"종류", "철학, 심리학, 윤리학", "종교", "사회과학", "순수과학", "기술과학", "예술", "어학", "문학", "역사, 지리, 관광"};
    public JoinView(){
        setTitle("신규가입");

        tfId = new JTextField();
        tfPwd = new JPasswordField();
        tfPwdConfirm = new JPasswordField();
        tfName= new JTextField();
        tfEmail = new JTextField();

        cbInterestCategory = new JComboBox<>(items);

        btnSubmit = new JButton("등록");
        btnReset = new JButton("취소");
        btnCheckId = new JButton("중복확인");

        labelId = new JLabel("I  D");
        labelPwd = new JLabel("비밀번호");
        labelPwd2 = new JLabel("번호재확인");
        labelName = new JLabel("이  름");
        labelEmail = new JLabel("이메일"); 
        labelInterestCategory = new JLabel("관심 분야");

        //setBounds 
        tfId.setBounds(160,30,230,35);
        tfPwd.setBounds(160,120,230,35);
        tfPwdConfirm.setBounds(160,170,230,35);
        tfName.setBounds(160,220,230,35);
        tfEmail.setBounds(160,270,230,35);
        cbInterestCategory.setBounds(160,330,100,35);
        btnCheckId.setBounds(160,70,230,35); 
        btnSubmit.setBounds(50,400,160,35);
        btnReset.setBounds(260,400,160,35);
        labelId.setBounds(50,35,100,25);
        labelPwd.setBounds(50,125,100,25);
        labelPwd2.setBounds(50,175,100,25);
        labelName.setBounds(50,225,100,25);
        labelEmail.setBounds(50, 275, 100, 25);
        labelInterestCategory.setBounds(50, 330, 100, 25);
        
        // 폰트 생성
        Font font=new Font("맑은고딕", Font.BOLD, 16);
        tfId.setFont(font);
        tfPwd.setFont(font);
        tfPwdConfirm.setFont(font);
        tfName.setFont(font);
        tfEmail.setFont(font);
        cbInterestCategory.setFont(font);
        btnCheckId.setFont(font);
        btnSubmit.setFont(font);
        btnReset.setFont(font);
        labelId.setFont(font);
        labelPwd.setFont(font);
        labelPwd2.setFont(font);
        labelName.setFont(font);
        labelEmail.setFont(font);
        labelInterestCategory.setFont(font);
        
        
        //add
        setLayout(null);
        add(tfId);
        add(tfPwd);
        add(tfPwdConfirm);
        add(tfName);
        add(tfEmail);
        add(cbInterestCategory);
        add(btnSubmit);
        add(btnReset);
        add(btnCheckId);
        add(labelId); 
        add(labelPwd); 
        add(labelPwd2); 
        add(labelName);
        add(labelEmail);
        add(labelInterestCategory);

        setBounds(700,250,480,510); 
        setVisible(false);
        
        
    }// 팝업 생성자  
    public void showMsg(String msg) {
        JOptionPane.showMessageDialog(this, msg);
    }

    public void setEmpty() {
        tfId.setText("");
        tfEmail.setText("");
        tfName.setText("");
        tfPwd.setText("");
        tfPwdConfirm.setText("");
    }
}//JoinForm
