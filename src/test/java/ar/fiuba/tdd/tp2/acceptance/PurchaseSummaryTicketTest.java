package ar.fiuba.tdd.tp2.acceptance;

import ar.fiuba.tdd.tp2.Product;
import ar.fiuba.tdd.tp2.PurchaseDate;
import ar.fiuba.tdd.tp2.PurchaseSummaryTicket;
import ar.fiuba.tdd.tp2.offer_validator_client.SaleResult;
import org.json.simple.parser.ParseException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertTrue;


public class PurchaseSummaryTicketTest {
    private List<Product> productList;
    private PurchaseSummaryTicket purchaseTicket;
    private List<SaleResult> discounts;
    private PurchaseDate purchaseDate;

    @Before
    public void setUp() throws IOException, ParseException {
        this.productList = new ArrayList<>();
        this.productList.add(new Product("products.json", "AAR001"));
        this.productList.add(new Product("products.json", "AAR001"));
        this.productList.add(new Product("products.json", "AAR003"));
        this.discounts = new ArrayList<>();
        this.discounts.add(new SaleResult("description1", "offerCode1", 10));
        this.discounts.add(new SaleResult("description2", "offerCode2", 10));
        this.discounts.add(new SaleResult("description3", "offerCode3", 10));
        this.purchaseDate = new PurchaseDate();
        this.purchaseTicket = new PurchaseSummaryTicket(this.productList, this.discounts, this.purchaseDate);
    }

    @After
    public void tearDown() {}

    @Test
    public void checkTicketData() {
        String expected =
                "Cuit: 30-52552504-6 razon social: Telecom inicio de actividad: " +
                this.purchaseDate.getDayNumber() +
                " de " + this.purchaseDate.getMonth() +
                " de " + this.purchaseDate.getYear() + "\n" +
                "Codigo Nombre Cantidad Precio\n" +
                "AAR003 Gaseosa Cola 1 14.4\n" +
                "AAR001 Leche Descremada 1L, la Calmisima 2 25.4\n" +
                "Total: 65.2\n" +
                "Descripcion codigoOferta Descuento\n" +
                "description1 offerCode1 10.0\n"+
                "description2 offerCode2 10.0\n" +
                "description3 offerCode3 10.0\n" +
                "Total con descuento: 35.2\n";
        String actual = purchaseTicket.printTicket();
        assertTrue(actual.equals(expected));

    }
}



