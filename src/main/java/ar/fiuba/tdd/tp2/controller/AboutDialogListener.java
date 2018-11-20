package ar.fiuba.tdd.tp2.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class AboutDialogListener implements ActionListener {

    private JFrame window;

    public AboutDialogListener(JFrame frame){
            this.window = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JDialog dialog = new JDialog();
        JPanel panelDialog = new JPanel();
        panelDialog.setLayout(null);

        JLabel colaboratorsText = new JLabel("Integrantes:", SwingConstants.CENTER);
        colaboratorsText.setBounds(0, 20, 400, 20);
        JLabel colabAaText = new JLabel("Arturi, Augusto", SwingConstants.CENTER);
        colabAaText.setBounds(0, 70, 400, 20);
        JLabel colabBseText = new JLabel("Blanco, Sebastian Ezequiel", SwingConstants.CENTER);
        colabBseText.setBounds(0, 95, 400, 20);
        JLabel colabIpText = new JLabel("Inoriza, Pablo", SwingConstants.CENTER);
        colabIpText.setBounds(0, 120, 400, 20);
        JLabel colabLmText = new JLabel("Llauro, Manuel", SwingConstants.CENTER);
        colabLmText.setBounds(0, 145, 400, 20);
        JLabel tddText = new JLabel("Técnicas de Diseño - 2C 2018", SwingConstants.CENTER);
        tddText.setBounds(0, 200, 400, 20);

        panelDialog.add(colaboratorsText);
        panelDialog.add(colabAaText);
        panelDialog.add(colabBseText);
        panelDialog.add(colabIpText);
        panelDialog.add(colabLmText);
        panelDialog.add(tddText);

        panelDialog.setBackground(Color.white);

        dialog.addWindowListener(new DialogListener(this.window));
        dialog.setTitle("Acerca de RegCash");
        dialog.setBounds(0, 0, 400, 270);
        dialog.setResizable(false);
        dialog.add(panelDialog);
        dialog.setLocationRelativeTo(this.window);
        
        dialog.setVisible(true);
        this.window.setEnabled(false);
	}

}