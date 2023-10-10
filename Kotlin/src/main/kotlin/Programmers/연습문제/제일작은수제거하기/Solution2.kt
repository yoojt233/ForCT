package Programmers.연습문제.제일작은수제거하기

fun main() = with(System.`in`.bufferedReader()) {
    fun solution(arr: IntArray): IntArray {
        return if (arr.size < 2) intArrayOf(-1) else arr.filter { it != arr.minOrNull() }.toIntArray()
    }

    val arr = intArrayOf(4, 3, 2, 1)
    solution(arr).forEach { print("$it ") }
}