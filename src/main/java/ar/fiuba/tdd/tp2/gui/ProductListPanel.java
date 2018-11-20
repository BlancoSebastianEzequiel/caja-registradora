package ar.fiuba.tdd.tp2.gui;

import javax.swing.*;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.table.*;

import ar.fiuba.tdd.tp2.controller.AddProductDialogListener;
import ar.fiuba.tdd.tp2.controller.BackButtonListener;
import ar.fiuba.tdd.tp2.controller.PaymentMethodDialog;

import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;

public class ProductListPanel extends Panel{

    public ProductListPanel(JFrame frame){
        this.window = frame;
        panel.setLayout(new GridBagLayout());
        panel.setBorder(new EmptyBorder(40,30,30,30));

        JLabel priceText = new JLabel("Precio total:   $0.00");

        JLabel textTitle = new JLabel("Lista de productos");

        JButton botonCancelarCompra = new JButton(" Cancelar compra ");
        botonCancelarCompra.setBackground(new Color(53,131,199));
        botonCancelarCompra.setFocusPainted(false);
        botonCancelarCompra.setForeground(Color.white);

        JButton botonCerrarCompra = new JButton("   Cerrar compra   ");
        botonCerrarCompra.setBackground(new Color(53,131,199));
        botonCerrarCompra.setFocusPainted(false);
        botonCerrarCompra.setForeground(Color.white);

        JButton botonAgregarProducto = new JButton("Agregar producto");
        botonAgregarProducto.setBackground(new Color(53,131,199));
        botonAgregarProducto.setFocusPainted(false);
        botonAgregarProducto.setForeground(Color.white);

        String colNames[] = {"Producto","Precio"};
        String data[][] = {};
        
        //Avoid for the table is editable
        TableModel model = new DefaultTableModel(data, colNames){

            private static final long serialVersionUID = 1L;

            public boolean isCellEditable(int row, int column){
                return false;
            }
        };

        JTable productList = new JTable(model);
        productList.setFocusable(false);
        productList.setRowHeight(30);
        productList.getTableHeader().setReorderingAllowed(false);
                
        //Center cells text
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for(int i=0; i < productList.getColumnCount(); i++){
            productList.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
            productList.getColumnModel().getColumn(i).setResizable(false);
        }

        textTitle.setFont(textTitle.getFont().deriveFont(22.0f));
        JScrollPane sp = new JScrollPane(productList);

        sp.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(30,0,5,0), new EtchedBorder()));
        sp.getViewport().setBackground(Color.WHITE);

        priceText.setBorder(new EmptyBorder(0,0,30,0));

        botonAgregarProducto.addActionListener(new AddProductDialogListener(this.window, productList, priceText));
        botonCerrarCompra.addActionListener(new PaymentMethodDialog(this.window, productList));
        botonCancelarCompra.addActionListener(new BackButtonListener(this.window, new ShoppingListCashierPanel(this.window)));

        GridBagConstraints components = new GridBagConstraints();
        components.gridx = 0;
        components.gridy = 0;
        components.gridwidth = 3;
        components.gridheight = 1;
        components.weightx = 1.0;
        components.anchor = GridBagConstraints.WEST;
        panel.add(textTitle, components);
        
        components.gridx = 0;
        components.gridy = 2;
        components.gridwidth = 3;
        components.gridheight = 1;
        components.weightx = 1.0;
        components.anchor = GridBagConstraints.EAST;
        panel.add(priceText, components);
        components.anchor = GridBagConstraints.CENTER;

        components.gridx = 0;
        components.gridy = 1;
        components.gridwidth = 3;
        components.gridheight = 1;
        components.weighty = 1.0;
        components.fill = GridBagConstraints.BOTH;
        panel.add(sp, components);
        components.weighty = 0.0;
        components.fill = GridBagConstraints.NONE;

        components.gridx = 0;
        components.gridy = 3;
        components.gridwidth = 1;
        components.gridheight = 1;
        components.anchor = GridBagConstraints.WEST;
        panel.add(botonAgregarProducto, components);

        components.gridx = 1;
        components.gridy = 3;
        components.gridwidth = 1;
        components.gridheight = 1;
        components.anchor = GridBagConstraints.CENTER;
        panel.add(botonCerrarCompra, components);

        components.gridx = 2;
        components.gridy = 3;
        components.gridwidth = 1;
        components.gridheight = 1;
        components.anchor = GridBagConstraints.EAST;
        panel.add(botonCancelarCompra, components);
    }

}