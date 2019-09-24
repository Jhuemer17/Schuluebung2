
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
    }

    public void setPalindromeTester(NumberTest palindromeTester) {
    }

    public void testFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String x = br.readLine();
            for (int i = 0; i < Integer.parseInt(x); i++) {
                String[] line = br.readLine().split(" ");
                int index = Integer.parseInt(line[0]);

                switch (index) {
                    case 1:
                        
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
