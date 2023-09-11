package MVP.Base;

import java.awt.*;
import java.util.List;

public class Hall {
    private int id =0;
    private String title;
    private String description;
    private List<Image> photos;

    public Hall(String title, String description) {
        this.id++;
        this.title = title;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public List<Image> getPhotos() {
        return photos;
    }

    public void addPhoto( Image photo){
        photos.add(photo);
    }
}

