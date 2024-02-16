package ru.gb.yampolskiy.rick_morty.service;

import com.google.gson.Gson;
import jakarta.annotation.PostConstruct;
import lombok.Data;
import lombok.Getter;
import org.springframework.stereotype.Service;
import ru.gb.yampolskiy.rick_morty.domain.Character;
import ru.gb.yampolskiy.rick_morty.domain.Pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@Data
@Getter
public class CharacterService extends ObjectService{

    private List<Pages<Character>> characterPages = new ArrayList<>();
    private List<Character> characters = new ArrayList<>();

    public Character requestCharacterById(int id){
        String jsonObject = restClient.get()
                .uri("/character/" + id)
                .retrieve()
                .body(String.class);
        Character character = new Gson().fromJson(jsonObject, Character.class);

        return character;
    }

    @PostConstruct
    private void fillCharacterPages(){
        ArrayList<Pages<Character>> tempPages = new ArrayList<>();
        tempPages.add(requestAll("character/", Character.class));
        String nextPage = tempPages.get(0).getInfo().getNext();
        while (nextPage != null){
            Pages<Character> next = requestAll(nextPage, Character.class);
            tempPages.add(next);
            nextPage = next.getInfo().getNext();
        }
        setCharacterPages(tempPages);
        ArrayList<Character> tempCharacters = new ArrayList<>();
        for (Pages<Character> page: getCharacterPages()){
            tempCharacters.addAll(Arrays.stream(page.getResults()).toList());
        }
        setCharacters(tempCharacters);
    }

}
