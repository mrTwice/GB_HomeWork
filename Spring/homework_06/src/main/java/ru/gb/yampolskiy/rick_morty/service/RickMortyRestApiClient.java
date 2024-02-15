package ru.gb.yampolskiy.rick_morty.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.Data;
import lombok.Getter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import ru.gb.yampolskiy.rick_morty.domain.*;
import ru.gb.yampolskiy.rick_morty.domain.Character;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static ru.gb.yampolskiy.rick_morty.configuration.StaticResourcesConfiguration.*;

@Data
@Getter
@Service
public class RickMortyRestApiClient {
    private List<Character> characters = new ArrayList<>();
    private List<Episode> episodes = new ArrayList<>();
    private List<Location> locations = new ArrayList<>();
    private RestClient restClient = RestClient.create();

    public Character requestCharacterById(int id){
        String jsonObject = restClient.get()
                .uri(API_ENDPOINT_CHARACTER + id)
                .retrieve()
                .body(String.class);
        Character character = new Gson().fromJson(jsonObject, Character.class);
        character.setEpisodes(requestAllEpisodesCharacter(character.getEpisodesUrl()));
        return character;
    }

    public Location requestLocationById(int id){
        String jsonObject = restClient.get()
                .uri(API_ENDPOINT_LOCATION + id)
                .retrieve()
                .body(String.class);
        return new Gson().fromJson(jsonObject, Location.class);
    }

    public Episode requestEpisodeById(int id){
        String jsonObject = restClient.get()
                .uri(API_ENDPOINT_EPISODE + id)
                .retrieve()
                .body(String.class);
        return new Gson().fromJson(jsonObject, Episode.class);
    }

    public Episode[] requestAllEpisodesCharacter(String[] urls){
        Episode[] episodes = new Episode[urls.length];
        for (int i =0; i < episodes.length; i++){
            String jsonObject = restClient.get()
                    .uri(urls[i])
                    .retrieve()
                    .body(String.class);
            episodes[i] = new Gson().fromJson(jsonObject, Episode.class);
        }
        return episodes;
    }


    public <T> Pages<T> requestAll(String endpoint, Class<T> tClass){
        String jsonObject = restClient.get()
                .uri(endpoint)
                .retrieve()
                .body(String.class);
        Type type = TypeToken.getParameterized(Pages.class, tClass).getType();
        return new Gson().fromJson(jsonObject, type);
    }
}