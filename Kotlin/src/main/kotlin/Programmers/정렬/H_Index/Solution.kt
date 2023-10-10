package Programmers.정렬.H_Index

import kotlin.math.min

fun main() = with(System.`in`.bufferedReader()) {
    fun solution(citations: IntArray): Int {
        citations.sort()

        var res = 0
        for (i in citations.indices) {
            val h = min(citations.size - i, citations[i])
            if (h < res) break
            res = h
        }

        return res
    }

    val citations = intArrayOf(3, 0, 6, 1, 5)
    print(solution(citations))
}