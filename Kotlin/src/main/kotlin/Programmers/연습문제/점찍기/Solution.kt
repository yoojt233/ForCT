package Programmers.연습문제.점찍기

import kotlin.math.sqrt

fun main() {
    val k = 2
    val d = 4

    print(solution(k, d))
}

fun solution(k: Int, d: Int): Long {
    val limit = d.toDouble() * d
    var res: Long = 0

    for (i in 0..(d / k)) {
        ++res

        val x = (i * k).toDouble()
        res += (sqrt(limit - (x * x)) / k).toLong()
    }

    return res
}