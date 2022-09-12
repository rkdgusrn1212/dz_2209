package util;

import java.awt.Image;

import javax.swing.ImageIcon;

//이미지 관련 메소드 제공.
public class ImageHelper {
    public static ImageIcon getResizedImageIcon(ImageIcon icon, int width, int height) {
        Image img = icon.getImage();
        Image resizeImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(resizeImg);
    }
}
