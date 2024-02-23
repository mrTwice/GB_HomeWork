package ru.yampolskiy.webclient.service;

import lombok.AllArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientResponseException;
import ru.yampolskiy.webclient.domain.ImageContainer;
import ru.yampolskiy.webclient.utils.ImageUtils;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.security.Principal;

@Service
@AllArgsConstructor
public class ImageUploader {

    private RestTemplateService restTemplate;

    public ImageContainer uploadImage(String url, Principal principal) throws IOException {
        try {

            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.set("Authorization", "Bearer " + restTemplate.getAccessToken(principal));
            HttpEntity<String> entity = new HttpEntity<>(httpHeaders);

            ResponseEntity<byte[]> response = restTemplate.getRestTemplate().exchange(url, HttpMethod.GET, entity, byte[].class);

            if (response.getStatusCode() == HttpStatus.OK) {
                byte[] imageBytes = response.getBody();
                BufferedImage image = ImageUtils.byteArrayToBufferedImage(imageBytes);
                return new ImageContainer(image);
            } else {
                throw new RuntimeException("Failed to fetch image");
            }
        } catch (RestClientResponseException ex) {
            throw new RuntimeException("Error while communicating with the server: " + ex.getRawStatusCode(), ex);
        }
    }
}
