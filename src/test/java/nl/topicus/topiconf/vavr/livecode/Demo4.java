package nl.topicus.topiconf.vavr.livecode;

import io.vavr.Function2;
import io.vavr.Function4;
import io.vavr.collection.HashMap;
import io.vavr.collection.Map;
import nl.topicus.topiconf.vavr.data.Adres;
import nl.topicus.topiconf.vavr.data.Persoon;
import org.junit.Test;

public class Demo4 extends Demo2 {


    @Test
    public void tuples() {
        Map<Persoon, Adres> persoonAdressen = HashMap.of(vrijwilliger1, singel9)
                .put(vrijwilliger2, singel25)
                .put(vrijwilliger3, groteOverstraat29);

    }

    @Test
    public void functionPartialApply() {
        Function2<Integer,Integer,Integer> sum = Integer::sum;

    }

    @Test
    public void functionTupledApply() {
        Function2<Integer,Integer,Integer> sum = Integer::sum;

    }

    @Test
    public void liftedFunction() {
        Function2<Integer,Integer,Integer> unsafeDivide = (a,b) -> a / b;

    }

    @Test
    public void curriedFunction() {
        Function4<Integer,Integer,Integer,Integer,Integer> allBasicMath =
                (a,b,c,d) -> a * b + c / d;

    }

    @Test
    public void memoizedFunction() {

    }
}
