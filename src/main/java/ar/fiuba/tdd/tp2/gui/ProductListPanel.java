package ar.fiuba.tdd.tp2.gui;

import javax.swing.*;
import java.awt.Insets;

import javax.swing.table.*;

import ar.fiuba.tdd.tp2.controller.AccessPanelListener;
import ar.fiuba.tdd.tp2.controller.AddProductDialogListener;
import ar.fiuba.tdd.tp2.controller.PaymentMethodDialog;

import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;

public class ProductListPanel extends Panel{

    public ProductListPanel(JFrame frame){
        this.window = frame;
        panel.setLayout(null);

        JLabel priceText = new JLabel("Precio total:   $0.00", SwingConstants.RIGHT);

        JLabel textTitle = new JLabel("Lista de productos");

        JButton botonCancelarCompra = new JButton("Cancelar compra");
        botonCancelarCompra.setBounds(620, 505, 150, 35);
        botonCancelarCompra.setBackground(new Color(53,131,199));
        botonCancelarCompra.setFocusPainted(false);
        botonCancelarCompra.setForeground(Color.white);

        JButton botonCerrarCompra = new JButton("Cerrar compra");
        botonCerrarCompra.setBounds(325, 505, 150, 35);
        botonCerrarCompra.setBackground(new Color(53,131,199));
        botonCerrarCompra.setFocusPainted(false);
        botonCerrarCompra.setForeground(Color.white);

        JButton botonAgregarProducto = new JButton("Agregar producto");
        botonAgregarProducto.setBounds(30, 505, 150, 35);
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
        textTitle.setBounds(30, 30, 740, 40);

        JScrollPane sp = new JScrollPane(productList);

        sp.setBounds(30, 95, 740, 360);
        sp.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(0,0,0,0), new EtchedBorder()));
        sp.getViewport().setBackground(Color.WHITE);

        priceText.setBounds(35, 460, 730, 20);

        botonAgregarProducto.addActionListener(new AddProductDialogListener(this.window, productList, priceText));
        botonAgregarProducto.setMargin(new Insets(1,1,1,1));
        botonCerrarCompra.addActionListener(new PaymentMethodDialog(this.window, productList));

        //CORREGIR PARÁMETROS
        botonCancelarCompra.addActionListener(new AccessPanelListener(this.window, new ShoppingListCashierPanel(this.window, null, null, null)));
        botonCancelarCompra.setMargin(new Insets(1,1,1,1));

        ImageIcon imagen = new ImageIcon("src/main/java/ar/fiuba/tdd/tp2/gui/data/img/rcback.png");
        JLabel background = new JLabel(imagen);
        background.setBounds(0,0,800,600);

        panel.add(textTitle);
        panel.add(priceText);
        panel.add(sp);
        panel.add(botonAgregarProducto);
        panel.add(botonCerrarCompra);
        panel.add(botonCancelarCompra);
        panel.add(background);
    }

}