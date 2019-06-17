package nl.topicus.topiconf.vavr.livecode;

import io.vavr.*;
import io.vavr.control.Option;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertTrue;

public class Demo5 {

    @Test
    public void functionPartialApply() {
        // 1. Maak een Function voor het optellen van 2 getallen
        Function2<Integer, Integer, Integer> sum = Integer::sum;

        // 2. Doe een partial apply met het getal 4
        Function1<Integer, Integer> partiallyApplied = sum.apply(4);

        // 3. Voltooi de apply met het getal 6
        Integer result = partiallyApplied.apply(6);

        // 4. Toon aan dat het resultaat 10 is
        assertThat(result, equalTo(10));

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
        unsafeDivide.apply(1, 0);
    }

    @Test
    public void liftedUnsafeFunction() {
        // 1. Maak een onveilige Function
        Function2<Integer, Integer, Integer> unsafeDivide = (a, b) -> a / b;

        // 2. Lift de function
        Function2<Integer, Integer, Option<Integer>> lifted = Function2.lift(unsafeDivide);

        // 3. Herhaal onveilige divide
        Option<Integer> divisionByZero = lifted.apply(1, 0);

        // 4. Toon aan dat er geen resultaat is
        assertTrue(divisionByZero.isEmpty());

        // 5. Laat zien dat een veilige divide wel slaagt
        assertThat(lifted.apply(4, 2).get(), equalTo(2));
    }

    @Test
    public void curriedFunction() {
        // 1. Maak een Function met veel parameters
        Function4<Integer, Integer, Integer, Integer, Integer> allBasicMath =
                (a, b, c, d) -> a * b + c / d;

        // 2. Curry de function
        Function1<Integer, Function1<Integer, Function1<Integer, Function1<Integer, Integer>>>> curried = allBasicMath.curried();

        // 3. Gebruik de curried functions
        Integer curriedApply = curried.apply(4).apply(3).apply(2).apply(1);

        // 4. Laat zien dat het resultaat identiek is aan de oorspronkelijke functie
        assertThat(curriedApply, equalTo(allBasicMath.apply(4, 3, 2, 1)));

    }

    @Test
    public void memoizedFunction() {
        // 1. Maak een logica-object uit de vorige demo
        Demo3.ComplexeLogica logica = new Demo3.ComplexeLogica();

        // 2. Maak een Function die de dure methode aanroept
        Function0<Integer> berekenSuperMoeilijkGetal = logica::berekenSuperMoeilijkGetal;

        // 3. Memoize de function
        Function0<Integer> memoized = berekenSuperMoeilijkGetal.memoized();

        // 4. Roep de memoized function meerdere keren aan
        memoized.apply();
        memoized.apply();
        memoized.apply();
        memoized.apply();
        memoized.apply();

        // 5. Toon aan dat de methode in werkelijkheid maar 1x is aangeroepen
        assertThat(logica.getAantalKeerBerekenAangeroepen(), equalTo(1));

    }
}
