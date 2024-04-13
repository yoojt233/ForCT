package Programmers.KAKAO_BLIND_RECRUITMENT_2020.기둥과보설치

fun main() {
    val n = 5
    val build_frame = arrayOf(
        intArrayOf(0, 0, 0, 1),
        intArrayOf(2, 0, 0, 1),
        intArrayOf(4, 0, 0, 1),
        intArrayOf(0, 1, 1, 1),
        intArrayOf(1, 1, 1, 1),
        intArrayOf(2, 1, 1, 1),
        intArrayOf(3, 1, 1, 1),
        intArrayOf(2, 0, 0, 0),
        intArrayOf(1, 1, 1, 0),
        intArrayOf(2, 2, 0, 1),
    )

    val ans = Solution().solution(n, build_frame)
    ans.forEach { i ->
        i.forEach { print("$it ") }
        println()
    }
}

class Solution {
    lateinit var board: Array<Array<BooleanArray>>
    var total = 0

    fun check(n: Int, r: Int, c: Int, kind: Int): Boolean {
        var res = false

        if (kind == 0) {
            if (c == 0 || (c - 1 >= 0 && board[r][c - 1][0]) || (r - 1 >= 0 && board[r - 1][c][1]) || (r + 1 < n + 1 && board[r][c][1]))
                res = true
        } else {
            if ((r - 1 >= 0 && r + 2 < n + 1 && board[r - 1][c][1] && board[r + 1][c][1]) || (c - 1 >= 0 && board[r][c - 1][0]) || (c - 1 >= 0 && board[r + 1][c - 1][0]))
                res = true
        }

        return res
    }

    fun solution(n: Int, build_frame: Array<IntArray>): Array<IntArray> {
        board = Array(n + 1) { Array(n + 1) { BooleanArray(2) } }

        for (cmd in build_frame) {
            val r = cmd[0]
            val c = cmd[1]
            val kind = cmd[2]

            if (cmd[3] == 0) {
                var flag = true

                board[r][c][kind] = false
                if (kind == 0) {
                    if (
                        (r - 1 >= 0 && board[r - 1][c + 1][1] && !check(n, r - 1, c + 1, 1))
                        || (r + 1 < n + 1 && board[r][c + 1][1] && !check(n, r, c + 1, 1))
                        || (c + 2 < n + 1 && board[r][c + 1][0] && !check(n, r, c + 1, 0))
                    ) flag = false
                } else {
                    if (
                        (c + 1 < n + 1 && board[r][c][0] && !check(n, r, c, 0))
                        || (c + 1 < n + 1 && board[r + 1][c][0] && !check(n, r + 1, c, 0))
                        || (r - 1 >= 0 && board[r - 1][c][1] && !check(n, r - 1, c, 1))
                        || (r + 2 < n + 1 && board[r + 1][c][1] && !check(n, r + 1, c, 1))
                    ) flag = false
                }

                if (flag) --total else board[r][c][kind] = true
            } else {
                if (check(n, r, c, kind)) {
                    board[r][c][kind] = true
                    ++total
                }
            }
        }

        val res = Array(total) { IntArray(3) }
        var temp = 0

        for (i in 0 until n + 1) {
            for (j in 0 until n + 1) {
                for (k in 0 until 2) {
                    if (board[i][j][k]) {
                        res[temp][0] = i
                        res[temp][1] = j
                        res[temp++][2] = k
                    }
                }
            }
        }

        return res
    }
}
