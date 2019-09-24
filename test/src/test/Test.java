/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author Johannes Huemer
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Test t = new Test();
        System.out.println(t.kgv(5, 10));
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
