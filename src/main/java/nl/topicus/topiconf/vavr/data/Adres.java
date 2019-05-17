package nl.topicus.topiconf.vavr.data;

import org.hamcrest.Description;
import org.hamcrest.SelfDescribing;

public class Adres implements SelfDescribing
{
	private final String straatNaam;

	private final int huisnummer;

	private final String toevoeging;

	public Adres(String straatNaam, int huisnummer)
	{
		this.straatNaam = straatNaam;
		this.huisnummer = huisnummer;
		this.toevoeging = null;
	}

	public Adres(String straatNaam, int huisnummer, String toevoeging)
	{
		this.straatNaam = straatNaam;
		this.huisnummer = huisnummer;
		this.toevoeging = toevoeging;
	}

	public String getStraatNaam()
	{
		return straatNaam;
	}

	public int getHuisnummer()
	{
		return huisnummer;
	}

	public String getToevoeging()
	{
		return toevoeging;
	}

	@Override
	public void describeTo(Description description)
	{
		description.appendText("#Adres(straatNaam=")
				.appendValue(straatNaam)
				.appendText(", huisnummer=")
				.appendValue(huisnummer);

		if (toevoeging != null)
		{
			description.appendText(", toevoeging=");
			description.appendValue(toevoeging);
		}

		description.appendText(")");
	}
}
