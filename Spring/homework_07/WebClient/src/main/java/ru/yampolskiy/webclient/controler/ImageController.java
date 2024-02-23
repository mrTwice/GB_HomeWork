package ru.yampolskiy.webclient.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.yampolskiy.webclient.service.ImageUploader;
import java.io.IOException;
import java.security.Principal;

@Controller
public class ImageController {

    @Autowired
    private ImageUploader imageUploader;

    @GetMapping
    public String getCat(Model model, Principal principal) throws IOException {
        String base64Image = imageUploader.uploadImage("http://localhost:8081/cat", principal).bufferedImageToBase64("jpg");
        model.addAttribute("cat", base64Image);
        return "cat-page";
    }
}
