package nl.topicus.topiconf.vavr.data;

import io.vavr.collection.List;
import org.hamcrest.Description;
import org.hamcrest.SelfDescribing;

import java.math.BigDecimal;
import java.time.LocalDate;

public class BankRekening implements SelfDescribing {
    private final BigDecimal startBalans;

    private final LocalDate startDatum;

    private final List<Mutatie> mutaties;

    public BankRekening(BigDecimal startBalans, LocalDate startDatum) {
        this.startBalans = startBalans;
        this.startDatum = startDatum;
        this.mutaties = List.empty();
    }

    private BankRekening(BigDecimal startBalans, LocalDate startDatum, List<Mutatie> mutaties) {
        this.startBalans = startBalans;
        this.startDatum = startDatum;
        this.mutaties = mutaties;
    }

    public BigDecimal getStartBalans() {
        return startBalans;
    }

    public LocalDate getStartDatum() {
        return startDatum;
    }

    public List<Mutatie> getMutaties() {
        return mutaties;
    }

    public BankRekening metMutatie(Mutatie mutatie) {
        return new BankRekening(startBalans, startDatum, mutaties.append(mutatie));
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("#BankRekening(startBalans=")
                .appendValue(startBalans)
                .appendText(", startDatum=")
                .appendValue(startDatum)
                .appendText(", mutaties=")
                .appendList("[", ",", "]", mutaties)
                .appendText(")");
    }
}
