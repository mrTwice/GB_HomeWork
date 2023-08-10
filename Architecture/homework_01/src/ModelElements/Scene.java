package ModelElements;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
public class Scene {
    public int id;
    public  List<PoligonalModel> Models;
    public  List<Flash> Flashes;

    public Scene() {
        this.Models = new ArrayList<>();
        this.Flashes = new ArrayList<>();
    }
    public Type method1(Type type){
        return type;
    }
    public Type method2 (Type type1, Type type2){
        Type type = type1;
        return type;
    }
}
