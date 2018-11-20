package ar.fiuba.tdd.tp2;

import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.*;

class Items {
    private Hashtable<String, Integer> items;

    Items() {
        this.items = new Hashtable<>();
    }

    void addItem(String item) {
        this.items.get(item);
        if (!this.items.containsKey(item)) {
            this.items.put(item, 1);
            return;
        }
        this.items.put(item, this.items.get(item) + 1);
    }

    public List<Product> getProducts() throws IOException, ParseException {
        List<Product> products = new ArrayList<>();
        Iterator it = this.items.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            int max = (int) pair.getValue();
            String code = (String) pair.getKey();
            for (int i = 0; i < max; i++) {
                products.add(new Product("products.json", code));
            }
            it.remove(); // avoids a ConcurrentModificationException
        }
        return products;
    }


}
