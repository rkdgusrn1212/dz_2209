package controller;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComponent;

//이미지 관련 메소드 제공.
public class ImageHelper {
    //component 크기에 맞춘 이미지 아이콘 리턴.
    public static ImageIcon getFitImageIcon(JComponent component, Image image) {
        return new ImageIcon(image.getScaledInstance(component.getBounds().width, component.getBounds().height, Image.SCALE_SMOOTH));
    }
    //기본 이미지를 원하는 크기로 불러와서 ImageIcon타입으로 반환함.
    public static ImageIcon getDefaultImageIcon(int width, int height) {
        try {
            ImageIcon icon = new ImageIcon(ImageIO.read(new File("asset/no_image.jpg")));
            Image img = icon.getImage();
            Image resizeImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            return new ImageIcon(resizeImg);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
