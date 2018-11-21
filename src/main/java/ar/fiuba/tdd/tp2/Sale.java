package ar.fiuba.tdd.tp2;

import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.List;

public class Sale {

    private Items items;
    private PurchaseSummaryTicket purchaseSummaryTicket;

    Sale() {
        this.items = new Items();
    }

    public void finishSale() throws IOException, ParseException {
        // List<Product> products = this.items.getProducts();
        // PurchaseDate purchaseDate = new PurchaseDate();
        // TODO: call API REST clojure and call purchase summary ticket
        // ProcessSale process_sale = new ProcessSale("hols", sale);
        // controller.processSale(process_sale);
        // this.purchaseSummaryTicket = new PurchaseSummaryTicket(products, productDiscount);
    }

    void addItem(String item) {
        this.items.addItem(item);
    }

    public String getSummaryTicket() {
        if (this.purchaseSummaryTicket == null) {
            return "";
        }
        return this.purchaseSummaryTicket.printTicket();
    }
}
