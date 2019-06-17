package nl.topicus.topiconf.vavr.livecode;

import io.vavr.Function2;
import io.vavr.control.Either;
import org.junit.Test;

public class Demo3 {


    @Test
    public void option() {
        // 1. Maak een Option aan

        // 2. Bewijs dat hij gevuld is

        // 3. Filter er iets uit

        // 4. Bewijs dat hij niet meer gevuld is
    }

    @Test
    public void map_returns_null() {
        // 1. Maak een Option aan

        // 2. Voer een map uit die null oplevert

        // 3. Laat zien dat dit niet werkt

    }

    @Test
    public void tuples() {
        // 1. Maak een Tuple2 aan [J, 8]

        // 2. Voeg "ava" toe aan het linker-element

        // 3. Verhoog het rechterelement met 3

        // 4. Laat zien dat de Tuple gelijk is aan [Java, 11]


    }

    @Test
    public void try_with_unsafe_divide() {
        // 1. Maak een divide functie die delen door 0 niet uitsluit
        Function2<Integer,Integer,Integer> unsafeDivide = (a,b) -> a / b;

        // 2. Deel 4 door 2

        // 3. Toon aan dat dit werkt

        // 4. Deel 4 door 0

        // 5. Toon aan dat dit niet gewerkt heeft
    }

    @Test
    public void lazy() {
        // 1. Maak complexe logica aan
        var logica = new ComplexeLogica();

        // 2. Maak lazy object die logica aanroept

        // 3. Laat zien dat de methode niet aangeroepen is

        // 4. Evalueer lazy en controleer dat de waarde 5 is

        // 5. Laat zien dat de methode nu wel aangeroepen is

        // 6. Roep hem nog een paar keer aan

        // 7. En laat zien dat hij nog steeds maar 1x is aangeroepen
    }

    @Test
    public void either() {
        // Either wordt gebruikt om onderscheid te maken tussen failure (left) en success (right),
        // in een door de programmeur gekozen vorm.

        // 1. Maak complexe logica object aan
        var logica = new ComplexeLogica();

        // 2. Voer complexe berekening uit

        // 3. Toon aan dat dit een right (success) is

        // 4. Roep nu methode aan met ongeldige waarde

        // 5. Toon aan dat dit een left (failure) is
    }

    public static class ComplexeLogica {
        private int aantalKeerBerekenAangeroepen;

        public Integer berekenSuperMoeilijkGetal() {
            aantalKeerBerekenAangeroepen++;
            return 5;
        }

        public Either<String,Integer> bepaalQuotientVanSuperMoeilijkGetal(int deler) {
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
