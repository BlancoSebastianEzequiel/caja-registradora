package ar.fiuba.tdd.tp2;

import ar.fiuba.tdd.tp2.offer_validator_client.SaleResult;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.List;

public class Sale {

    private Items items;
    private PurchaseSummaryTicket purchaseSummaryTicket;
    private Adapter adapter;


    Sale(Adapter adapter) {
        this.adapter = adapter;
        this.items = new Items();
    }

    public void finishSale() {
        try {
            List<Product> products = this.items.getProducts();
            PurchaseDate purchaseDate = new PurchaseDate();
            List<SaleResult> result = this.adapter.getDiscount(products, purchaseDate);
            this.purchaseSummaryTicket = new PurchaseSummaryTicket(products, result);
        } catch (IOException | ParseException | InterruptedException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    void addItem(String item) {
        this.items.addItem(item);
    }

    public String getSummaryTicket() {
        if (this.purchaseSummaryTicket == null) {
            return "Sorry!: We do not have a summary ticket";
        }
        return this.purchaseSummaryTicket.printTicket();
    }
}
