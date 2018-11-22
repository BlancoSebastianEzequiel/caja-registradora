package ar.fiuba.tdd.tp2.gui;

import java.io.IOException;

import javax.swing.*;

import org.json.simple.parser.ParseException;

import ar.fiuba.tdd.tp2.CashRegister;

public class StartGui {

    private JFrame window = new JFrame();
    
    //Inicializar la ventana de la Gui
    public StartGui(){
        window.setTitle("RegCash - BETA");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(800,600);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
    }

    //Actualizar pantalla
    public void refreshScreen(){
        window.setVisible(true);
    }

    public JFrame getFrame() {
        return window;
    }

    public static void main(String[] args) throws IOException, ParseException{
        StartGui gui = new StartGui();
        CashRegister cashReg = new CashRegister("users.json", "offers.json", "rules.json");
        Panel login = new LoginPanel(gui.getFrame(), cashReg);

        gui.getFrame().getContentPane().add(login.getPanel());
        gui.refreshScreen();
    }

}