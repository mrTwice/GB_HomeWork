package org.hometask;

import javax.persistence.*;

@Entity
@Table(name = "schoolDB.Course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="Title")
    private String title;
    @Column(name="Duration")
    private String duration;

    public Course() {
    }

    public Course(String title, String duration) {
        this.title = title;
        this.duration = duration;
    }

    public Course(int id, String title, String duration) {
        this.id = id;
        this.title = title;
        this.duration = duration;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDuration() {
        return duration;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "[" + id + "] " + title + " " + duration;
    }
}
