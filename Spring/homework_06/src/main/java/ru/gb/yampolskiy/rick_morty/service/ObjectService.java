package ru.gb.yampolskiy.rick_morty.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import ru.gb.yampolskiy.rick_morty.domain.Pages;

import java.lang.reflect.Type;

@Data
@Service
public abstract class ObjectService {
    private static final String BASE_URI = "https://rickandmortyapi.com/api/";

    protected RestClient restClient = RestClient.create(BASE_URI);

    protected  <T> Pages<T> requestAll(String endpoint, Class<T> tClass){
        String jsonObject = restClient.get()
                .uri(endpoint)
                .retrieve()
                .body(String.class);
        Type type = TypeToken.getParameterized(Pages.class, tClass).getType();
        return new Gson().fromJson(jsonObject, type);
    }
}
