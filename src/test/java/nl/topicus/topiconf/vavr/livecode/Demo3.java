package nl.topicus.topiconf.vavr.livecode;

import nl.topicus.topiconf.vavr.data.BankRekening;
import nl.topicus.topiconf.vavr.data.Mutatie;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class Demo3 {
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

        // 2. bewijs dat het gelijk is aan 55350

    }

    @Test
    public void scan() {
        // 1. gebruik scanLeft om een lijst van balansen te bouwen

        // 2. bewijs dat deze gelijk is aan [100, 350, 30350, 55350] is

    }

}
