package Task_02.MVP;

import Task_02.Base.Calculator;

import java.util.ArrayList;
import java.util.List;

public class Model extends Calculator {

    private List<Double> lastResult;

    public Model(){
        lastResult = new ArrayList<>();
    }

    public List<Double> getLastResult() {
        return lastResult;
    }

    @Override
    public <F extends Number, S extends Number> double addition(F first, S second) {
       double result = super.addition(first, second);
       lastResult.add(result);
       return result;
    }

    @Override
    public <F extends Number, S extends Number> double subtraction(F first, S second) {
        double result =  super.subtraction(first, second);
        lastResult.add(result);
        return result;
    }

    @Override
    public <F extends Number, S extends Number> double multiplication(F first, S second) {
        double result =  super.multiplication(first, second);
        lastResult.add(result);
        return result;
    }

    @Override
    public <F extends Number, S extends Number> double division(F first, S second) {
        double result =  super.division(first, second);
        lastResult.add(result);
        return result;
    }
}
