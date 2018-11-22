package ar.fiuba.tdd.tp2.gui;

import javax.swing.*;

import java.awt.Color;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

public class TicketPanel extends Panel{

    public TicketPanel(JFrame frame){
        this.window = frame;
        panel.setLayout(null);

        JLabel textTitle = new JLabel("Ticket");
        textTitle.setBounds(30, 30, 740, 40);

        JButton botonAceptar = new JButton("Aceptar");
        botonAceptar.setBounds(325, 505, 150, 35);
        botonAceptar.setBackground(new Color(53,131,199));
        botonAceptar.setFocusPainted(false);
        botonAceptar.setForeground(Color.white);

        JEditorPane textTicket = new JEditorPane();
        textTicket.setContentType("text/html");

        String data = "<h2><center>Ticket de compra</center></h2>"
        + "<br />"
        + "<center><table width=\"700\" border=\"1\"><tr><td>"
        + "<center><b>CUIT</b></center>" 
        + "</td><td>"
        + "<center><b>Razón social</b></center>"
        + "</td><td>"
        + "<center><b>Inicio de actividad</b></center>"
        + "</td><td>"
        + "<center><b>Fecha/hora</b></center>"
        + "</td></tr>"
        + "<tr><td><center>"
        + "XXXXX"
        + "</center></td><td><center>"
        + "XXXXX"
        + "</center></td><td><center>"
        + "XXXXX"
        + "</center></td><td><center>"
        + "XXXXX"
        + "</center></td></tr>"
        + "</table></center>"
        + "<br />"
        + "<h3><center>Lista de productos comprados</center></h3>"
        + "<center><table width=\"700\" border=\"1\"><tr><td>"
        + "<center><b>Cantidad</b></center>" 
        + "</td><td>"
        + "<center><b>Código</b></center>"
        + "</td><td>"
        + "<center><b>Descripción del producto</b></center>"
        + "</td><td>"
        + "<center><b>Monto</b></center>"
        + "</td></tr>"
        + "<tr><td><center>"
        + ""
        + "</center></td><td><center>"
        + ""
        + "</center></td><td><center>"
        + ""
        + "</center></td><td><center>"
        + ""
        + "</center></td></tr>"
        + "</table></center>"
        + "<br />"
        + "<h3><center>Descuentos aplicados</center></h3>"
        + "<center><table width=\"700\" border=\"1\"><tr><td>"
        + ""
        + "</td></tr></table></center>"
        + "<br />"
        + "<center><table width=\"660\"><tr>"
        + "<td><b>Total descuentos aplicados:</b></td><td>"
        + "0"
        + "</td></tr>"
        + "<tr><td><b>Total a pagar:</b></td><td>"
        + "0.00"
        + "</td></tr>"
        + "<tr><td><b>Forma de pago:</b></td><td>"
        + "UNKNOWN"
        + "</td></tr>"
        + "<tr><td><b>Total de efectivo:</b></td><td>"
        + "UNKNOWN"
        + "</td></tr>"
        + "<tr><td><b>Total cobrado por medio de pago:</b></td><td>"
        + "UNKNOWN"
        + "</td></tr></table></center>"
        + "<br />"
        + "<center><table width=\"660\"><tr>"
        + "<td><b>Nombre del cajero:</b></td><td>"
        + "UNKNOWN"
        + "</td></tr>"
        + "<tr><td><b>Fecha/hora apertura:</b></td><td>"
        + "UNKNOWN"
        + "</td></tr>"
        + "<tr><td><b>Fecha/hora cierre:</b></td><td>"
        + "UNKNOWN"
        + "</td></tr>"
        + "</table></center>";

        textTicket.setText(data);
        textTicket.setEditable(false);

        JScrollPane sp = new JScrollPane(textTicket);

        sp.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(0,0,0,0), new EtchedBorder()));
        sp.setBounds(30, 95, 740, 360);
        textTitle.setFont(textTitle.getFont().deriveFont(22.0f));

        ImageIcon imagen = new ImageIcon("src/main/java/ar/fiuba/tdd/tp2/gui/data/img/rcback.png");
        JLabel background = new JLabel(imagen);
        background.setBounds(0,0,800,600);
        
        panel.add(textTitle);
        panel.add(sp);
        panel.add(botonAceptar);
        panel.add(background);
    }

}