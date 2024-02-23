package ru.yampolskiy.sourceserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.yampolskiy.sourceserver.service.ImageService;

import java.io.IOException;

//@RestController
//public class ImageController {
//    @GetMapping("/cat")
//    public ResponseEntity<byte[]> getImageCat() throws IOException {
//        InputStream in = new FileInputStream("cat.jpg");
//        byte[] image = in.readAllBytes();
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.IMAGE_JPEG);
//        return new ResponseEntity<>(image, headers, HttpStatus.OK);
//    }
//}

@RestController
@RequestMapping("/")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @PostMapping("/upload")
    public void uploadImage(@RequestParam("file") MultipartFile file) throws IOException {
        imageService.saveImageFormMultiPartFile(file);
    }

    @GetMapping("/{id}")
    public ResponseEntity<byte[]> getImageById(@PathVariable Long id) {
        return imageService.getImage(id)
                .map(image -> ResponseEntity.ok().body(image.getData()))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/cat")
    public ResponseEntity<byte[]> getRandomImage() throws IOException {
        return  imageService.getRandomImage().map(image -> ResponseEntity.ok().body(image.getData()))
                .orElse(ResponseEntity.notFound().build());

    }
}
