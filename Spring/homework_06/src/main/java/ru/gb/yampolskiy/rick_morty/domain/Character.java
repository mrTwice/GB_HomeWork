package ru.gb.yampolskiy.rick_morty.domain;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import jakarta.annotation.PostConstruct;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.net.URL;
import java.util.List;

@Data
@Getter
public class Character{

    @SerializedName("id")
    private long id;

    @SerializedName("name")
    private  String name;

    @SerializedName("status")
    private  String status;

    @SerializedName("species")
    private  String species;

    @SerializedName("type")
    private  String type;

    @SerializedName("gender")
    private  String gender;

    @SerializedName("origin")
    private Location originLocation;

    @SerializedName("location")
    private Location lastKnownLocation;

    @SerializedName("image")
    private String avatarImage;

    @SerializedName("episode")
    private String[] episodesUrl;

    @SerializedName("url")
    private String thisCharacterEndpoint;

    @SerializedName("created")
    private String created;

    @Getter
    @Setter
    private Episode[] episodes;


}
