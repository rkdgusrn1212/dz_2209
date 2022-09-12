package controller.book;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class BookInputChecker {

    boolean isValidISBN(JTextField textField, String isbn) {
        if(isbn.length()!=13) {
            JOptionPane.showMessageDialog(textField,"ISBN은 13자리입니다.", "알림", JOptionPane.WARNING_MESSAGE);
            textField.requestFocus();
            return false;
        }
        return true;
    }
    boolean isValidBName(JTextField textField, String bName) {
        if(bName.length()<1) {
            JOptionPane.showMessageDialog(textField,"도서 이름을 입력하세요", "알림", JOptionPane.WARNING_MESSAGE);
            textField.requestFocus();
            return false;
        }else if(bName.length()>128) {
            JOptionPane.showMessageDialog(textField,"도서 이름은 128자 이내여야 합니다.", "알림", JOptionPane.WARNING_MESSAGE);
            textField.requestFocus();
            return false;
        }else {
            return true;   
        }
    }
    boolean isValidWriter(JTextField textField, String writer) {
        if(writer.length()<1) {
            JOptionPane.showMessageDialog(textField,"저자를 입력하세요", "알림", JOptionPane.WARNING_MESSAGE);
            textField.requestFocus();
            return false;
        }else if(writer.length()>40) {
            JOptionPane.showMessageDialog(textField,"저자는 128자 이내여야 합니다.", "알림", JOptionPane.WARNING_MESSAGE);
            textField.requestFocus();
            return false;
        }else {
            return true;   
        }
    }
    boolean isValidPrice(JTextField textField, String price) {
        if(price.length()<1) {
            JOptionPane.showMessageDialog(textField,"가격을 입력하세요", "알림", JOptionPane.WARNING_MESSAGE);
            textField.requestFocus();
            return false;
        }else if(price.length()>10) {
            JOptionPane.showMessageDialog(textField,"가격은 10자리 이내여야 합니다.", "알림", JOptionPane.WARNING_MESSAGE);
            textField.requestFocus();
            return false;
        }
        try {
            Integer.parseInt(price);
        }catch(NumberFormatException ex) {
            JOptionPane.showMessageDialog(textField,"올바른 숫자 형식으로 입력해주세요.", "알림", JOptionPane.WARNING_MESSAGE);
            textField.requestFocus();
            return false;
        }
        return true;
    }
    boolean isValidSummary(JTextArea textarea, String summary) {
        if(summary.length()<1) {
            JOptionPane.showMessageDialog(textarea,"줄거리를 입력하세요", "알림", JOptionPane.WARNING_MESSAGE);
            return false;
        }else if(summary.length()>1800) {
            JOptionPane.showMessageDialog(textarea,"줄거리는 1800자 이내여야 합니다.", "알림", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }
}
