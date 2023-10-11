package Programmers.KAKAO_BLIND_RECRUITMENT_2020.자물쇠와열쇠

fun main() = with(System.`in`.bufferedReader()) {
    fun solution(key: Array<IntArray>, lock: Array<IntArray>): Boolean {
        val ks = key.size
        val ls = lock.size
        val ts = ls + (key.size - 1) * 2
        val board = Array(ts) { IntArray(ts) }
        var tempKey = Array(ks) { IntArray(ks) }

        fun init() {
            for (i in 0 until ls) {
                for (j in 0 until ls) {
                    board[i + ks - 1][j + ks - 1] = lock[i][j]
                }
            }
        }
        init()

        for (i in 0 until ks) {
            for (j in 0 until ks) {
                tempKey[i][j] = key[i][j]
            }
        }

        fun rotate(tk: Array<IntArray>): Array<IntArray> {
            val res = Array(ks) { IntArray(ks) }
            for (i in key.indices) {
                for (j in key.indices) {
                    res[i][j] = tk[ks - j - 1][i]
                }
            }
            return res
        }

        fun combine(r: Int, c: Int) {
            for (i in r until r + ks) {
                for (j in c until c + ks) {
                    board[i][j] += tempKey[i - r][j - c]
                }
            }
        }

        fun isFill(): Boolean {
            for (i in 0 until ls) {
                for (j in 0 until ls) {
                    if (board[i + ks - 1][j + ks - 1] != 1) return false
                }
            }
            return true
        }

        for (d in 0 until 4) {
            if (d != 0) tempKey = rotate(tempKey)
            for (i in 0 until ts - ks + 1) {
                for (j in 0 until ts - ks + 1) {
                    combine(i, j)
                    if (isFill()) return true
                    init()
                }
            }
        }
        return false
    }

    val key = arrayOf(
        intArrayOf(0, 0, 0),
        intArrayOf(1, 0, 0),
        intArrayOf(0, 1, 0),
    )
    val lock = arrayOf(
        intArrayOf(1, 1, 1),
        intArrayOf(1, 1, 0),
        intArrayOf(1, 0, 0)
    )
    print(solution(key, lock))
}