
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Johannes Huemer
 */
public class NumberTester {

    private String pfad;

    private NumberTest oddEvenTester;
    private NumberTest primeTester;
    private NumberTest palindromeTester;

    public NumberTester(String filename) {
        this.pfad = pfad;

    }

    public void setOddEvenTester(NumberTest oddTester) {
        this.oddEvenTester = oddTester;
    }

    public void setPrimeTester(NumberTest primeTester) {
        this.primeTester = primeTester;
    }

    public void setPalindromeTester(NumberTest palindromeTester) {
        this.palindromeTester = palindromeTester;
    }

    public void testFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(pfad))) {
            String x = br.readLine();
            for (int i = 0; i < Integer.parseInt(x); i++) {
                String[] line = br.readLine().split(" ");
                int index = Integer.parseInt(line[0]);

                switch (index) {
                    case 1:
                        boolean a = oddEvenTester.testNumber(Integer.parseInt(line[1]));
                        if(a)System.out.println("EVEN");
                        else System.out.println("NO EVEN");
                        break;
                    case 2:
                        boolean b = primeTester.testNumber(Integer.parseInt(line[1]));
                        if(b)System.out.println("PRIME");
                        else System.out.println("NO PRIME");
                        break;
                    case 3:
                        boolean c = palindromeTester.testNumber(Integer.parseInt(line[1]));
                        if(c)System.out.println("PALINDROME");
                        else System.out.println("NO PALINDROME");
                        break;
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public interface NumberTest {

        boolean testNumber(int number);
    }
}
