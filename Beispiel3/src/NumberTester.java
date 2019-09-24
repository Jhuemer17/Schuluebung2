
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
    public String pfad;

    public NumberTester(String filename) {
        this.pfad = pfad;
        try(BufferedReader br = new BufferedReader(new FileReader(filename)))
        {
            String x = br.readLine();
            for(int i = 0; i< Integer.parseInt(x);i++)
            {
                String[]line = br.readLine().split(" ");
                int index = Integer.parseInt(line[0]);
                
                switch(index)
                {
                    case 1:
                        
                }
            }
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }
    }

    public void setOddEvenTester(NumberTest oddTester){}
    public void setPrimeTester(NumberTest primeTester){}
    public void setPalindromeTester(NumberTest palindromeTester){}
    public void testFile(){}
    
    public interface NumberTest{
        boolean testNumber(int number);
    }
}
