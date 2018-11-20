package ar.fiuba.tdd.tp2.gui;

import javax.swing.*;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.table.*;

import ar.fiuba.tdd.tp2.controller.BackButtonListener;
import ar.fiuba.tdd.tp2.controller.OpenBoxListener;

import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;

public class ShoppingListSupervisorPanel extends Panel{

    public ShoppingListSupervisorPanel(JFrame frame, Boolean boxOpen){
        this.window = frame;
        panel.setLayout(new GridBagLayout());
        panel.setBorder(new EmptyBorder(40,30,30,30));

        JLabel textTitle = new JLabel("Estado de caja");
        JButton botonVolver = new JButton("   Volver   ");
        botonVolver.setBackground(new Color(53,131,199));
        botonVolver.setFocusPainted(false);
        botonVolver.setForeground(Color.white);

        JButton botonVerTicket = new JButton("Ver ticket");
        botonVerTicket.setBackground(new Color(53,131,199));
        botonVerTicket.setFocusPainted(false);
        botonVerTicket.setForeground(Color.white);

        JToggleButton botonOpenBox = new JToggleButton();
        botonOpenBox.setForeground(Color.white);
        if(!boxOpen){
            botonOpenBox.setBackground(new Color(160,40,40));
            botonOpenBox.setText("Cerrada");
        } else {
            botonOpenBox.setBackground(new Color(41,183,117));
            botonOpenBox.setText("Abierta");
        }
        botonOpenBox.addActionListener(new OpenBoxListener(this.window));

        String colNames[] = {"ID de Compra","Fecha/Hora","Estado"};
        String data[][] = {};

        botonVolver.addActionListener(new BackButtonListener(this.window, new LoginPanel(this.window)));
        botonVerTicket.addActionListener(new BackButtonListener(this.window, new TicketPanel(this.window)));

        //Avoid for the table is editable
        TableModel model = new DefaultTableModel(data, colNames){

            private static final long serialVersionUID = 1L;

            public boolean isCellEditable(int row, int column){
                return false;
            }
        };

        JTable shoppingList = new JTable(model);
        shoppingList.setFocusable(false);
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
        JScrollPane sp = new JScrollPane(shoppingList);

        sp.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(30,0,40,0), new EtchedBorder()));
        sp.getViewport().setBackground(Color.WHITE);

        GridBagConstraints components = new GridBagConstraints();
        components.gridx = 0;
        components.gridy = 0;
        components.gridwidth = 3;
        components.gridheight = 1;
        components.weightx = 1.0;
        components.anchor = GridBagConstraints.WEST;
        panel.add(textTitle, components);
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
        components.gridy = 2;
        components.gridwidth = 1;
        components.gridheight = 1;
        components.anchor = GridBagConstraints.WEST;
        panel.add(botonOpenBox, components);

        components.gridx = 1;
        components.gridy = 2;
        components.gridwidth = 1;
        components.gridheight = 1;
        components.anchor = GridBagConstraints.CENTER;
        panel.add(botonVerTicket, components);

        components.gridx = 2;
        components.gridy = 2;
        components.gridwidth = 1;
        components.gridheight = 1;
        components.anchor = GridBagConstraints.EAST;
        panel.add(botonVolver, components);
    }

}