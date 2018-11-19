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

public class PaymentMethodDialog implements ActionListener {

    private JFrame window;
    private JTable table;

    public PaymentMethodDialog(JFrame frame, JTable table){
            this.window = frame;
            this.table = table;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JDialog dialog = new JDialog();
        JPanel panelDialog = new JPanel();
        panelDialog.setLayout(null);

        JLabel paymentMethodText = new JLabel("Seleccione el método de pago:");
        paymentMethodText.setBounds(25, 20, 350, 20);

        JComboBox<String> paymentMethods = new JComboBox<String>();
        paymentMethods.setBounds(25, 50, 350, 25);
        paymentMethods.addItem("CASH");
        paymentMethods.addItem("DEBIT");
        paymentMethods.addItem("CREDIT");

        JButton cancelButton = new  JButton("Cancelar");
        cancelButton.setBounds(265, 90, 100, 25);
        cancelButton.addActionListener(new CancelAddProductListener(this.window, dialog));

        JButton acceptButton = new  JButton("Aceptar");
        acceptButton.setBounds(35, 90, 100, 25);
        //acceptButton.addActionListener();

        panelDialog.add(paymentMethodText);
        panelDialog.add(paymentMethods);
        panelDialog.add(acceptButton);
        panelDialog.add(cancelButton);

        dialog.addWindowListener(new DialogListener(this.window));
        dialog.setTitle("Método de pago");
        dialog.setBounds(0, 0, 400, 170);
        dialog.setResizable(false);
        dialog.add(panelDialog);
        dialog.setLocationRelativeTo(this.window);
        
        dialog.setVisible(true);
        this.window.setEnabled(false);
	}

}