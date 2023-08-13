package ModelElements;
import java.lang.reflect.Type;
import java.util.List;
public class Scene {
    public int id;
    public  List<PoligonalModel> Models;
    public  List<Flash> Flashes;

    public List<Camera> Cameras;

    public Scene(int id, List<PoligonalModel> Models, List<Flash> Flashes, List<Camera> Cameras) throws Exception {
        this.id = id;
        if (Models.size() > 0) {
            this.Models = Models;
        } else throw new Exception("Нужна модель");
        this.Flashes = Flashes;
        if ( Cameras.size() > 0) {
        this.Cameras = Cameras;
        } else throw new Exception("Нужна камера");
    }
    public Type method1(Type type){
        return type;
    }
    public Type method2 (Type type1, Type type2){
        Type type = type1;
        return type;
    }
}
