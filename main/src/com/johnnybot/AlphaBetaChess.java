package com.johnnybot;

import javax.swing.JFrame;

/**
 * Created by kingod180 on 11/24/2016.
 */
public class AlphaBetaChess {

    private static String board[][] = {
            {"r","k","b","q","a","b","k","r"},
            {"p","p","p","p","p","p","p","p"},
            {" "," "," "," "," "," "," "," "},
            {" "," "," "," "," "," "," "," "},
            {"P"," "," "," "," "," "," "," "},
            {" "," ","K"," "," "," "," "," "},
            {" ","P","P","P","P","P","P","P"},
            {"R"," ","B","Q","A","B","K","R"}};

    private static int cKingPositionR;
    private static int cKingPositionC;

    private static int lKingPositionR;
    private static int lKingPositionC;

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
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                switch (board[r][c]) {
                    case "P":
                        list += possibleP(r, c);
                        break;
                    case "R":
                        list += possibleR(r, c);
                        break;
                    case "K":
                        list += possibleK(r, c);
                        break;
                    case "B":
                        list += possibleB(r, c);
                        break;
                    case "Q":
                        list += possibleQ(r, c);
                        break;
                    case "A":
                        list += possibleA(r, c);
                        break;
                }
            }
        }
        return list;
    }

    public static String possibleP(int r, int c) {
        return "";
    }

    public static String possibleR(int r, int c) {
        String list = "";

        for (int r2 = -1; r2 <= 1; r2++) {
            for (int c2 = -1; c2 <= 1; c2++) {
                if (r2 == 0 ^ c2 == 0) {
                    try {
                        int i = 1;
                        String target = board[r + (r2 * i)][c + (c2 * i)];
                        while (target.equals(" ")
                                || Character.isLowerCase(target.charAt(0))) {
                            board[r][c] = " ";
                            board[r + (r2 * i)][c + (c2 * i)] = "R";
                            if (isKingSafe()) {
                                list = list + r + c + (r + (r2 * i)) + (c + (c2 * i)) + target;
                            }
                            board[r][c] = "R";
                            board[r + (r2 * i)][c + (c2 * i)] = target;

                            if (Character.isLowerCase(target.charAt(0))) {
                                break;
                            } else {
                                i++;
                                target = board[r + (r2 * i)][c + (c2 * i)];
                            }
                        }
                    } catch (IndexOutOfBoundsException e) {
                        continue;
                    }
                }
            }
        }

        return list;
    }

    public static String possibleK(int r, int c) {
        return "";
    }

    public static String possibleB(int r, int c) {
        String list = "";

        for (int r2 = -1; r2 <= 1; r2++) {
            for (int c2 = -1; c2 <= 1; c2++) {
                if (r2 != 0 && c2 != 0) {
                    try {
                        int i = 1;
                        String target = board[r + (r2 * i)][c + (c2 * i)];
                        while (target.equals(" ")
                                || Character.isLowerCase(target.charAt(0))) {
                            board[r][c] = " ";
                            board[r + (r2 * i)][c + (c2 * i)] = "B";
                            if (isKingSafe()) {
                                list = list + r + c + (r + (r2 * i)) + (c + (c2 * i)) + target;
                            }
                            board[r][c] = "B";
                            board[r + (r2 * i)][c + (c2 * i)] = target;

                            if (Character.isLowerCase(target.charAt(0))) {
                                break;
                            } else {
                                i++;
                                target = board[r + (r2 * i)][c + (c2 * i)];
                            }
                        }
                    } catch (IndexOutOfBoundsException e) {
                        continue;
                    }
                }
            }
        }

        return list;
    }

    public static String possibleQ(int r, int c) {
        String list = "";

        for (int r2 = -1; r2 <= 1; r2++) {
            for (int c2 = -1; c2 <= 1; c2++) {
                if (r2 != 0 || c2 != 0) {
                    try {
                        int i = 1;
                        String target = board[r + (r2 * i)][c + (c2 * i)];
                        while (target.equals(" ")
                                || Character.isLowerCase(target.charAt(0))) {
                            board[r][c] = " ";
                            board[r + (r2 * i)][c + (c2 * i)] = "Q";
                            if (isKingSafe()) {
                                list = list + r + c + (r + (r2 * i)) + (c + (c2 * i)) + target;
                            }
                            board[r][c] = "Q";
                            board[r + (r2 * i)][c + (c2 * i)] = target;

                            if (Character.isLowerCase(target.charAt(0))) {
                                break;
                            } else {
                                i++;
                                target = board[r + (r2 * i)][c + (c2 * i)];
                            }
                        }
                    } catch (IndexOutOfBoundsException e) {
                        continue;
                    }
                }
            }
        }

        return list;
    }

    public static String possibleA(int r, int c) {
        String list = "";

        for (int r2 = -1; r2 <= 1; r2++) {
            for (int c2 = -1; c2 <= 1; c2++) {
                if (r2 != 0 || c2 != 0) {
                    try {
                        String target = board[r + r2][c + c2];
                        if (Character.isLowerCase(target.charAt(0))
                                || target.equals(" ")) {
                            board[r][c] = " ";
                            board[r + r2][c + c2] = "A";
                            cKingPositionR = r + r2;
                            cKingPositionC = c + c2;
                            if (isKingSafe()) {
                                list = list + r + c + (r + r2) + (c + c2) + target;
                            }
                            board[r][c] = "A";
                            board[r + r2][c + c2] = target;
                            cKingPositionR = r;
                            cKingPositionC = c;
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
