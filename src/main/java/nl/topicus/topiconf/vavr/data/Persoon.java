package nl.topicus.topiconf.vavr.data;

import org.hamcrest.Description;
import org.hamcrest.SelfDescribing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Persoon implements SelfDescribing
{
	private final String voornaam;

	private final String achternaam;

	private final List<Adres> adressen;

	public Persoon(String voornaam, String achternaam)
	{
		this.voornaam = voornaam;
		this.achternaam = achternaam;
		this.adressen = new ArrayList<>(0);
	}

	public Persoon(String voornaam, String achternaam, List<Adres> adressen)
	{
		this.voornaam = voornaam;
		this.achternaam = achternaam;
		this.adressen = adressen;
	}

	public String getVoornaam()
	{
		return voornaam;
	}

	public Persoon metVoornaam(String voornaam)
	{
		return new Persoon(voornaam, this.achternaam, this.adressen);
	}

	public String getAchternaam()
	{
		return achternaam;
	}

	public Persoon metAchternaam(String achternaam)
	{
		return new Persoon(this.voornaam, achternaam, this.adressen);
	}

	public List<Adres> getAdressen()
	{
		return Collections.unmodifiableList(adressen);
	}

	public Persoon metAdres(Adres adres)
	{
		List<Adres> nieuweAdressen = new ArrayList<>(adressen.size() + 1);
		nieuweAdressen.addAll(adressen);
		nieuweAdressen.add(adres);

		return new Persoon(voornaam, achternaam, nieuweAdressen);
	}

	@Override
	public void describeTo(Description description)
	{
		description.appendText("#Persoon(voornaam=")
				.appendValue(voornaam)
				.appendText(", achternaam=")
				.appendValue(achternaam)
				.appendText(", adressen=")
				.appendList("[", ", ", "]", adressen)
				.appendText(")");
	}
}
