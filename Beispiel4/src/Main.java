
import com.oracle.xmlns.internal.webservices.jaxws_databinding.SoapBindingParameterStyle;
import java.util.Scanner;

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

    RationalCalculator rc;

    public static void main(String[] args) {
        Main m1 = new Main();
        m1.initRationalCalculator();
        m1.startProgram();
    }
    private void startProgram()
    {
        Scanner input = new Scanner(System.in);

        int eing1 = 0;
        while (eing1 != 99) {
            printCalc();
            eing1 = input.nextInt();
            Number tempA = makeNumber("x");
            Number tempB = makeNumber("y");
            int eing2 = 0;
            switch (eing1) {
                case 1:
                    do {
                        printOperation();
                        eing2 = input.nextInt();
                    } while(eing2 == 5);
                    switch (eing2) {
                            case 1:
                                Number erg = rc.add(tempA, tempB);
                                System.out.println("");
                                System.out.println("Solution:");
                                System.out.println("a = "+erg.getA());
                                System.out.println("b = "+erg.getB());
                                break;
                        }
                    break;

            }
        }
    }

    private static Number makeNumber(String a) {
        Scanner mk = new Scanner(System.in);
        System.out.println("Enter number " + a + " a> ");
        double am = mk.nextDouble();
        System.out.println("Enter number " + a + " b> ");
        return new Number(am, mk.nextDouble());
    }

    private static void printCalc() {
        System.out.println("Choose calculator:");
        System.out.println("1 - Relational calculator");
        System.out.println("2 - Vector calculator");
        System.out.println("3 - Complex calculator");
        System.out.println("4 - Exit program");
    }

    private static void printOperation() {
        System.out.println("Choose operation:");
        System.out.println("1 - add");
        System.out.println("2 - subract");
        System.out.println("3 - multiply");
        System.out.println("4 - divide");
        System.out.println("5 - enter numbers again");
    }

    private void initRationalCalculator() {
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
                return new Number(x.getA() * y.getB(), x.getB() * y.getA());
            }
        };
        CalculationOperation multiply = new CalculationOperation() {
            @Override
            public Number calc(Number x, Number y) {
                return new Number(x.getA() * y.getA(), x.getB() * y.getB());
            }
        };
        rc = new RationalCalculator(add, subtract, multiply, divide);
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
