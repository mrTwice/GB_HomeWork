package ModelElements;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
public class Scene {
    public int id;
    public  List<PoligonalModel> Models;
    public  List<Flash> Flashes;

    public List<Camera> Cameras;

    public Scene(List<PoligonalModel> Models, List<Flash> Flashes, List<Camera> Cameras) {
        this.Models = Models;
        this.Flashes = Flashes;
        this.Cameras = Cameras;
    }
    public Type method1(Type type){
        return type;
    }
    public Type method2 (Type type1, Type type2){
        Type type = type1;
        return type;
    }
}
