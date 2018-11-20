package ar.fiuba.tdd.tp2;

import java.util.Hashtable;
import java.util.List;

public class PurchaseSummaryTicket {

    private List<Product> productList;
    private Hashtable<String, Double> productDiscount;
    private Hashtable<String, Integer> productQuantity;

    public PurchaseSummaryTicket (List<Product> productList, Hashtable<String, Double> productDiscount){
        this.productList = productList;
        this.productDiscount = productDiscount;
        this.productQuantity = new Hashtable<>();
    }

    public String printTicket (){
        String plainTicket = printPlainTicket(productList);
        String discountTicket = plainTicket + printDiscountTicket(productList);


    return discountTicket;

    }

    private String printDiscountTicket(List<Product> productList) {
        String summaryTicket="";
        Double Total = 0.0;
        for(Product currentProduct : productList) {
            Double disc = addDiscount(currentProduct);
            Total = Total + currentProduct.getPrice()*(1-disc);
            summaryTicket = summaryTicket + currentProduct.getName() + " " + currentProduct.getPrice() * (1-disc) + " " + productQuantity.get(currentProduct.getCode())+"\n";
        }
        summaryTicket = summaryTicket + Total + "\n";
        return summaryTicket;
    }

    private String printPlainTicket (List<Product> productList){
        String summaryTicket="";
        Double subTotal = 0.0;
        for(Product currentProduct : productList) {
            addQuantity(currentProduct);
            subTotal = subTotal + currentProduct.getPrice();
            summaryTicket = summaryTicket + currentProduct.getName() + " " + currentProduct.getPrice() + " " + productQuantity.get(currentProduct.getCode())+"\n";
        }
        summaryTicket = summaryTicket + subTotal + "\n";
    return summaryTicket;
    }
    private Double addDiscount(Product currentProduct) {
        Double discount = 0.0;
        if (this.productDiscount.containsKey(currentProduct.getCode())) {
            discount = productDiscount.get(currentProduct.getCode());
        }
        return discount;
    }

    public void addQuantity(Product currentProduct) {
        if (!this.productQuantity.containsKey(currentProduct.getCode())) {
            this.productQuantity.put(currentProduct.getCode(), 1);
        } else {
            this.productQuantity.put(currentProduct.getCode(), this.productQuantity.get(currentProduct.getCode()) + 1);
        }

    }


}
