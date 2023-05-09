package BaekJoon.no24313_알고리즘수업_점근적표기1

fun main() = with(System.`in`.bufferedReader()) {
    val (a, b) = readLine().split(" ").map { it.toInt() };
    val c = readLine().toInt();
    val n = readLine().toInt();

    print(if ((b <= (c - a) * n) && a <= c) 1 else 0);
}