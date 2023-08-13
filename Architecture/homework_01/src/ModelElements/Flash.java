package ModelElements;

import Stuff.Angle3D;
import Stuff.Color;
import Stuff.Point3D;

public class Flash {
    public Point3D Location;
    public Angle3D Angle;
    public Color Color;
    public float Power;

    public Flash(Point3D location, Angle3D angle, Stuff.Color color, Float power) {
        this.Location = location;
        this.Angle = angle;
        this.Color = color;
        this.Power = power;
    }

    public void Rotate(Angle3D angle){

    }
    public void Move(Point3D point3D){

    }
}
