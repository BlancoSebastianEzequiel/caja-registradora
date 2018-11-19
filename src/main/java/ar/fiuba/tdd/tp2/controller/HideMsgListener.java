package ar.fiuba.tdd.tp2.controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

public class HideMsgListener implements MouseListener, KeyListener {

    private JLabel msg;

    public HideMsgListener(JLabel msg){
        this.msg = msg;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        this.msg.setVisible(false);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        this.msg.setVisible(false);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        this.msg.setVisible(false);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
  
    }

    @Override
    public void keyTyped(KeyEvent e) {
        this.msg.setVisible(false);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        this.msg.setVisible(false);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        this.msg.setVisible(false);
	}



}