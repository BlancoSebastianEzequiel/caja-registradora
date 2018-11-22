package ar.fiuba.tdd.tp2.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

import org.json.simple.parser.ParseException;

import ar.fiuba.tdd.tp2.CashRegister;
import ar.fiuba.tdd.tp2.ProductsListOffer;

public class AddProductDialogListener implements ActionListener {

    private JFrame window;
    private JTable table;
    private JLabel priceText;
    private CashRegister cashReg;

    public AddProductDialogListener(JFrame frame, JTable table, JLabel priceText, CashRegister cash){
            this.window = frame;
            this.table = table;
            this.priceText = priceText;
            this.cashReg = cash;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JDialog dialog = new JDialog();
        JPanel panelDialog = new JPanel();
        panelDialog.setLayout(null);

        JComboBox<String> products = new JComboBox<String>();
        products.setBounds(25, 50, 350, 25);

        JLabel selectProductText = new JLabel("Seleccione el producto:");
        selectProductText.setBounds(25, 20, 350, 20);

        JButton cancelButton = new  JButton("Cancelar");
        cancelButton.setBounds(265, 90, 100, 25);
        cancelButton.setBackground(new Color(53,131,199));
        cancelButton.setFocusPainted(false);
        cancelButton.setForeground(Color.white);
        cancelButton.addActionListener(new CancelAddProductListener(this.window, dialog));

        JButton addButton = new  JButton("Agregar");
        addButton.setBounds(35, 90, 100, 25);
        addButton.setBackground(new Color(53,131,199));
        addButton.setFocusPainted(false);
        addButton.setForeground(Color.white);

        ProductsListOffer productsList;
        try {
                productsList = new ProductsListOffer("products.json");
                for(int i = 0; i < productsList.getProducts().size(); i++){
                        products.addItem(productsList.getProducts().get(i).getName());
                }
                addButton.addActionListener(new AddProductListener(this.window, dialog, productsList, products, this.table, this.priceText, this.cashReg));
        } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
        } catch (ParseException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
        }

        panelDialog.add(selectProductText);
        panelDialog.add(products);
        panelDialog.add(addButton);
        panelDialog.add(cancelButton);

        dialog.addWindowListener(new DialogListener(this.window));
        dialog.setTitle("Agregar producto");
        dialog.setBounds(0, 0, 400, 170);
        dialog.setResizable(false);
        dialog.add(panelDialog);
        dialog.setLocationRelativeTo(this.window);
        
        dialog.setVisible(true);
        this.window.setEnabled(false);
	}

}