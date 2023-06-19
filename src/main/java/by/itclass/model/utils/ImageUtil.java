package by.itclass.model.utils;

import by.itclass.model.entities.Image;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

public class ImageUtil {
    public static void createImageFile(String path, Image image) {
        File file = new File(path + image.getName());

        if (!file.exists()) {
            try {
                if (file.createNewFile()) {
                    try (OutputStream out = new FileOutputStream(file)){
                        out.write(image.getContent());
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public static Image getImage(String path) {
        Image image = null;
        try {
            BufferedImage bufferedImage = ImageIO.read(new File(path + "user.png"));
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ImageIO.write(bufferedImage, "png", byteArrayOutputStream);
            byte[] content = byteArrayOutputStream.toByteArray();
            image = new Image("user.png", content);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }
}
