package MVP.Repository;

import MVP.Base.Hall;

import java.util.ArrayList;
import java.util.List;

public class HallsRepository {
    private static HallsRepository hallsRepository;
    private List<Hall> halls;

    private HallsRepository(){
        this.halls = new ArrayList<>();
        halls.add(new Hall("Веранда", "На улице"));
        halls.add(new Hall("Каменный", "с камином"));
        halls.add(new Hall("Оранжерея", "с растениями"));
    }

    public static HallsRepository getHallRepository(){
        if(hallsRepository == null)
            hallsRepository = new HallsRepository();
        return hallsRepository;
    }
    public List<Hall> getAllHalls(){
        return halls;
    }
}
