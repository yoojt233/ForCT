package Programmers.월간_코드_챌린지_시즌3.나머지가1이되는수찾기

fun main() {
    val n = 12

    print(Solution().solution(n))
}

class Solution {
    fun solution(n: Int): Int {
        var res = n - 1

        for (i in 2 until n - 1) if (n % i == 1) return i

        return res
    }
}
