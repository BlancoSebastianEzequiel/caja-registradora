package ar.fiuba.tdd.tp2.acceptance;

import ar.fiuba.tdd.tp2.Product;
import ar.fiuba.tdd.tp2.PurchaseSummaryTicket;
import org.json.simple.parser.ParseException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class PurchaseSummaryTicketTest {
    private List<Product> productList;
    private PurchaseSummaryTicket purchaseTicket;
    private Hashtable<String, Double> productDiscount;

    @Before
    public void setUp() throws IOException, ParseException {
        //List<Product> productList = this.items.getProducts();
        this.productList = new ArrayList<>();
        this.productList.add(new Product("products.json", "AAR001"));
        this.productList.add(new Product("products.json", "AAR001"));
        this.productList.add(new Product("products.json", "AAR003"));
        /*this.productList.add(new Product("products.json", "AAR004"));*/
        this.productDiscount = new Hashtable<>();
        this.productDiscount.put("AAR001", 0.1);
        this.purchaseTicket = new PurchaseSummaryTicket(this.productList, this.productDiscount);
    }

    @After
    public void tearDown() {

    }

    @Test
    public void checkTicketData() {
        assertEquals("Codigo Nombre    Cantidad  Precio\n" +
                "AAR003 Gaseosa Cola 1 14.4\n" +
                "AAR001 Leche Descremada 1L, la Calmisima 2 25.4\n" +
                "Total:65.2\n" +
                "Nombre del producto   Descuento Total\n"+
                "Gaseosa Cola 0.0\n" +
                "Leche Descremada 1L, la Calmisima 5.08\n" +
                "Total con descuento: 60.12\n" 
                , purchaseTicket.printTicket());

    }
}



