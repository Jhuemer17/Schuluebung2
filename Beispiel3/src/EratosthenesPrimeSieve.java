
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Johannes Huemer
 */
public class EratosthenesPrimeSieve implements PrimeSieve {

    private int og;
    ArrayList<Integer> primes = new ArrayList();

    public EratosthenesPrimeSieve(int obergrenze) {
        og = obergrenze;
        findPrimes();
    }

    @Override
    public boolean isPrime(int p) {
        if (primes.contains(p)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void printPrimes() {
        for (int i : primes) {
            System.out.print(i + ", ");
        }
    }

    private void findPrimes() {
        Zahl[] zahlen = new Zahl[og - 1];
        int key = 2;
        for (int i = 0; i < og - 1; i++) {
            zahlen[i] = new Zahl(i + 2);
        }

        for (int i = 0; i < zahlen.length; i++) {

            for (int b = key * 2; b < zahlen.length + 2; b += key) {
                zahlen[b - 2].mark();
            }
            key++;
            while (key < zahlen.length - 2) {
                if (zahlen[key - 2].mark == false) {
                    break;
                } else {
                    key++;
                }
            }
        }
        for (int i = 0; i < zahlen.length; i++) {
            if (zahlen[i].mark == false) {
                primes.add(zahlen[i].zahl);
            }
        }
    }

    private class Zahl {

        boolean mark = false;
        int zahl;

        public Zahl(int zahl) {
            this.zahl = zahl;
        }

        public void mark() {
            mark = true;
        }

        public boolean isMark() {
            return mark;
        }

        public int getZahl() {
            return zahl;
        }

    }
}
