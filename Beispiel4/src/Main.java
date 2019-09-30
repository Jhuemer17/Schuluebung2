
import com.oracle.xmlns.internal.webservices.jaxws_databinding.SoapBindingParameterStyle;
import java.util.Scanner;
import javafx.application.Platform;

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
    VectorCalculator vc;
    ComplexCalculator cc;

    public static void main(String[] args) {
        Main m1 = new Main();
        m1.initRationalCalculator();
        m1.initVectorCalculator();
        m1.initComplexCalculator();
        m1.startProgram();
    }

    private void startProgram() {
        Scanner input = new Scanner(System.in);

        int eing1 = 0;
        while (eing1 != 99) {
            printCalc();
            eing1 = input.nextInt();
            Number tempB = new Number();
            Number tempA = new Number();
            if (eing1 != 4) {
                tempA = makeNumber("x");
                tempB = makeNumber("y");
            }
            int eing2 = 0;
            switch (eing1) {
                case 1:
                    do {
                        printOperation();
                        eing2 = input.nextInt();
                    } while (eing2 == 5);
                    switch (eing2) {
                        case 1:
                            Number erg = rc.add.calc(tempA, tempB);
                            printSolution(erg);
                            break;
                        case 2:
                            erg = rc.subtract.calc(tempA, tempB);
                            printSolution(erg);
                            break;
                        case 3:
                            erg = rc.multiply.calc(tempA, tempB);
                            printSolution(erg);
                            break;
                        case 4:
                            erg = rc.divide.calc(tempA, tempB);
                            printSolution(erg);
                            break;
                    }
                    break;
                case 2:
                    do {
                        printOperation();
                        eing2 = input.nextInt();
                    } while (eing2 == 5);
                    switch (eing2) {
                        case 1:
                            Number erg = vc.add.calc(tempA, tempB);
                            printSolution(erg);
                            break;
                        case 2:
                            erg = vc.subtract.calc(tempA, tempB);
                            printSolution(erg);
                            break;
                        case 3:
                            erg = vc.multiply.calc(tempA, tempB);
                            printVectorSolution(erg);
                            break;
                        case 4:
                            erg = vc.divide.calc(tempA, tempB);
                            printVectorSolution(erg);
                            break;
                    }
                    break;
                case 3:
                    do {
                        printOperation();
                        eing2 = input.nextInt();
                    } while (eing2 == 5);
                    switch (eing2) {
                        case 1:
                            Number erg = cc.add.calc(tempA, tempB);
                            printSolution(erg);
                            break;
                        case 2:
                            erg = cc.subtract.calc(tempA, tempB);
                            printSolution(erg);
                            break;
                        case 3:
                            erg = cc.multiply.calc(tempA, tempB);
                            printSolution(erg);
                            break;
                        case 4:
                            erg = cc.divide.calc(tempA, tempB);
                            printSolution(erg);
                            break;
                    }
                    break;
                case 4:
                    eing1 = 99;
                    break;
                default:
                    
            }
        }
    }

    private static void printSolution(Number erg) {
        System.out.println("");
        System.out.println("Solution:");
        System.out.println("a = " + erg.getA());
        System.out.println("b = " + erg.getB());
    }

    private static void printVectorSolution(Number erg) {
        System.out.println("");
        System.out.println("Solution:");
        System.out.println("Vektorproduct = " + erg.getA());
    }

    private static Number makeNumber(String a) {
        Scanner mk = new Scanner(System.in);
        System.out.println("Enter number " + a + " a> ");
        double am = mk.nextDouble();
        System.out.println("Enter number " + a + " b> ");
        return new Number(am, mk.nextDouble());
    }

    private static void printCalc() {
        System.out.println("");
        System.out.println("");
        System.out.println("");
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

    private void initVectorCalculator() {
        CalculationOperation add = new CalculationOperation() {
            @Override
            public Number calc(Number x, Number y) {
                return new Number(x.getA() + y.getA(), x.getB() + y.getB());
            }
        };
        CalculationOperation subtract = new CalculationOperation() {
            @Override
            public Number calc(Number x, Number y) {
                return new Number(x.getA() - y.getA(), x.getB() - y.getB());
            }
        };
        CalculationOperation multiply = new CalculationOperation() {
            @Override
            public Number calc(Number x, Number y) {
                double erg = x.getA() * y.getA() + x.getB() * y.getB();
                return new Number(erg, erg);
            }
        };
        CalculationOperation divide = new CalculationOperation() {
            @Override
            public Number calc(Number x, Number y) {
                double erg = x.getA() / y.getA() + x.getB() / y.getB();
                return new Number(erg, erg);
            }
        };
        vc = new VectorCalculator(add, subtract, multiply, divide);
    }

    private void initComplexCalculator() {
        CalculationOperation add = new CalculationOperation() {
            @Override
            public Number calc(Number x, Number y) {
                return new Number(x.getA() + y.getA(), x.getB() + y.getB());
            }
        };
        CalculationOperation subtract = new CalculationOperation() {
            @Override
            public Number calc(Number x, Number y) {
                return new Number(x.getA() - y.getA(), x.getB() - y.getB());
            }
        };
        CalculationOperation multiply = new CalculationOperation() {
            @Override
            public Number calc(Number x, Number y) {
                double ergA = (x.getA() * y.getA()) - (y.getB() * x.getB());
                double ergB = (x.getA() * y.getB()) + (x.getB() * y.getA());
                return new Number(ergA, ergB);
            }
        };
        CalculationOperation divide = new CalculationOperation() {
            @Override
            public Number calc(Number x, Number y) {
                double tempA = (x.getA() * y.getA()) + (x.getB() * y.getB());
                double tempB = (x.getB() * y.getA()) + (x.getA() * (y.getB() * (-1)));
                double teiler = (y.getA() * y.getA()) + (y.getB() * y.getB());
                return new Number(tempA / teiler, tempB / teiler);
            }
        };
        cc = new ComplexCalculator(add, subtract, multiply, divide);
    }

    public double ggT(double a, double b) {
        if (a == b | b == 0) {
            return a;
        } else {
            return ggT(b, a % b);
        }
    }

    public double kgv(double a, double b) {
        return a * (b / ggT(a, b));
    }
}
