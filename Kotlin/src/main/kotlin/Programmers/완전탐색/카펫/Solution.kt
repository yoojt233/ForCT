package Programmers.완전탐색.카펫

import kotlin.math.sqrt

fun main() = with(System.`in`.bufferedReader()) {
    val (brown, yellow) = readLine().split(" ").map { it.toInt() }
    solution(brown, yellow).forEach { print("$it ") }
}

fun solution(brown: Int, yellow: Int): IntArray {
    val t = (brown - 4) / 2
    val inWidth = ((t + sqrt((t * t - 4 * yellow).toDouble())) / 2).toInt()
    return intArrayOf(inWidth + 2, t - inWidth + 2)
}