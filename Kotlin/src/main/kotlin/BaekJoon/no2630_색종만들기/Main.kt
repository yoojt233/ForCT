package BaekJoon.no2630_색종만들기

var white = 0;
var blue = 0;

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt();
    val paper = Array(n) { IntArray(n) { 0 } };

    repeat(n) { i ->
        paper[i] = readLine().split(" ").map { it.toInt() }.toIntArray();
    }

    divide(paper, 0, 0, n);
    print("$white\n$blue");
}

fun divide(paper: Array<IntArray>, x: Int, y: Int, n: Int) {
    if (conquer(paper, x, y, n)) {
        if (paper[x][y] == 1) ++blue; else ++white;
        return;
    }
    val len = n / 2;
    divide(paper, x, y, len);
    divide(paper, x + len, y, len);
    divide(paper, x, y + len, len);
    divide(paper, x + len, y + len, len);
}

fun conquer(paper: Array<IntArray>, x: Int, y: Int, len: Int): Boolean {
    val std = paper[x][y];
    for (i in x until x + len) {
        for (j in y until y + len) {
            if (std != paper[i][j]) return false;
        }
    }
    return true;
}