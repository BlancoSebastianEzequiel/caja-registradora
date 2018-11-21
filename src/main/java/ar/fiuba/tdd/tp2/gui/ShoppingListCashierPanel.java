package ar.fiuba.tdd.tp2.gui;

import javax.swing.*;
import javax.swing.table.*;

import ar.fiuba.tdd.tp2.CashRegister;
import ar.fiuba.tdd.tp2.controller.LogoutListener;
import ar.fiuba.tdd.tp2.controller.OpenShopListener;

import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;

public class ShoppingListCashierPanel extends Panel{

    public ShoppingListCashierPanel(JFrame frame, CashRegister cash, JTextField user, JTextField pass){
        this.window = frame;
        this.cashReg = cash;
        panel.setLayout(null);

        JLabel textTitle = new JLabel("Lista de compras");
        JButton botonDesconectar = new JButton("Desconectar");
        botonDesconectar.setBounds(620, 505, 150, 35);
        botonDesconectar.setBackground(new Color(53,131,199));
        botonDesconectar.setFocusPainted(false);
        botonDesconectar.setForeground(Color.white);
        botonDesconectar.addActionListener(new LogoutListener(this.window, this.cashReg, new LoginPanel(this.window, this.cashReg)));

        JButton botonOpenShop = new JButton("Abrir compra");
        botonOpenShop.setBounds(30, 505, 150, 35);
        botonOpenShop.setBackground(new Color(53,131,199));
        botonOpenShop.setFocusPainted(false);
        botonOpenShop.setForeground(Color.white);

        String colNames[] = {"ID de Compra","Fecha/Hora"};
        String data[][] = {};
        
        //Avoid for the table is editable
        TableModel model = new DefaultTableModel(data, colNames){

            private static final long serialVersionUID = 1L;

            public boolean isCellEditable(int row, int column){
                return false;
            }
        };

        JTable shoppingList = new JTable(model);
        shoppingList.setFocusable(false);
        shoppingList.setRowSelectionAllowed(false);
        shoppingList.setRowHeight(30);
        shoppingList.getTableHeader().setReorderingAllowed(false);
                
        //Center cells text
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for(int i=0; i < shoppingList.getColumnCount(); i++){
            shoppingList.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
            shoppingList.getColumnModel().getColumn(i).setResizable(false);
        }

        textTitle.setFont(textTitle.getFont().deriveFont(22.0f));
        textTitle.setBounds(30, 30, 740, 40);        
        
        JScrollPane sp = new JScrollPane(shoppingList);

        sp.setBounds(30, 95, 740, 360);
        sp.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(0,0,0,0), new EtchedBorder()));
        sp.getViewport().setBackground(Color.WHITE);

        botonOpenShop.addActionListener(new OpenShopListener(this.window, shoppingList));

        ImageIcon imagen = new ImageIcon("src/main/java/ar/fiuba/tdd/tp2/gui/data/img/rcback.png");
        JLabel background = new JLabel(imagen);
        background.setBounds(0,0,800,600);

        panel.add(textTitle);
        panel.add(sp);
        panel.add(botonOpenShop);
        panel.add(botonDesconectar);
        panel.add(background);
    }

}