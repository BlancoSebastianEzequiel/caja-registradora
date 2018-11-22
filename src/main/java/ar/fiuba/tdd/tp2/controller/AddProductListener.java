package ar.fiuba.tdd.tp2.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ar.fiuba.tdd.tp2.CashRegister;
import ar.fiuba.tdd.tp2.Product;
import ar.fiuba.tdd.tp2.ProductOffer;
import ar.fiuba.tdd.tp2.ProductsListOffer;

public class AddProductListener implements ActionListener {

    private JFrame window;
    private JDialog dialog;
    private JComboBox<String> productSelected;
    private ProductsListOffer productsList;
    private JTable table;
    private JLabel priceText;
    private CashRegister cashReg;

    public AddProductListener(JFrame frame, JDialog dialog, ProductsListOffer list, JComboBox<String> productSelected, JTable table, JLabel priceText, CashRegister cash){
        this.window = frame;
        this.dialog = dialog;
        this.productSelected = productSelected;
        this.productsList = list;
        this.table = table;
        this.priceText = priceText;
        this.cashReg = cash;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        DefaultTableModel tableModel = (DefaultTableModel) this.table.getModel();

        ProductOffer product = this.productsList.getProducts().get(this.productSelected.getSelectedIndex());

        String[] rowProduct = {product.getName(), product.getCode(), String.valueOf(product.getPrice())};
        tableModel.addRow(rowProduct);
        
        float price = 0.00f;
        for(int i=0; i < table.getModel().getRowCount(); i++){
            price += Float.parseFloat((String) table.getModel().getValueAt(i, 2));
        }
        this.priceText.setText("Precio total:   $"+String.format("%.2f", price));

        this.cashReg.addItemToCurrentSale(product.getCode());

        this.dialog.dispose();
        this.window.setEnabled(true);
	}

}