package Programmers.연습문제.자릿수더하기

fun main() {
    val n = 987

    print(Solution().solution(n))
}

class Solution {
    fun solution(n: Int): Int {
        return n.toString().toCharArray().sumOf { it.digitToInt() }
    }
}
