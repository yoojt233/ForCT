package BaekJoon.no11286_절댓값힙

import java.util.PriorityQueue
import kotlin.math.abs

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder();

    val pq = PriorityQueue<Number>();
    val n = readLine().toInt();
    repeat(n) {
        var x = readLine().toInt();
        if (x != 0) {
            pq.add(Number(x, abs(x)));
        } else {
            sb.append(if (pq.isEmpty()) 0 else pq.poll().origin).append("\n");
        }
    }

    println(sb);
}

data class Number(
    val origin: Int,
    val absolute: Int
) : Comparable<Number> {
    override fun compareTo(other: Number): Int {
        return if (absolute == other.absolute) origin - other.origin else absolute - other.absolute;
    }
}
