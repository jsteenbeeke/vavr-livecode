package nl.topicus.topiconf.vavr.livecode;

import io.vavr.Function2;
import io.vavr.Function4;
import io.vavr.collection.HashMap;
import io.vavr.collection.Map;
import io.vavr.control.Try;
import nl.topicus.topiconf.vavr.data.Adres;
import nl.topicus.topiconf.vavr.data.Persoon;
import org.junit.Test;

import static nl.topicus.topiconf.vavr.VavrMatchers.isSuccess;
import static org.hamcrest.MatcherAssert.assertThat;

public class Demo5 extends Demo2 {


    @Test
    public void option() {

    }

    @Test
    public void map_returns_null() {


    }

    @Test
    public void try_with_unsafe_divide() {
        Function2<Integer,Integer,Integer> unsafeDivide = (a,b) -> a / b;

    }

    @Test
    public void lazy() {

    }

    @Test
    public void either() {

    }

    @Test
    public void validation() {

    }
}
