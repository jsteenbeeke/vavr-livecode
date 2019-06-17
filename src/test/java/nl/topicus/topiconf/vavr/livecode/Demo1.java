package nl.topicus.topiconf.vavr.livecode;

import io.vavr.Tuple;
import io.vavr.collection.*;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertTrue;

public class Demo1  {
    @Test
    public void list() {
        // 1. maak een variabele van type List
        List<Integer> leeg = List.empty();

        // 2. voeg elementen toe
        var nietLeeg = leeg.append(7).append(12).append(1337);

        // 3. bewijs dat de elementen in de List zitten
        assertTrue(leeg.isEmpty());
        assertThat(nietLeeg.size(), equalTo(3));
    }

    @Test
    public void set() {
        // 1. maak een variabele van type HashSet
        HashSet<Integer> leeg = HashSet.empty();

        // 2. voeg elementen toe, met duplicates
        var nietLeeg = leeg.add(12).add(12).add(12).add(12).add(12).add(1337);

        // 3. bewijs dat de elementen in de Set zitten, zonder duplicates
        assertTrue(leeg.isEmpty());
        assertThat(nietLeeg.size(), equalTo(2));
    }

    @Test
    public void map() {
        // 1. maak een variabele van type HashMap
        HashMap<String, Integer> leeg = HashMap.empty();

        // 2. voeg elementen toe
        var nietLeeg = leeg.put("Java", 12).put(".NET", 5);

        // 3. bewijs dat de elementen in de Map zitten (get -> option)
        assertTrue(leeg.isEmpty());
        assertThat(nietLeeg.size(), equalTo(2));
        assertTrue(nietLeeg.contains(Tuple.of("Java", 12)));
        assertTrue(nietLeeg.contains(Tuple.of(".NET", 5)));
    }

    @Test
    public void stream() {
        // 1. maak een stream aan van alle positieve gehele getallen
        Stream<Integer> positief = Stream.from(1);

        // 2. bewijs dat een willekeurig geheel getal er in zit
        assertTrue(positief.contains(1));
        assertTrue(positief.contains(34543));
    }

    @Test
    public void javaToVavrAndBack() {
        // 1. maak een vavr collectie
        Array<Integer> vavr = Array.of(1, 2, 3);

        // 2. converteer die naar een Java collectie
        java.util.List<Integer> integers = vavr.toJavaList();

        // 3. en converteer die terug naar een vavr collectie
        Array<Integer> vavr2 = Array.ofAll(integers);

        assertThat(vavr, equalTo(vavr2));
    }
}
