package libin.leetcode;

/**
 * Copyright (c) 2019/03/13. xixi Inc. All Rights Reserved.
 * Authors: libin <2578858653@qq.com>
 * <p>
 * Purpose : 在一个8*8的国际象棋的棋盘上，有一个白车(R)、有若干象(B)、黑卒(b)、其余是空白(.)，
 * 这个车在移动一次的情况下，能吃掉几个黑卒。
 */
public class _999_Available_Captures_for_Rook {
    public static void main(String[] args) {

    }

    public int numRookCaptures(char[][] board) {
        int xR = 0;
        int yR = 0;
        int eatPawns = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'R') {
                    xR = i;
                    yR = j;
                    break;
                }
            }
        }
        // 往左
        for (int i = xR - 1; i >= 0; i--) {
            if (board[i][yR] == 'p') {
                eatPawns++;
                break;
            }
            if (board[i][yR] == 'B') {
                break;
            }
        }
        // 往右
        for (int i = xR + 1; i < board[0].length; i++) {
            if (board[i][yR] == 'p') {
                eatPawns++;
                break;
            }
            if (board[i][yR] == 'B') {
                break;
            }
        }
        // 往上
        for (int j = yR - 1; j >= 0; j--) {
            if (board[xR][j] == 'p') {
                eatPawns++;
                break;
            }
            if (board[xR][j] == 'B') {
                break;
            }
        }
        // 往下
        for (int j = yR + 1; j < board.length; j++) {
            if (board[xR][j] == 'p') {
                eatPawns++;
                break;
            }
            if (board[xR][j] == 'B') {
                break;
            }
        }
        return eatPawns;
    }
}
