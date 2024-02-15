package ru.gb.yampolskiy.rick_morty.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttributes;
import ru.gb.yampolskiy.rick_morty.service.RickMortyRestApiClient;

@Controller
@Data
@AllArgsConstructor
@CommonsLog(topic = "RickMortyController")
@SessionAttributes("character")
public class RickMortyController {
    private RickMortyRestApiClient rickMortyRestApiClient;

    @GetMapping("/character/{id}")
    public String getCharacterById(@PathVariable int id, Model model){
        model.addAttribute("character", rickMortyRestApiClient.requestCharacterById(id));
        return "index";
    }

    @GetMapping("/location/{id}")
    public String getLocationById(@PathVariable int id, Model model){
        model.addAttribute("location", rickMortyRestApiClient.requestLocationById(id));
        return "location";
    }

    @GetMapping("/episode/{id}")
    public String getEpisodeById(@PathVariable int id, Model model){
        model.addAttribute("episode", rickMortyRestApiClient.requestEpisodeById(id));
        return "episode";
    }
}
