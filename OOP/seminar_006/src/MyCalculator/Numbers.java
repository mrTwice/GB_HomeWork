package MyCalculator;

public class Numbers {
    private double realPart;
    private double imaginaryPart;

    public Numbers(double realPart, double imaginaryPart){
        this.realPart = realPart;
        this.imaginaryPart = imaginaryPart;
    }

    public Numbers(double realPart){
        this.realPart = realPart;
        this.imaginaryPart = 0;
    }

    public double getRealPart() {
        return realPart;
    }

    public double getImaginaryPart() {
        return imaginaryPart;
    }
}
