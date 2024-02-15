package ru.gb.yampolskiy.rick_morty.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttributes;
import ru.gb.yampolskiy.rick_morty.domain.Character;
import ru.gb.yampolskiy.rick_morty.domain.Pages;
import ru.gb.yampolskiy.rick_morty.service.RickMortyRestApiClient;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static ru.gb.yampolskiy.rick_morty.configuration.StaticResourcesConfiguration.API_ENDPOINT_CHARACTER;

@Controller
@Data
@AllArgsConstructor
@CommonsLog(topic = "RickMortyController")
@SessionAttributes("characters")
public class RickMortyController {
    private RickMortyRestApiClient rickMortyRestApiClient;

    @GetMapping("/characters/")
    public String getCharacterById( Model model){
        rickMortyRestApiClient.getCharacters().addAll(Arrays.stream(rickMortyRestApiClient.requestAll(API_ENDPOINT_CHARACTER, Character.class).getResults()).toList());
        if(rickMortyRestApiClient.getCharacters().size() < rickMortyRestApiClient.requestAll(API_ENDPOINT_CHARACTER, Character.class).getInfo().getCount()) {
            Pages.Info info = rickMortyRestApiClient.requestAll(API_ENDPOINT_CHARACTER, Character.class).getInfo();
            while (info.getNext() != null) {
                rickMortyRestApiClient.getCharacters().addAll(Arrays.stream(rickMortyRestApiClient.requestAll(info.getNext(), Character.class).getResults()).toList());
                info = rickMortyRestApiClient.requestAll(info.getNext(), Character.class).getInfo();
            }
            rickMortyRestApiClient.getCharacters().forEach(c -> c.setEpisodes(rickMortyRestApiClient.requestAllEpisodesCharacter(c.getEpisodesUrl())));
        }
        List<Character> sixCharacters = new Random().ints(6,0, rickMortyRestApiClient.getCharacters().size()).mapToObj(rickMortyRestApiClient.getCharacters()::get).toList();
        model.addAttribute("characters", sixCharacters);
        return "characters";
    }

    @GetMapping("/character/{id}")
    public String getCharacterById(@PathVariable int id, Model model){
        model.addAttribute("character", rickMortyRestApiClient.requestCharacterById(id));
        return "character";
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
