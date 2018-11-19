package ar.fiuba.tdd.tp2;

import java.sql.Timestamp;
import java.util.*;

public class ControlTicket {

    private static ControlTicket INSTANCE;
    private List<String> LOGGER;
    private Hashtable<String, Integer> totalPaymentMethod;

    public ControlTicket() {
        this.totalPaymentMethod = new Hashtable<>();
        this.LOGGER = new ArrayList<>();
    }

    public static ControlTicket getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new ControlTicket();
        }
        return INSTANCE;
    }

    private void sumTotalByPaymentMethod(String paymentMethod, Integer total) {
        if (!this.totalPaymentMethod.containsKey(paymentMethod)) {
            this.totalPaymentMethod.put(paymentMethod, total);
            return;
        }
        Integer lastTotal = this.totalPaymentMethod.get(paymentMethod);
        this.totalPaymentMethod.put(paymentMethod, lastTotal+total);
    }

    private void logTotalByPaymentMethod() {
        Iterator it = this.totalPaymentMethod.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            this.LOGGER.add("total charged discriminated by payment method: ");
            this.LOGGER.add(pair.getKey() + ": " + pair.getValue());
            it.remove(); // avoids a ConcurrentModificationException
        }
    }

    public void logShipment(Integer total, Integer discounts, String paymentMethod) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Purchase made at: ");
        stringBuilder.append(this.getTimeStamp());
        stringBuilder.append(" - total price: ");
        stringBuilder.append(total.toString());
        stringBuilder.append(" - Discount of: ");
        stringBuilder.append(discounts.toString());
        stringBuilder.append(" - Payment method: ");
        stringBuilder.append(paymentMethod);
        this.LOGGER.add(stringBuilder.toString());
        this.sumTotalByPaymentMethod(paymentMethod, total);
    }

    public void logCashRegisterTotalCash(Integer cash) {
        this.LOGGER.add("Cash register total cash: " + cash);
    }

    public void closeCashRegister(User cashier) {
        this.logTotalByPaymentMethod();
        this.LOGGER.add("operated by " + cashier.getUsername());
        this.LOGGER.add("Close cash register at " + this.getTimeStamp());
    }

    public void openCashRegister() {
        this.LOGGER.add("Open cash register at " + this.getTimeStamp());
    }

    private String getTimeStamp() {
        return new Timestamp(System.currentTimeMillis()).toString();
    }

    public String getLoggedData() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String msg: this.LOGGER) {
            stringBuilder.append(msg + '\n');
        }
        return stringBuilder.toString();
    }

    public void reset() {
        INSTANCE = new ControlTicket();
    }
}
