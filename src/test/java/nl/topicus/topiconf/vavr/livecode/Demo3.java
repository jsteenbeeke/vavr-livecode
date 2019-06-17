package nl.topicus.topiconf.vavr.livecode;

import io.vavr.Function2;
import io.vavr.Lazy;
import io.vavr.Tuple;
import io.vavr.Tuple2;
import io.vavr.collection.Seq;
import io.vavr.control.Either;
import io.vavr.control.Option;
import io.vavr.control.Try;
import io.vavr.control.Validation;
import nl.topicus.topiconf.vavr.data.Persoon;
import org.junit.Test;

import static junit.framework.Assert.assertNull;
import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.instanceOf;

public class Demo3 {


    @Test
    public void option() {
        // 1. Maak een Option aan
        Option<Integer> optInt = Option.of(5);

        // 2. Bewijs dat hij gevuld is
        assertTrue(optInt.isDefined());

        // 3. Filter er iets uit
        optInt = optInt.filter(i -> i % 2 == 0);

        // 4. Bewijs dat hij niet meer gevuld is
        assertTrue(optInt.isEmpty());
    }

    @Test
    public void map_returns_null() {
        // 1. Maak een Option aan
        Option<Integer> optInt = Option.of(5);


        // 2. Voer een map uit die null oplevert
        optInt = optInt.map(i -> null);

        // 3. Laat zien dat dit niet werkt
        assertTrue(optInt.isDefined());
        assertNull(optInt.get());
    }

    @Test
    public void tuples() {
        // 1. Maak een Tuple2 aan [J, 8]
        var tuple = Tuple.of("J", 8);

        // 2. Voeg "ava" toe aan het linker-element
        tuple = tuple.map1(j -> j + "ava");

        // 3. Verhoog het rechterelement met 3
        tuple = tuple.map2(v -> v + 3);

        // 4. Laat zien dat de Tuple gelijk is aan [Java, 11]
        assertThat(tuple, equalTo(Tuple.of("Java", 11)));

    }

    @Test
    public void try_with_unsafe_divide() {
        // 1. Maak een divide functie die delen door 0 niet uitsluit
        Function2<Integer, Integer, Integer> unsafeDivide = (a, b) -> a / b;

        // 2. Deel 4 door 2
        var two = Try.of(() -> unsafeDivide.apply(4, 2));

        // 3. Toon aan dat dit werkt
        assertTrue(two.isSuccess());
        assertThat(two.get(), equalTo(2));

        // 4. Deel 4 door 0
        var infinity = Try.of(() -> unsafeDivide.apply(4, 0));

        // 5. Toon aan dat dit niet gewerkt heeft
        assertTrue(infinity.isFailure());
        assertThat(infinity.getCause(), instanceOf(ArithmeticException.class));
    }

    @Test
    public void lazy() {
        // 1. Maak complexe logica aan
        var logica = new ComplexeLogica();

        // 2. Maak lazy object die logica aanroept
        Lazy<Integer> lazyInt = Lazy.of(logica::berekenSuperMoeilijkGetal);

        // 3. Laat zien dat de methode niet aangeroepen is
        assertThat(logica.getAantalKeerBerekenAangeroepen(), equalTo(0));

        // 4. Evalueer lazy en controleer dat de waarde 5 is
        var value = lazyInt.get();
        assertThat(value, equalTo(5));

        // 5. Laat zien dat de methode nu wel aangeroepen is
        assertThat(logica.getAantalKeerBerekenAangeroepen(), equalTo(1));

        // 6. Roep hem nog een paar keer aan
        lazyInt.get();
        lazyInt.get();
        lazyInt.get();
        lazyInt.get();
        lazyInt.get();
        lazyInt.get();

        // 7. En laat zien dat hij nog steeds maar 1x is aangeroepen
        assertThat(logica.getAantalKeerBerekenAangeroepen(), equalTo(1));
    }

    @Test
    public void either() {
        // Either wordt gebruikt om onderscheid te maken tussen failure (left) en success (right),
        // in een door de programmeur gekozen vorm.

        // 1. Maak complexe logica object aan
        var logica = new ComplexeLogica();

        // 2. Voer complexe berekening uit
        Either<String, Integer> quotient = logica.bepaalQuotientVanSuperMoeilijkGetal(2);

        // 3. Toon aan dat dit een right (success) is
        assertTrue(quotient.isRight());
        assertThat(quotient.get(), equalTo(2));

        // 4. Roep nu methode aan met ongeldige waarde
        quotient = logica.bepaalQuotientVanSuperMoeilijkGetal(0);

        // 5. Toon aan dat dit een left (failure) is
        assertTrue(quotient.isLeft());
    }

    public static class ComplexeLogica {
        private int aantalKeerBerekenAangeroepen;

        public Integer berekenSuperMoeilijkGetal() {
            aantalKeerBerekenAangeroepen++;
            return 5;
        }

        public Either<String, Integer> bepaalQuotientVanSuperMoeilijkGetal(int deler) {
            if (deler == 0) {
                return Either.left("Delen door 0 is niet toegestaan");
            }

            return Either.right(berekenSuperMoeilijkGetal() / deler);
        }

        public int getAantalKeerBerekenAangeroepen() {
            return aantalKeerBerekenAangeroepen;
        }
    }


}
