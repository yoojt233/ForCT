package BaekJoon.no11279_최대힙

import java.util.PriorityQueue

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder();

    val n = readLine().toInt();
    val pq = PriorityQueue<Int>(reverseOrder());
    repeat(n) {
        var x = readLine().toInt();
        if (x != 0) {
            pq.add(x);
        } else {
            sb.append(if (pq.isEmpty()) 0 else pq.poll()).append("\n");
        }
    }

    println(sb);
}