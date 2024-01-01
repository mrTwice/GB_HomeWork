package org.example.MVP;

import org.example.Essence.Door;

import java.util.ArrayList;
import java.util.Random;

public class Presenter {
    private Model model;
    private View view;
    private int iteration;


    public Presenter(int iteration){
        this.model = Model.getModel();
        this.view = new View();
        this.iteration = iteration;
    }

    public void start(){
        for (int i = 0; i < iteration; i++){
            ArrayList<Door> doors = model.getDoors();
            Boolean[] temp = new Boolean[3];
            model.shuffleDoors();
            int firstChoice = new Random().nextInt(0,3);
            int numberFromLeader = model.getDoorWithGoat(firstChoice);
            for (int j =0; j < temp.length; j++){
                if(j != firstChoice && j != numberFromLeader){
                    temp[j] = true;
                } else {
                    temp[j] = false;
                }
            }

            for (int j =0; j < temp.length; j++){
                if (temp[j]){
                    model.addResult(i, doors.get(j).openDoor());
                }
            }
        }

        view.printResult(percentWinsCount(), "Процент побед: ");
        view.printResult(getInfo("Автомобиль"), "Количество выбранных дверей с автомобилем: ");
        view.printResult(getInfo("Коза"), "Количество выбранных дверей с козой: ");
    }

    private int percentWinsCount(){
        int wins = model.getResults().values().stream().filter(e -> e.toString().equalsIgnoreCase("автомобиль")).toList().size();
        int allcount = model.getResults().size();

        return wins * 100 / allcount;
    }

    private int getInfo(String param){
        int unit = 0;
        for(String value : model.getResults().values()){
            if(value.equalsIgnoreCase(param))
                unit++;
        }
        return  unit;
    }
}
