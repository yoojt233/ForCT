package Programmers.연습문제.최댓값과최솟값

class Solution {
    fun solution(s: String): String {
        return s.split(" ").map { it.toInt() }.let { "${it.minOrNull()} ${it.maxOrNull()}" }
    }
}
