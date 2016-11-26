package com.johnnybot;

import javax.swing.JFrame;

/**
 * Created by kingod180 on 11/24/2016.
 */
public class AlphaBetaChess {

    private static String board[][] = {
            {"R","P"," "," "," "," ","p","r"},
            {"K","P"," "," "," "," ","p","k"},
            {"B","P"," "," "," "," ","p","b"},
            {"Q","P"," "," "," "," ","p","q"},
            {"A","P"," "," "," "," ","p","a"},
            {"B","P"," "," "," "," ","p","b"},
            {"K","P"," "," "," "," ","p","k"},
            {"R","P"," "," "," "," ","p","r"}};

    private static int cKingPositionX;
    private static int cKingPositionY;

    private static int lKingPositionX;
    private static int lKingPositionY;

    public static void main(String[] args) {
        JFrame jFrame = new JFrame("Hello Bobby Fischer!");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.add(new UserInterface());
        jFrame.setSize(500, 500);
//        jFrame.setVisible(true);
        System.out.println(possibleMoves());
    }

    public static String possibleMoves() {
        String list = "";
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[x].length; y++) {
                switch (board[x][y]) {
                    case "P":
                        list += possibleP(x, y);
                        break;
                    case "R":
                        list += possibleR(x, y);
                        break;
                    case "K":
                        list += possibleK(x, y);
                        break;
                    case "B":
                        list += possibleB(x, y);
                        break;
                    case "Q":
                        list += possibleQ(x, y);
                        break;
                    case "A":
                        list += possibleA(x, y);
                        break;
                }
            }
        }
        return list;
    }

    public static String possibleP(int x, int y) {
        return "";
    }

    public static String possibleR(int x, int y) {
        return "";
    }

    public static String possibleK(int x, int y) {
        return "";
    }

    public static String possibleB(int x, int y) {
        return "";
    }

    public static String possibleQ(int x, int y) {
        return "";
    }

    public static String possibleA(int x, int y) {
        String list = "";

        for (int x2 = -1; x2 < 2; x2++) {
            for (int y2 = -1; y2 < 2; y2++) {
                if (x2 != 0 || y2 != 0) {
                    try {
                        String target = board[x + x2][y + y2];
                        if (Character.isLowerCase(target.charAt(0))
                                || target.equals(" ")) {
                            board[x][y] = " ";
                            board[x + x2][y + y2] = "A";
                            cKingPositionX = x + x2;
                            cKingPositionY = y + y2;
                            if (isKingSafe()) {
                                list = list + x + y + (x + x2) + (y + y2) + target;
                            }
                            board[x][y] = "A";
                            board[x + x2][y + y2] = target;
                            cKingPositionX = x;
                            cKingPositionY = y;
                        }
                    } catch (IndexOutOfBoundsException e) {
                        continue;
                    }
                }
            }
        }

        return list;
    }

    public static boolean isKingSafe() {
        return true;
    }
}
