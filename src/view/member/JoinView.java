package view.member;

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
    String items[] = {"총류", "철학, 심리학, 윤리학", "종교", "사회과학", "순수과학", "기술과학", "예술", "어학", "문학", "역사, 지리, 관광"};
    public JoinView(){
        setTitle("joinView");

        tfId = new JTextField();
        tfPwd = new JPasswordField();
        tfPwdConfirm = new JPasswordField();
        tfName= new JTextField();
        tfEmail = new JTextField();

        cbInterestCategory = new JComboBox<>(items);

        btnSubmit = new JButton("등록");
        btnReset = new JButton("취소");
        btnCheckId = new JButton("중복확인");

        labelId = new JLabel("I  D:");
        labelPwd = new JLabel("비  번:");
        labelPwd2 = new JLabel("비번확인:");
        labelName = new JLabel("이  름:");
        labelEmail = new JLabel("이메일:"); 
        labelInterestCategory = new JLabel("관심 분야:");

        //setBounds 
        tfId.setBounds(80,30,100,25);
        tfPwd.setBounds(80,70,100,25);
        tfPwdConfirm.setBounds(80,110,100,25);
        tfName.setBounds(80,150,100,25);
        tfEmail.setBounds(80,190,180,25);
        cbInterestCategory.setBounds(80,230,100,25);

        btnSubmit.setBounds(50,290,90,25);
        btnReset.setBounds(150,290,90,25);
        btnCheckId.setBounds(190,30,90,25);

        labelId.setBounds(10,30,100,25);
        labelPwd.setBounds(10,70,100,25);
        labelPwd2.setBounds(10,110,100,25);
        labelName.setBounds(10,150,100,25);
        labelEmail.setBounds(10, 190, 100, 25);
        labelInterestCategory.setBounds(10, 230, 100, 25);
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

        setBounds(350,200,300,400); 
        setVisible(false);
    }//생성자  
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