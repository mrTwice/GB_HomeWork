package ru.yampolskiy.sourceserver.service;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.yampolskiy.sourceserver.model.Image;
import ru.yampolskiy.sourceserver.repository.ImageRepository;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
@Data
public class ImageService {

    private ImageRepository imageRepository;

    public void saveImageFormMultiPartFile(MultipartFile file) throws IOException {
        Image image = new Image();
        image.setData(file.getBytes());
        imageRepository.save(image);
    }

    public void saveImageFormByte(byte[] image) {
        Image imageData = new Image();
        imageData.setData(image);
        imageRepository.save(imageData);
    }


    public void saveImageFromUrl(String imageUrl) {
        try {
            URL url = new URL(imageUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            try (InputStream in = connection.getInputStream()) {
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = in.read(buffer)) != -1) {
                    out.write(buffer, 0, bytesRead);
                }
                byte[] imageBytes = out.toByteArray();
                saveImageFormByte(imageBytes);
            } finally {
                connection.disconnect();
            }
        } catch (IOException e) {
            // Обработка исключения
            e.printStackTrace(); // Здесь вы можете выполнить другие действия, например, логирование ошибки
        }
    }


    public Optional<Image> getImage(Long id) {
        return imageRepository.findById(id);
    }

    public List<Image> findAll() {
        return imageRepository.findAll();
    }

    public Optional<Image> getRandomImage(){
        List<Image> images = imageRepository.findAll();
        if (images.isEmpty())
            return Optional.empty();
        int randomIndex = new Random().nextInt(images.size());
        return Optional.of(images.get(randomIndex));
    }

    @PostConstruct
    public void defaultUploadImage() {
        try (InputStream in = new FileInputStream("cat.jpg");){
            String[] catImageUrls = {
                    "https://cs9.pikabu.ru/post_img/big/2017/02/16/11/1487271758162926768.jpg",
                    "https://cs9.pikabu.ru/post_img/big/2017/02/16/11/1487272062133185955.jpg",
                    "https://koshka.top/uploads/posts/2021-12/1638584671_2-koshka-top-p-melkii-kotenok-2.jpg",
                    "https://koshka.top/uploads/posts/2021-12/1638584742_8-koshka-top-p-melkii-kotenok-10.jpg"
            };
            byte[] image = in.readAllBytes();
            saveImageFormByte(image);
            Arrays.stream(catImageUrls).forEach(this::saveImageFromUrl);
        } catch (IOException e) {
            throw new RuntimeException("Изображение кота в корне проекта не найдено.");
        }
    }

}