package MVP.Repository;

import Base.Hall;

import java.util.List;

public class HallsRepository {
    private static HallsRepository hallsRepository;
    private List<Hall> halls;

    private HallsRepository(){
        hallsRepository = getHallRepository();
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
