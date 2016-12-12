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
            {" "," "," "," "," "," "," "," "},
            {" "," "," "," "," "," "," "," "},
            {"P","P","P","P","P","P","P","P"},
            {"R","K","B","Q","A","B","K","R"}};

    private static int cKingPositionR = 7;
    private static int cKingPositionC = 4;

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
        String list = "";

        int r2 = -1;
        for (int c2 = -1; c2 <= 1; c2++) {
            try {
                String target = board[r + r2][c + c2];
                if (Math.abs(c2) == 1
                        && Character.isLowerCase(target.charAt(0))) {
                    board[r][c] = " ";
                    if (r + r2 == 0) {
                        board[r + r2][c + c2] = "Q";
                        if (isKingSafe()) {
                            list = list + c + (c + c2) + target + "QP";
                        }
                    } else {
                        board[r + r2][c + c2] = "P";
                        if (isKingSafe()) {
                            list = list + r + c + (r + r2) + (c + c2) + target;
                        }
                    }
                    board[r][c] = "P";
                    board[r + r2][c + c2] = target;
                } else {
                    
                }
            } catch (IndexOutOfBoundsException e) {
                continue;
            }
        }

        return list;
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
        String list = "";

        for (int r2 = -1; r2 <= 1; r2++) {
            for (int c2 = -1; c2 <= 1; c2++) {
                if (r2 != 0 && c2 != 0) {
                    try {
                        String target = board[r + r2][c + (c2 * 2)];
                        if (target.equals(" ")
                                || Character.isLowerCase(target.charAt(0))) {
                            board[r][c] = " ";
                            board[r + r2][c + (c2 * 2)] = "K";
                            if (isKingSafe()) {
                                list = list + r + c + (r + r2) + (c + (c2 * 2)) + target;
                            }
                            board[r][c] = "K";
                            board[r + r2][c + (c2 * 2)] = target;
                        }
                    } catch (IndexOutOfBoundsException e) {}
                    try {
                        String target = board[r + (r2 * 2)][c + c2];
                        if (target.equals(" ")
                                || Character.isLowerCase(target.charAt(0))) {
                            board[r][c] = " ";
                            board[r + (r2 * 2)][c + c2] = "K";
                            if (isKingSafe()) {
                                list = list + r + c + (r + (r2 * 2)) + (c + c2) + target;
                            }
                            board[r][c] = "K";
                            board[r + (r2 * 2)][c + c2] = target;
                        }
                    } catch (IndexOutOfBoundsException e) {}
                }
            }
        }

        return list;
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
        for (int r = -1; r <= 1; r++) {
            for (int c = -1; c <= 1; c++) {
                if (r != 0 || c != 0) {
                    String target;
                    /* King */
                    try {
                        target = board[cKingPositionR + r][cKingPositionC + c];
                        if (target.equals("a")) {
                            return false;
                        }
                    } catch (IndexOutOfBoundsException e) {
                        continue;
                    }
                    /* Bishops, Rooks, and Queens */
                    int direction = Math.abs(r + c);
                    try {
                        int i = 1;
                        do {
                            target = board[cKingPositionR + (r * i)]
                                    [cKingPositionC + (c * i)];
                            if (direction == 1 && "qr".contains(target)) {
                                return false;
                            } else if (direction != 1 && "qb".contains(target)) {
                                return false;
                            } else {
                                i++;
                            }
                        } while (target.equals(" "));
                    } catch (IndexOutOfBoundsException e) {}
                    /* Knights */
                    if (direction != 1) {
                        try {
                            target = board[cKingPositionR + r][cKingPositionC + (c * 2)];
                            if (target.equals("k")) {
                                return false;
                            }
                        } catch (IndexOutOfBoundsException e) {
                        }
                        try {
                            target = board[cKingPositionR + (r * 2)][cKingPositionC + c];
                            if (target.equals("k")) {
                                return false;
                            }
                        } catch (IndexOutOfBoundsException e) {
                        }
                    }
                }
            }
        }
        /* Pawns */
        for (int c = -1; c <= 1; c+=2) {
            try {
                if (board[cKingPositionR - 1][cKingPositionC + c].equals("p")) {
                    return false;
                }
            } catch (IndexOutOfBoundsException e) {}
        }
        return true;
    }
}
