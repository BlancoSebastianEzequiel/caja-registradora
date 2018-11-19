package ar.fiuba.tdd.tp2.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

public class AddProductDialogListener implements ActionListener {

    private JFrame window;
    private JTable table;
    private JLabel priceText;

    public AddProductDialogListener(JFrame frame, JTable table, JLabel priceText){
            this.window = frame;
            this.table = table;
            this.priceText = priceText;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JDialog dialog = new JDialog();
        JPanel panelDialog = new JPanel();
        panelDialog.setLayout(null);

        //Lista provisoria
        String[] prod1 = {"Coca-Cola","42.35"};
        String[] prod2 = {"Pepsi","39.20"};
        String[] prod3 = {"Queso Descremado La Serenísima","27.15"};
        ArrayList<String[]> products_list = new ArrayList<String[]>();
        products_list.add(prod1);
        products_list.add(prod2);
        products_list.add(prod3);
        //......//

        JLabel selectProductText = new JLabel("Seleccione el producto:");
        selectProductText.setBounds(25, 20, 350, 20);

        JComboBox<String> products = new JComboBox<String>();
        products.setBounds(25, 50, 350, 25);
        
        for(int i = 0; i < products_list.size(); i++){
                products.addItem(products_list.get(i)[0]);
        }

        JButton cancelButton = new  JButton("Cancelar");
        cancelButton.setBounds(265, 90, 100, 25);
        cancelButton.addActionListener(new CancelAddProductListener(this.window, dialog));

        JButton addButton = new  JButton("Agregar");
        addButton.setBounds(35, 90, 100, 25);
        addButton.addActionListener(new AddProductListener(this.window, dialog, products_list, products, this.table, this.priceText));

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