/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notification;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Đặng Quốc
 */
public class ImageHepper {
    public static Image resize(Image originalImage, int tagetWidth,int tagetHeight){
        Image resultingImage = originalImage.getScaledInstance(tagetWidth, tagetHeight, Image.SCALE_SMOOTH);
        return resultingImage;
    }
    public static byte[] toByteArray(Image img,String type) throws IOException{ // chuyên đối tượng về sang mangrg byte
        BufferedImage bimg = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_RGB);
        Graphics2D g = bimg.createGraphics(); // vẽ hunhf ảnh
        g.drawImage(img, 0, 0, null);
        g.dispose();
        
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(bimg, type, baos);
        byte[] imageInByte = baos.toByteArray();
        
        return  imageInByte;
    }
    public static Image createImageFromByteArray(byte[] data, String type) throws IOException{ //chuyển mảng byte về đối tượng
        ByteArrayInputStream bais = new ByteArrayInputStream(data);
        BufferedImage bImage2 = ImageIO.read(bais);
        
        Image img = bImage2.getScaledInstance(bImage2.getWidth(), bImage2.getHeight(), Image.SCALE_SMOOTH);
        return img;
    }
}
