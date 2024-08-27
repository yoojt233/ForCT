package Programmers.연습문제.콜라문제

fun main() {
    val a = 3
    val b = 1
    val n = 20

    print(Solution().solution(a, b, n))
}

class Solution {
    fun solution(a: Int, b: Int, n: Int): Int {
        var res = 0
        var remain = n

        while (remain >= a) {
            val cola = (remain / a) * b

            res += cola
            remain = remain % a + cola
        }

        return res
    }
}
