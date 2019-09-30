
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Johannes Huemer
 */
public class BiPredicate {
    public static void main(String[] args) {
        boolean result1 = vergleich((a)->{
            if(a<=10)   //ist a kleiner gleich 10?
            {
                return true;
            }
            else return false;
        },10);
        
        anzeige(a->{
            System.out.println("Das Ergebnis des Testes vergleich mit der zahl 10,");
            System.out.println("ist wie folgt: "+result1);
        }, 10);

        BinaryOperator bo = new BinaryOperator() {
            @Override
            public Object apply(Object t, Object u) {
                return t.hashCode()+u.hashCode();
            }
        };
        int erg = berechnung(a->a*a, 35);
        anzeige(a->{
            System.out.println("Das Ergebnis des Testes berechnung(a*a) mit der zahl 35,");
            System.out.println("ist wie folgt: "+erg);
        }, erg);
    }
    private static boolean vergleich(Predicate<Integer>predicate, Integer i)
    {
        return predicate.test(i);
    }
    private static void anzeige(Consumer<Integer>consumer, Integer i)
    {
        consumer.accept(i);
    }
    private static boolean biVergleich(BiPredicate biPredicate, Integer i1,Integer i2)
    {
        return biPredicate.biVergleich(biPredicate, i1, i2);
    }
    private static void biAnzeige(BiConsumer biConsumer,Integer i1, Integer i2)
    {
        biConsumer.accept(i2, i2);
    }
    private static Integer berechnung(Function<Integer,Integer> function, Integer i)
    {
      return  function.apply(i);
    }
    private static Integer biBerechnung(BiFunction biFunction, Integer i1, Integer i2)
    {
        return biFunction.hashCode();
    }
}
