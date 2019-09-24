
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Johannes Huemer
 */
public class HalloJava {
    
    public static void main(String[]args)
    {
        List<String>list = new ArrayList<>();
        list.forEach((String a) -> System.out.println(a));
    }
}
