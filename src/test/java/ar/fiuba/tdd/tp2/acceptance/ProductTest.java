package ar.fiuba.tdd.tp2.acceptance;

import ar.fiuba.tdd.tp2.*;
import org.json.simple.parser.ParseException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

public class ProductTest {

    private Product product;

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
        this.product = null;
    }
    @Test
    public void checkProductData() throws IOException, ParseException {
        this.product = new Product("products.json", "AAR001");
        assertEquals("wrong name", "Leche Descremada 1L, la Calmisima", this.product.getName());
        assertEquals("wrong brand code", "Z001ABC", this.product.getBrandCode());
        assertEquals("wrong brand name", "La Calmisima", this.product.getBrandName());
        assertEquals("wrong category code", "X033AXX", this.product.getCategoryCode());
        assertEquals("wrong category code", "Lacteo", this.product.getCategoryName());
        assertEquals("wrong price", 25.40, this.product.getPrice(), 0.0);
        assertEquals("wrong iva percentage", 10.5, this.product.getIvaPorcentage(), 0.0);
    }
}
