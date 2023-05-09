package BaekJoon.no1011_FlymetotheAlphaCentauri

import kotlin.math.round
import kotlin.math.sqrt

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder();
    repeat(readLine().toInt()) {
        val (op, ed) = readLine().split(" ").map { it.toInt() };
        val diff = ed - op;

        if (diff <= 3) sb.append("$diff\n");
        else {
            val std = sqrt(diff.toDouble());
            val rd = round(std);
            sb.append(if (std > rd) rd.toInt() * 2 else rd.toInt() * 2 - 1).appendLine();
        }
    }
    print(sb);
}