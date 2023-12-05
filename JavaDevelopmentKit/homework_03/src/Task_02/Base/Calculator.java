package Task_02.Base;

public abstract class Calculator {

    public<F extends Number, S extends Number> double addition(F first, S second){
        return first.doubleValue() + second.doubleValue();
    }

    public <F extends Number, S extends Number> double subtraction(F first, S second){
        return first.doubleValue() - second.doubleValue();
    }
    public <F extends Number, S extends Number> double multiplication(F first, S second){
        return first.doubleValue() * second.doubleValue();
    }

    public <F extends Number, S extends Number> double division(F first, S second){
        if(second.doubleValue() == 0.0)
            throw new ArithmeticException("Деление на ноль!");
        return first.doubleValue() / second.doubleValue();
    }

}
