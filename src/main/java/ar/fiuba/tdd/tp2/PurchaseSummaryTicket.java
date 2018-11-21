package ar.fiuba.tdd.tp2;

import ar.fiuba.tdd.tp2.offer_validator_client.SaleResult;

import java.util.Hashtable;
import java.util.List;
import java.util.Set;

public class PurchaseSummaryTicket {

    private List<Product> productList;
    private List<SaleResult> discounts;
    private Hashtable<String, ProductTicket> productQuantity;
    private double total;
    private double totalDiscount;

    public PurchaseSummaryTicket (List<Product> productList,  List<SaleResult> discounts){
        this.productList = productList;
        this.discounts = discounts;
        this.productQuantity = new Hashtable<>();
        this.totalDiscount = 0;
    }

    public String printTicket () {
        return printPlainTicket() + printDiscountTicket();
    }

    private String printDiscountTicket() {
        String summaryTicket="Descripcion Descuento\n";
        for(SaleResult result : this.discounts) {
            String description = result.getDescription();
            double discount = result.getDiscount();
            String offerCode = result.getOffer_code();
            this.total -= discount;
            this.totalDiscount += discount;
            summaryTicket = summaryTicket  + description + " " + offerCode + " " + discount + "\n";
        }
        summaryTicket =  summaryTicket + "Total con descuento: " + this.total + "\n";
        return summaryTicket;
    }

    private String printPlainTicket () {
        String summaryTicket = "Codigo Nombre Cantidad Precio\n";
        Double subTotal = 0.0;
        this.checkCuantities(this.productList);
        Set<String> keys = productQuantity.keySet();
        for(String currentProductCode : keys) {
            Double price = this.productQuantity.get(currentProductCode).getPrice();
            Integer quantity = this.productQuantity.get(currentProductCode).getQuantity();
            String code = this.productQuantity.get(currentProductCode).getCode();
            String name = this.productQuantity.get(currentProductCode).getName();
            subTotal += price * quantity;
            summaryTicket = summaryTicket + code + " " + name + " " + quantity + " " + price + "\n";
        }
        summaryTicket = summaryTicket + "Total: " + subTotal + "\n";
        this.total = subTotal;
        return summaryTicket;
    }

    private void checkCuantities(List<Product> productList) {
        for(Product currentProduct : productList) {
            this.addQuantity(currentProduct);
        }
    }

    public void addQuantity(Product currentProduct) {
        if (!this.productQuantity.containsKey(currentProduct.getCode())) {
            String code = currentProduct.getCode();
            String name = currentProduct.getName();
            double price = currentProduct.getPrice();
            ProductTicket product = new ProductTicket(code,1, name, price);
            this.productQuantity.put(currentProduct.getCode(), product);
        } else {
            this.productQuantity.get(currentProduct.getCode()).add();
            this.productQuantity.put(currentProduct.getCode(), this.productQuantity.get(currentProduct.getCode()));
        }

    }

    public double getTotal() {
        return this.total;
    }

    public double getTotalDiscount() {
        return this.totalDiscount;
    }
}
