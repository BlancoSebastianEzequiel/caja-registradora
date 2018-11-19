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

public class AddProductListener implements ActionListener {

    private JFrame window;
    private JDialog dialog;
    private JComboBox<String> productSelected;
    private ArrayList<String[]> list;
    private JTable table;
    private JLabel priceText;

    public AddProductListener(JFrame frame, JDialog dialog, ArrayList<String[]> list, JComboBox<String> productSelected, JTable table, JLabel priceText){
        this.window = frame;
        this.dialog = dialog;
        this.productSelected = productSelected;
        this.list = list;
        this.table = table;
        this.priceText = priceText;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        DefaultTableModel tableModel = (DefaultTableModel) this.table.getModel();
        tableModel.addRow(this.list.get(this.productSelected.getSelectedIndex()));
        
        float price = 0.00f;
        for(int i=0; i < table.getModel().getRowCount(); i++){
            price += Float.parseFloat((String) table.getModel().getValueAt(i, 1));
        }
        this.priceText.setText("Precio total:   $"+String.format("%.2f", price));

        this.dialog.dispose();
        this.window.setEnabled(true);
	}

}