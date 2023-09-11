package MVP.Providers;

import MVP.Base.Hall;
import MVP.Repository.HallsRepository;

import java.util.List;

public class HallsProvider {
    private HallsRepository hallsRepository;

    public HallsProvider() {
        this.hallsRepository = HallsRepository.getHallRepository();
    }

    public List<Hall> getHalls(){
        return hallsRepository.getAllHalls();
    }

    public Hall getHallByID( int id) {
        List<Hall> halls = getHalls();
        Hall hall = null;
        for (Hall hallInList: halls) {
            if(hallInList.getId() == id)
                hall = hallInList;
        }
        return  hall;
    }
}
