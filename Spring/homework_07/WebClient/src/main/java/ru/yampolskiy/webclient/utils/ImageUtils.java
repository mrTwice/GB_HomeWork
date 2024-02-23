package ru.yampolskiy.webclient.utils;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageUtils {

    public static BufferedImage byteArrayToBufferedImage(byte[] bytes) throws IOException {
        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        return ImageIO.read(bis);
    }
}
