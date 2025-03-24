package Programmers.프로그래머스_코드챌린지_2차_예선_2025.서버증설횟수

fun main() {
    val players = intArrayOf(0, 0, 0, 0, 0, 2, 0, 0, 0, 1, 0, 5, 0, 2, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1)
    val m = 1
    val k = 1

    print(Solution().solution(players, m, k))
}

class Solution {
    fun solution(players: IntArray, m: Int, k: Int): Int {
        val end = IntArray(24 + k + 1)

        var cur = 0
        var cnt = 0

        for (i in players.indices) {
            cur -= end[i]

            val need = players[i] / m

            if (cur < need) {
                val temp = need - cur

                cnt += temp
                end[i + k] = temp
                cur = need
            }
        }

        return cnt
    }
}
