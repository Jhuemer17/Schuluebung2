/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Johannes Huemer
 */
public class Number {

    private double a;
    private double b;

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public void setA(double a) {
        this.a = a;
    }

    public void setB(double b) {
        this.b = b;
    }

    public interface CalculationOperation {

        Number calc(Number x, Number y);
    }

    public abstract class AbstractCalculator {

        protected CalculationOperation add;
        protected CalculationOperation subtract;
        protected CalculationOperation multiply;
        protected CalculationOperation divide;

        public AbstractCalculator(CalculationOperation add, CalculationOperation subtract, CalculationOperation multiply, CalculationOperation divide) {
            this.add = add;
            this.subtract = subtract;
            this.multiply = multiply;
            this.divide = divide;
        }
        
        
        
                
    }
}
