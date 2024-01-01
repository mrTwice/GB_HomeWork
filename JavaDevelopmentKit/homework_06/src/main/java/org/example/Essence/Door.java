package org.example.Essence;

public class Door {
    private Prize prize;

    public Door(Prize prize){
        this.prize = prize;
    }

    public String openDoor(){
        return this.prize.getName();
    }

}
