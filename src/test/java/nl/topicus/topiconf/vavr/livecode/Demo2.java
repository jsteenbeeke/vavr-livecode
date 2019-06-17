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
		vrijwilliger1 = new Persoon("Jeroen", "Steenbeeke");
		vrijwilliger2 = new Persoon("Martijn", "Dashorst");
		vrijwilliger3 = new Persoon("Thijs", "Kupers");
	}

	@Test
	public void rejections() {
		// 1. Zet alle personen in een Array
		Array<Persoon> personen = Array.of(vrijwilliger1, vrijwilliger2, vrijwilliger3);

		// 2. Neem de voornamen van iedereen

		// 3. Reject alle Jeroens

		// 4. Controleer dat er nog 2 vrijwilligers over zijn
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
}
