package ru.gb.yampolskiy.rick_morty.service;

import com.google.gson.Gson;
import org.springframework.stereotype.Service;
import ru.gb.yampolskiy.rick_morty.domain.Episode;

import java.util.ArrayList;
import java.util.List;

@Service
public class EpisodeService  extends ObjectService{

    private List<Episode> episodes = new ArrayList<>();

    public Episode requestEpisodeById(int id){
        String jsonObject = restClient.get()
                .uri("/episode/" + id)
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
}
