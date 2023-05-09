package BaekJoon.no9663_NQueen

import kotlin.math.abs

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt();
    val row = IntArray(n);
    var ans = 0;

    fun check(x: Int, col: Int): Boolean {
        for (i in 0 until x) {
            if (row[i] == row[x] || abs(x - i) == abs(col - row[i])) return true;
        }
        return false;
    }

    fun dfs(x: Int) {
        if (x == n) {
            ++ans;
            return;
        }

        for (i in 0 until n) {
            row[x] = i;
            if (!check(x, i)) dfs(x + 1);
        }
    }

    dfs(0);
    print(ans);
}

