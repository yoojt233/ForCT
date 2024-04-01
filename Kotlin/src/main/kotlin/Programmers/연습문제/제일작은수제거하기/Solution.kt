package Programmers.연습문제.제일작은수제거하기

fun main() = with(System.`in`.bufferedReader()) {
    fun solution(arr: IntArray): IntArray {
        if (arr.size < 2) return intArrayOf(-1)

        var mini = 0
        for (i in 1 until arr.size) {
            if (arr[i] < arr[mini]) mini = i
        }

        val res = ArrayList<Int>()
        for (i in arr.indices) {
            if (i == mini) continue
            res.add(arr[i])
        }

        return res.toIntArray()
    }

    val arr = intArrayOf(10)
    solution(arr).forEach { print("$it ") }
}