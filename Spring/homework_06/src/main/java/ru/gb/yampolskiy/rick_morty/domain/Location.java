package ru.gb.yampolskiy.rick_morty.domain;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Data
@Getter
public class Location {
    private int	id;
    private  String name;
    private  String type;
    private  String dimension;
    private List<Character> residents;
    @SerializedName("url")
    private String thisLocationEndpoint;
    private String created;

}
