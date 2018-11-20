package ar.fiuba.tdd.tp2;

import java.util.Hashtable;
import java.util.List;
import java.util.Set;

public class PurchaseSummaryTicket {

    private List<Product> productList;
    private Hashtable<String, Double> productDiscount;
    private Hashtable<String, ProductTicket> productQuantity;

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
        String summaryTicket="Nombre del producto   Descuento Total\n";
        Double Total = 0.0;
        Set<String> keys = productQuantity.keySet();
        for(String currentProductCode : keys) {
            Double disc = addDiscount(currentProductCode);
            Total = Total +  this.productQuantity.get(currentProductCode).getPrice()*(1-disc)* this.productQuantity.get(currentProductCode).getQuantity();
            summaryTicket = summaryTicket + this.productQuantity.get(currentProductCode).getName() + " " +  this.productQuantity.get(currentProductCode).getPrice() * disc *  this.productQuantity.get(currentProductCode).getQuantity()+"\n";
        }
        summaryTicket =  summaryTicket + "Total con descuento: " + Total + "\n";
        return summaryTicket;
    }

    private String printPlainTicket (List<Product> productList){
        String summaryTicket="Codigo Nombre    Cantidad  Precio\n";
        Double subTotal = 0.0;
        checkCuantities(productList);
        Set<String> keys = productQuantity.keySet();
        for(String currentProductCode : keys) {
            subTotal = subTotal + this.productQuantity.get(currentProductCode).getPrice() * this.productQuantity.get(currentProductCode).getQuantity();
            summaryTicket = summaryTicket + this.productQuantity.get(currentProductCode).getCode()+" "+
                    this.productQuantity.get(currentProductCode).getName() + " " +
                    this.productQuantity.get(currentProductCode).getQuantity() + " " +
                    this.productQuantity.get(currentProductCode).getPrice() + "\n";
        }
        summaryTicket = summaryTicket + "Total:" + subTotal + "\n";
    return summaryTicket;
    }

    private void checkCuantities(List<Product> productList) {
        for(Product currentProduct : productList) {
            addQuantity(currentProduct);
        }
    }

    private Double addDiscount(String currentProductCode) {
        Double discount = 0.0;
        if (this.productDiscount.containsKey(currentProductCode)) {
            discount = productDiscount.get(currentProductCode);
        }
        return discount;
    }

    public void addQuantity(Product currentProduct) {
        if (!this.productQuantity.containsKey(currentProduct.getCode())) {
            ProductTicket product = new ProductTicket(currentProduct.getCode(),1, currentProduct.getName(), currentProduct.getPrice());
            this.productQuantity.put(currentProduct.getCode(), product);
        } else {
            this.productQuantity.get(currentProduct.getCode()).add();
            this.productQuantity.put(currentProduct.getCode(), this.productQuantity.get(currentProduct.getCode()));
        }

    }


}
