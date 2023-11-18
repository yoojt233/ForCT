package Programmers.정렬.가장큰수

fun main() = with(System.`in`.bufferedReader()) {
    val numbers = intArrayOf(0, 0, 0)
    print(solution(numbers))
}

fun solution(numbers: IntArray): String {
    val temp = Array(numbers.size) { i -> numbers[i].toString() }
    val sb = StringBuilder()

    temp.sortWith { a, b -> if (a.length == b.length) b.compareTo(a) else (b + a).compareTo(a + b) }
    temp.forEach { sb.append(it) }
    return if (sb[0] == '0') "0" else sb.toString()
}