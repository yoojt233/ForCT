package Programmers.가장큰정사각형찾기;

class Solution {
    public int solution(int[][] board) {
        int row = board.length;
        int col = board[0].length;
        int res = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 0) continue;

                board[i][j] = (i * j == 0) ? 1 : Math.min(board[i - 1][j - 1], Math.min(board[i - 1][j], board[i][j - 1])) + 1;
                res = Math.max(res, board[i][j]);
            }
        }

        return res * res;
    }
}
