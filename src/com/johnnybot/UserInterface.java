package com.johnnybot;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * Created by kingod180 on 11/24/2016.
 */
public class UserInterface extends JPanel implements MouseListener, MouseMotionListener {

    private int x, y;

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        this.setBackground(Color.GRAY);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);

        graphics.setColor(Color.BLUE);
        graphics.fillRect(x-20, y-20, 40, 40);

        graphics.setColor(Color.BLACK);
        graphics.fillRect(40, 40, 40, 40);
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        x = e.getX();
        y = e.getY();
        repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }
}
