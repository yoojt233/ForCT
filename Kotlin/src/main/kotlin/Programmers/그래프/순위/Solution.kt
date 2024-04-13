package Programmers.그래프.순위

fun main() {
    val n = 5
    val results = arrayOf(intArrayOf(4, 3), intArrayOf(4, 2), intArrayOf(3, 2), intArrayOf(1, 2), intArrayOf(2, 5))

    fun solution(n: Int, results: Array<IntArray>): Int {
        val players = Array(n) { IntArray(n) }
        for (result in results) {
            players[result[0] - 1][result[1] - 1] = 1
            players[result[1] - 1][result[0] - 1] = -1
        }

        for (k in 0 until n) {
            for (i in 0 until n) {
                for (j in 0 until n) {
                    if (players[i][k] != 0 && players[i][k] == players[k][j])
                        players[i][j] = players[i][k]
                }
            }
        }

        var ans = 0
        for (i in 0 until n) {
            var flag = true
            for (j in 0 until n) {
                if (i == j) continue
                if (players[i][j] == 0 || players[j][i] == 0) {
                    flag = false
                    break
                }
            }
            if (flag) ++ans
        }

        return ans
    }

    print(solution(n, results))
}