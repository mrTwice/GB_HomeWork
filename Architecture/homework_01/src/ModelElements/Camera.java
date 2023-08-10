package ModelElements;

import Stuff.Angle3D;
import Stuff.Point3D;

public class Camera {
    public Point3D Location;
    public Angle3D Angle;

    public Camera(Point3D location, Angle3D angle) {
        this.Location = location;
        this.Angle = angle;
    }
    public void Rotate(Angle3D angle){

    }
    public void Move(Point3D point3D){

    }
}
