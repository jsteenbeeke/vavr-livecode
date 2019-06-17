package nl.topicus.topiconf.vavr.livecode;

import io.vavr.Function2;
import io.vavr.Function4;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class Demo5 {

    @Test
    public void functionPartialApply() {
        // 1. Maak een Function voor het optellen van 2 getallen
        Function2<Integer, Integer, Integer> sum = Integer::sum;

        // 2. Doe een partial apply met het getal 4

        // 3. Voltooi de apply met het getal 6

        // 4. Toon aan dat het resultaat 10 is

    }

    @Test
    public void functionTupledApply() {
        // 1. Maak een Function voor het optellen van 2 getallen
        Function2<Integer, Integer, Integer> sum = Integer::sum;

        // 2. Apply de tuple [4,6]

        // 3. Toon aan dat het resultaat 10 is
    }

    @Test(expected = ArithmeticException.class)
    public void unsafeFunction() {
        // 1. Maak een onveilige Function
        Function2<Integer, Integer, Integer> unsafeDivide = (a, b) -> a / b;

        // 2. Laat deze falen
    }

    @Test
    public void liftedUnsafeFunction() {
        // 1. Maak een onveilige Function
        Function2<Integer, Integer, Integer> unsafeDivide = (a, b) -> a / b;

        // 2. Lift de function

        // 3. Herhaal onveilige divide

        // 4. Toon aan dat er geen resultaat is

        // 5. Laat zien dat een veilige divide wel slaagt
    }

    @Test
    public void curriedFunction() {
        // 1. Maak een Function met veel parameters
        Function4<Integer, Integer, Integer, Integer, Integer> allBasicMath =
                (a, b, c, d) -> a * b + c / d;

        // 2. Curry de function

        // 3. Gebruik de curried functions

        // 4. Laat zien dat het resultaat identiek is aan de oorspronkelijke functie

    }

    @Test
    public void memoizedFunction() {
        // 1. Maak een logica-object uit de vorige demo
        Demo3.ComplexeLogica logica = new Demo3.ComplexeLogica();

        // 2. Maak een Function die de dure methode aanroept

        // 3. Memoize de function

        // 4. Roep de memoized function meerdere keren aan

        // 5. Toon aan dat de methode in werkelijkheid maar 1x is aangeroepen

    }
}
