package BaekJoon.no2149_암호해독

import java.util.PriorityQueue

fun main() = with(System.`in`.bufferedReader()) {
    val pwd = readLine();
    val sentence = readLine();

    val len = pwd.length;
    val size = sentence.length / len;
    val board = Array(size) { CharArray(len) }

    for (i in 0 until len) {
        for (j in 0 until size) board[j][i] = sentence[i * size + j]
    }

    val pq = PriorityQueue(Comparator<Pair<Char, Int>> { a, b ->
        when {
            a.first != b.first -> a.first - b.first
            else -> a.second - b.second
        }
    });

    for (i in 0 until len) pq.add(Pair(pwd[i], i));

    val order = IntArray(len);
    for (i in 0 until len) order[pq.poll().second] = i;

    val sb = StringBuilder();
    for (i in 0 until size) {
        for (j in 0 until len) {
            val where = order[j];
            sb.append(board[i][where]);
        }
    }
    print(sb);
}
