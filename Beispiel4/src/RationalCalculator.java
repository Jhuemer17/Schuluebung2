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
    public Number subtract(Number x, Number y) {
        double kgv = kgv(x.getB(), y.getB());
                double ergA = (x.getA() * (kgv / x.getB())) - (y.getA() * (kgv / y.getB()));
                double ergB = (kgv);

                return new Number(ergA, ergB);
    }

    @Override
    public Number multiply(Number x, Number y) {
         return new Number(x.getA() * y.getA(), x.getB() * y.getB());
    }

    @Override
    public Number divide(Number x, Number y) {
        return new Number(x.getA() * y.getB(), x.getB() * y.getA());
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
