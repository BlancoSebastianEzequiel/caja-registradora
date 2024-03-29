package ar.fiuba.tdd.tp2;

import ar.fiuba.tdd.tp2.offer_validator_client.SaleResult;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.List;

public class Sale {

    private Items items;
    private PurchaseSummaryTicket purchaseSummaryTicket;
    private Adapter adapter;
    private PurchaseDate purchaseDate;


    Sale(Adapter adapter) {
        this.adapter = adapter;
        this.items = new Items();
        this.purchaseDate = new PurchaseDate();
    }

    public void finishSale(String method, String bank) {
        try {
            List<Product> products = this.items.getProducts();
            List<SaleResult> result = this.adapter.getDiscount(products, this.purchaseDate, method, bank);
            this.purchaseSummaryTicket = new PurchaseSummaryTicket(products, result, this.purchaseDate);
            ControlTicket.getInstance().logShipment(this.getTotal(), this.getTotalDiscount(), method);
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

    public double getTotal() {
        return this.purchaseSummaryTicket.getTotal();
    }

    public double getTotalDiscount() {
        return this.purchaseSummaryTicket.getTotalDiscount();
    }
}
