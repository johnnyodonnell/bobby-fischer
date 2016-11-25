package com.johnnybot;

import javax.swing.JFrame;

/**
 * Created by kingod180 on 11/24/2016.
 */
public class AlphaBetaChess {

    public static void main(String[] args) {
        JFrame jFrame = new JFrame("Hello Bobby Fischer!");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.add(new UserInterface());
        jFrame.setSize(500, 500);
        jFrame.setVisible(true);
    }
}
