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
import ru.gb.yampolskiy.rick_morty.service.CharacterService;
import ru.gb.yampolskiy.rick_morty.service.EpisodeService;
import ru.gb.yampolskiy.rick_morty.service.LocationService;
import java.util.List;
import java.util.Random;

@Controller
@Data
@AllArgsConstructor
@CommonsLog(topic = "RickMortyController")
@SessionAttributes("characters")
public class RickMortyController {
    private CharacterService characterService;
    private LocationService locationService;
    private EpisodeService episodeService;

    @GetMapping("/characters/")
    public String getCharacters( Model model){
        List<Character> sixRandomCharacters = new Random().ints(6,0, characterService.getCharacters().size()).mapToObj(characterService.getCharacters()::get).toList();
        for (Character character: sixRandomCharacters)
            character.setEpisodes(episodeService.requestAllEpisodesCharacter(character.getEpisodesUrl()));
        model.addAttribute("characters", sixRandomCharacters);
        return "characters";
    }

    @GetMapping("/character/{id}")
    public String getCharacterById(@PathVariable int id, Model model){
        Character character = characterService.requestCharacterById(id);
        character.setEpisodes(episodeService.requestAllEpisodesCharacter(character.getEpisodesUrl()));
        model.addAttribute("character", character);
        return "character";
    }

    @GetMapping("/location/{id}")
    public String getLocationById(@PathVariable int id, Model model){
        model.addAttribute("location", locationService.requestLocationById(id));
        return "location";
    }

    @GetMapping("/episode/{id}")
    public String getEpisodeById(@PathVariable int id, Model model){
        model.addAttribute("episode", episodeService.requestEpisodeById(id));
        return "episode";
    }
}
