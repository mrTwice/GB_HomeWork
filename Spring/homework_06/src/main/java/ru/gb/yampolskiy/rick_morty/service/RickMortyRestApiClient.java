package ru.gb.yampolskiy.rick_morty.service;

import com.google.gson.Gson;
import lombok.Data;
import lombok.Getter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import ru.gb.yampolskiy.rick_morty.domain.Character;
import ru.gb.yampolskiy.rick_morty.domain.Episode;
import ru.gb.yampolskiy.rick_morty.domain.Location;

@Data
@Getter
@Service
public class RickMortyRestApiClient {
    private static final String API_ENDPOINT_CHARACTER ="https://rickandmortyapi.com/api/character/";
    private static final String API_ENDPOINT_LOCATION ="https://rickandmortyapi.com/api/location/";
    private static final String API_ENDPOINT_EPISODE ="https://rickandmortyapi.com/api/episode/";
    private RestClient restClient = RestClient.create();

    public Character requestCharacterById(Long id){
        return restClient.get()
                .uri(API_ENDPOINT_CHARACTER + id)
                .retrieve()
                .body(Character.class);
    }

    public Location requestLocationById(Long id){
         return restClient.get()
                .uri(API_ENDPOINT_LOCATION + id)
                .retrieve()
                .body(Location.class);
    }

    public Episode requestEpisodeById(Long id){
        return restClient.get()
                .uri(API_ENDPOINT_EPISODE + id)
                .retrieve()
                .body(Episode.class);
    }
}
