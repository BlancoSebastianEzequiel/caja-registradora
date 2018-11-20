package ar.fiuba.tdd.tp2.acceptance;

import ar.fiuba.tdd.tp2.PurchaseDate;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PurchaseDateTest {
    private PurchaseDate purchaseDate;
    private PurchaseDate expected = new PurchaseDate();

    @Before
    public void setUp() {}

    @After
    public void tearDown() {
        this.purchaseDate = null;
    }
    @Test
    public void checkProductData() {
        this.purchaseDate = new PurchaseDate();
        assertEquals("wrong year", this.expected.getYear(), this.purchaseDate.getYear());
        assertEquals("wrong month", this.expected.getMonth(), this.purchaseDate.getMonth());
        assertEquals("wrong day number", this.expected.getDayNumber(), this.purchaseDate.getDayNumber());
        assertEquals("wrong week day", this.expected.getWeekDay(), this.purchaseDate.getWeekDay());
        assertEquals("wrong week number", this.expected.getWeekNumber(), this.purchaseDate.getWeekNumber());
    }
}
