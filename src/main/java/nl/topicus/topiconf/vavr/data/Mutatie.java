package nl.topicus.topiconf.vavr.data;

import org.hamcrest.Description;
import org.hamcrest.SelfDescribing;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Mutatie implements SelfDescribing
{
	private final LocalDate mutatieDatum;

	private final BigDecimal mutatieBedrag;

	public Mutatie(LocalDate mutatieDatum, BigDecimal mutatieBedrag)
	{
		this.mutatieDatum = mutatieDatum;
		this.mutatieBedrag = mutatieBedrag;
	}

	public LocalDate getMutatieDatum()
	{
		return mutatieDatum;
	}

	public BigDecimal getMutatieBedrag()
	{
		return mutatieBedrag;
	}

	@Override public void describeTo(Description description)
	{
		description.appendText("#Mutatie(datum=")
				.appendValue(mutatieDatum)
				.appendText(", bedrag=")
				.appendValue(mutatieBedrag)
				.appendText(")");
	}
}
