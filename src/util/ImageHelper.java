package util;

import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JComponent;

//이미지 관련 메소드 제공.
public class ImageHelper {
    //component 크기에 맞춘 이미지 아이콘 리턴.
    public static ImageIcon getFitImageIcon(JComponent component, Image image) {
        return new ImageIcon(image.getScaledInstance(component.getBounds().width, component.getBounds().height, Image.SCALE_SMOOTH));
    }
    public static ImageIcon getResizedImageIcon(ImageIcon icon, int width, int height) {
        Image img = icon.getImage();
        Image resizeImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(resizeImg);
    }
}
