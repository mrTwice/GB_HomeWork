package InMemoryModel;

import ModelElements.Camera;
import ModelElements.Flash;
import ModelElements.PoligonalModel;
import ModelElements.Scene;
import java.util.ArrayList;
import java.util.List;

public class ModelStore implements IModelChanger, IModelChangedObserver{
    public List<PoligonalModel> Models;
    public List<Scene> Scenes;
    public List<Flash> Flashes;
    public List<Camera> Cameras;
    private List<IModelChangedObserver> changeObservers =new ArrayList<>();

    public ModelStore() {
        this.Models = new ArrayList<>();
        this.Scenes = new ArrayList<>();
        this.Flashes = new ArrayList<>();
        this.Cameras = new ArrayList<>();
    }

    public Scene GetScene(int id){
        return Scenes.get(id);
    }
    @Override
    public void ApplyUpdateModel() {

    }

    @Override
    public void NotifyCange(IModelChanger sender) {

    }
}
