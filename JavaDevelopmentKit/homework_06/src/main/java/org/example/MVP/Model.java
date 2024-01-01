package org.example.MVP;

import org.example.Essence.Auto;
import org.example.Essence.Door;
import org.example.Essence.Goat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

public class Model {
    private static Model model;
    private HashMap<Integer, String> results;
    private ArrayList<Door> doors = new ArrayList<>();

    private Model(){
        results = new HashMap<>();
        doors.add(0, new Door(new Auto()));
        doors.add(1, new Door(new Goat()));
        doors.add(2, new Door(new Goat()));
        Collections.shuffle(doors);

    }

    public static Model getModel(){
        if(model == null)
            model = new Model();
        return model;
    }

    public HashMap<Integer,String> getResults(){
        return results;
    }

    public void addResult(int iteration, String result){
        results.put(iteration, result);
    }

    public void shuffleDoors(){
        Collections.shuffle(doors);
    }

    public ArrayList<Door> getDoors() {
        return doors;
    }

    public int getDoorWithGoat(int firstChoice){
        boolean flag = false;
        int doorNumberWithGoat = -1;
        while (!flag){
            int random = new Random().nextInt(0,3);
            Door door = doors.get(random);
            if(random != firstChoice && door.openDoor().equalsIgnoreCase("коза")) {
                doorNumberWithGoat = random;
                flag = true;
            }
        }
        return doorNumberWithGoat;
    }
}
