package ar.fiuba.tdd.tp2.acceptance;

import ar.fiuba.tdd.tp2.ProductOffer;
import ar.fiuba.tdd.tp2.ProductsListOffer;
import org.json.simple.parser.ParseException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import static org.junit.Assert.assertTrue;

public class ProductListOfferTest {

    private ProductsListOffer products;

    @Before
    public void setUp() {}

    @After
    public void tearDown() {
        this.products = null;
    }

    @Test
    public void checkProductData() throws IOException, ParseException {
        this.products = new ProductsListOffer("products.json");
        int i = 1;
        String code = "AAR00";
        for(ProductOffer aProduct: this.products.getProducts()) {
            assertTrue("wrong code", aProduct.getCode().equals(code + i));
            i++;
        }
    }
}
