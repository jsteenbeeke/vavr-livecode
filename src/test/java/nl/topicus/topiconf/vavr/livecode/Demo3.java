package nl.topicus.topiconf.vavr.livecode;

import nl.topicus.topiconf.vavr.data.BankRekening;
import nl.topicus.topiconf.vavr.data.Mutatie;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

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
        // Bereken actuele balans

    }

    @Test
    public void scan() {
        // Bereken alle balansen

    }

}
