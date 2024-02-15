package ru.gb.yampolskiy.rick_morty.service;

import com.google.gson.Gson;
import lombok.Data;
import lombok.Getter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import ru.gb.yampolskiy.rick_morty.domain.*;
import ru.gb.yampolskiy.rick_morty.domain.Character;

import java.util.List;

@Data
@Getter
@Service
public class RickMortyRestApiClient {
    private static final String API_ENDPOINT_CHARACTER ="https://rickandmortyapi.com/api/character/";
    private static final String API_ENDPOINT_LOCATION ="https://rickandmortyapi.com/api/location/";
    private static final String API_ENDPOINT_EPISODE ="https://rickandmortyapi.com/api/episode/";
    private RestClient restClient = RestClient.create();

    public Character requestCharacterById(int id){
        String jsonObject = restClient.get()
                .uri(API_ENDPOINT_CHARACTER + id)
                .retrieve()
                .body(String.class);
        return new Gson().fromJson(jsonObject, Character.class);
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

    public <T> Answer<T> requestAllEpisodes(Class<T> tClass){
        String jsonObject = restClient.get()
                .uri(API_ENDPOINT_EPISODE)
                .retrieve()
                .body(String.class);
        System.out.println();
        System.out.println(jsonObject);
        System.out.println();
        return new Gson().fromJson(jsonObject, Answer.class);
    }

    public static void main(String[] args) {
        RickMortyRestApiClient rickMortyRestApiClient = new RickMortyRestApiClient();
        Answer answer = rickMortyRestApiClient.requestAllEpisodes(Episode.class);
        Episode[] episodes = answer.getResults();
        for (Episode episode: episodes){
            System.out.println(episode.getName());
        }

    }
}