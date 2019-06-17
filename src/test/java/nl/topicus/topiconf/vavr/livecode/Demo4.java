package nl.topicus.topiconf.vavr.livecode;

import io.vavr.collection.List;
import nl.topicus.topiconf.vavr.data.BankRekening;
import nl.topicus.topiconf.vavr.data.Mutatie;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class Demo4 {
    private BankRekening rekening;

    @Before
    public void prepareBankRekening() {
        rekening = new BankRekening(BigDecimal.valueOf(100), LocalDate.of(2018, 1, 1))
                .metMutatie(
                        new Mutatie(
                                LocalDate.of(2019, 1, 1),
                                BigDecimal.valueOf(250)))
                .metMutatie(
                        new Mutatie(
                                LocalDate.of(2019, 3, 20),
                                BigDecimal.valueOf(30000)))
                .metMutatie(
                        new Mutatie(
                                LocalDate.of(2018, 3, 20),
                                BigDecimal.valueOf(25000)));
    }

    @Test
    public void fold() {
        // 1. gebruik foldLeft om de actuele balans van een bankrekening te bepalen
        BigDecimal balans = rekening.getMutaties()
                .map(Mutatie::getMutatieBedrag).
                        foldLeft(rekening.getStartBalans(), BigDecimal::add);

        // 2. bewijs dat het gelijk is aan 55350
        assertThat(balans, equalTo(new BigDecimal(55350)));
    }

    @Test
    public void scan() {
        // 1. gebruik scanLeft om een lijst van balansen te bouwen
        List<BigDecimal> balansen = rekening.getMutaties()
                .map(Mutatie::getMutatieBedrag).
                        scanLeft(rekening.getStartBalans(), BigDecimal::add);

        // 2. bewijs dat deze gelijk is aan [100, 350, 30350, 55350] is
        assertThat(balansen, equalTo(List.of(new BigDecimal(100),
                new BigDecimal(350), new BigDecimal(30350), new BigDecimal(55350))));

    }

}
