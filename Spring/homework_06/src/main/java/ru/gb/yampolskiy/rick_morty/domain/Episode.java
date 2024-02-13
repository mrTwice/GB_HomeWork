package ru.gb.yampolskiy.rick_morty.domain;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.Getter;

import java.util.List;


@Data
@Getter
public class Episode {
    private int	id;
    private  String name;
    private  String air_date;
    private  String episode;
    private String[] characters;
    @SerializedName("url")
    private String thisEpisodeEndpoint;
    private String created;
}
