package ru.gb.yampolskiy.rick_morty.domain;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class Character{

    @Expose(serialize = false)
    @SerializedName("id")
    private Long id;

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
    //@Expose(serialize = false)
    private Location originLocation;

    @SerializedName("location")
    //@Expose(serialize = false)
    private Location lastKnownLocation;

    @SerializedName("image")
    private String avatarImage;

    @SerializedName("episode")
    //@Expose(serialize = false)
    private String[] episodesUrl;

    @SerializedName("url")
    private String thisCharacterEndpoint;

    @SerializedName("created")
    private String created;

}
