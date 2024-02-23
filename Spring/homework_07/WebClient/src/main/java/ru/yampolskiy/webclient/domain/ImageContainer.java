package ru.yampolskiy.webclient.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;

@Data
@Setter
@Getter
public class ImageContainer {
    private BufferedImage image;

    public ImageContainer(BufferedImage image) {
        this.image = image;
    }

    public String bufferedImageToBase64(String formatName) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(this.image, formatName, baos);
        byte[] bytes = baos.toByteArray();
        return Base64.getEncoder().encodeToString(bytes);
    }
}
