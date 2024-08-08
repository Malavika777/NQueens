package com.example.nqueens;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NQueensService {

    public List<int[][]> solveNQueens(int n) {
        List<int[][]> solutions = new ArrayList<>();
        int[][] board = new int[n][n];
        solve(board, 0, solutions);
        return solutions;
    }

    private void solve(int[][] board, int row, List<int[][]> solutions) {
        if (row == board.length) {
            solutions.add(cloneBoard(board));
            return;
        }
        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 1;
                solve(board, row + 1, solutions);
                board[row][col] = 0; // backtrack
            }
        }
    }

    private boolean isSafe(int[][] board, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 1) return false;
            if (col - (row - i) >= 0 && board[i][col - (row - i)] == 1) return false;
            if (col + (row - i) < board.length && board[i][col + (row - i)] == 1) return false;
        }
        return true;
    }

    private int[][] cloneBoard(int[][] board) {
        int[][] clone = new int[board.length][board.length];
        for (int i = 0; i < board.length; i++) {
            System.arraycopy(board[i], 0, clone[i], 0, board.length);
        }
        return clone;
    }
}
