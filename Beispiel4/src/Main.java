/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Johannes Huemer
 */
public class Main {
    public static void main(String[] args) {
        RationalCalculator rc = new RationalCalculator();
        
    }
    
    
    private double kgv(double a, double b) {
        double zahl1 = 0;
        double zahl2 = 0;
        for (zahl2 = a; zahl1 <= a * b; zahl1 = zahl1 + a) {
            for (zahl1 = b; zahl2 <= a * b; zahl2 = zahl2 + b) {
                if (zahl1 == zahl2) {
                    return zahl1;
                }
            }
        }
        return 2;
    }
    
    
    private void initRationalCalculator()
    {
        CalculationOperation add = new CalculationOperation() {
            @Override
            public Number calc(Number x, Number y) {
                double kgv = kgv(x.getB(), y.getB());
                double ergA = (x.getA() * (kgv / x.getB())) + (y.getA() * (kgv / y.getB()));
                double ergB = (kgv);

                return new Number(ergA, ergB);
            }
        };
        CalculationOperation subtract = new CalculationOperation() {
            @Override
            public Number calc(Number x, Number y) {
                double kgv = kgv(x.getB(), y.getB());
                double ergA = (x.getA() * (kgv / x.getB())) - (y.getA() * (kgv / y.getB()));
                double ergB = (kgv);

                return new Number(ergA, ergB);
            }
        };
        CalculationOperation divide = new CalculationOperation() {
            @Override
            public Number calc(Number x, Number y) {
                return new Number(x.getA()*y.getB(),x.getB()*y.getA());
            }
        };
        CalculationOperation multiply = new CalculationOperation() {
            @Override
            public Number calc(Number x, Number y) {
                return new Number(x.getA()*y.getA(),x.getB()*y.getB());
            }
        }
    }
}
