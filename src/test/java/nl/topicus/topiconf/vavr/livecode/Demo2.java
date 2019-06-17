package nl.topicus.topiconf.vavr.livecode;

import io.vavr.collection.Array;
import io.vavr.collection.HashSet;
import nl.topicus.topiconf.vavr.data.Adres;
import nl.topicus.topiconf.vavr.data.Persoon;
import org.junit.Before;
import org.junit.Test;

public class Demo2 extends DemoMetAdressen
{
	protected Persoon vrijwilliger1;

	protected Persoon vrijwilliger2;

	protected Persoon vrijwilliger3;

	@Before
	public void prepareVrijwilligers() {
		// Voeg 3 vrijwilligers toe
	}


	@Test
	public void filterAndReject() {
		// 1. zet alle personen in een Array
		Array<Persoon> personen = Array.of(vrijwilliger1, vrijwilliger2, vrijwilliger3);

		// 2. gebruik filter om 1 persoon te selecteren

		// 3. gebruik reject om 1 persoon te verwijderen

	}

	@Test
	public void zip() {
		// 1. zet alle personen in een Array
		Array<Persoon> personen = Array.of(vrijwilliger1, vrijwilliger2, vrijwilliger3);

		// 2. zet alle adressen in een Array
		Array<Adres> adres = Array.of(singel9, singel25, groteOverstraat29);

		// 3. gebruik zip om ze combineren

		// 4. bewijs dat elk persoon nu 1 adres heeft

	}

	@Test
	public void union_intersect_diff() {
		// 1. maak een Set van vrijwilligers 1 en 2
		HashSet<Persoon> eenEnTwee = HashSet.of(vrijwilliger1, vrijwilliger2);

		// 2. maak een Set van vrijwilligers 2 en 3
		HashSet<Persoon> tweeEnDrie = HashSet.of(vrijwilliger1, vrijwilliger2);

		// 3. demonstreer union

		// 4. demonstreer intersect

		// 5. demonstreer diff
	}
}
