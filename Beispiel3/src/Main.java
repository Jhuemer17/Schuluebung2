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
        NumberTester nt = new NumberTester("test.txt");
        nt.setOddEvenTester((a)->(a%2) == 0);
        nt.setPrimeTester((a)->{
            EratosthenesPrimeSieve ep = new EratosthenesPrimeSieve(a);
            return ep.isPrime(a);
        });
        nt.setPalindromeTester((a)->{
            String temp = new StringBuilder(a+"").reverse().toString();
            if(Integer.parseInt(temp)==a)return true;
            else return false;
        });
        nt.testFile();
    }
}
