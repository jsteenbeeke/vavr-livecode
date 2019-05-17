package nl.topicus.topiconf.vavr.livecode;

import nl.topicus.topiconf.vavr.data.Adres;
import org.junit.Before;

public abstract class DemoMetAdressen
{
    protected Adres singel9;

    protected Adres singel25;

    protected Adres groteOverstraat29;

	@Before
	public void maakAdressen() {
		singel9 = new Adres("Singel", 9);
		singel25 = new Adres("Singel", 25);
		groteOverstraat29 = new Adres("Grote Overstraat", 29);
	}
}
