package ru.gb.yampolskiy.rick_morty.service;

import com.google.gson.Gson;
import org.springframework.stereotype.Service;
import ru.gb.yampolskiy.rick_morty.domain.Location;

import java.util.ArrayList;
import java.util.List;

@Service
public class LocationService  extends ObjectService{
    private List<Location> locations = new ArrayList<>();

    public Location requestLocationById(int id){
        String jsonObject = restClient.get()
                .uri("location/" + id)
                .retrieve()
                .body(String.class);
        return new Gson().fromJson(jsonObject, Location.class);
    }
}
