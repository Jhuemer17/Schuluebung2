/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Johannes Huemer
 */
public class RationalCalculator extends AbstractCalculator {

    public RationalCalculator(CalculationOperation add, CalculationOperation subtract, CalculationOperation multiply, CalculationOperation divide) {
        super(add, subtract, multiply, divide);
    }


    

    @Override
    public Number add(Number x, Number y) {
        double kgv = kgv(x.getB(), y.getB());
                double ergA = (x.getA() * (kgv / x.getB())) + (y.getA() * (kgv / y.getB()));
                double ergB = (kgv);

                return new Number(ergA, ergB);
    }

    @Override
    public Number subtract(Number a, Number b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Number multiply(Number a, Number b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Number divide(Number a, Number b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

     public double ggT(double a, double b)
     {
         if(a==b|b==0)return a;
         else return ggT(b,a%b);
     }
    public double kgv(double a, double b)
    {
        return a*(b/ggT(a,b));
    }

}
