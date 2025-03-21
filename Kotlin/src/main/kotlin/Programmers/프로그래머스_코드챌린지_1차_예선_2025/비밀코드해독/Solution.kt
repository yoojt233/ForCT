package Programmers.프로그래머스_코드챌린지_1차_예선_2025.비밀코드해독

fun main() {
    val n = 10
    val q = arrayOf(
        intArrayOf(1, 2, 3, 4, 5),
        intArrayOf(6, 7, 8, 9, 10),
        intArrayOf(3, 7, 8, 9, 10),
        intArrayOf(2, 5, 7, 9, 10),
        intArrayOf(3, 4, 5, 6, 7)
    )
    val ans = intArrayOf(2, 3, 4, 3, 3)

    print(Solution().solution(n, q, ans))
}

class Solution {
    var res = 0

    fun solution(n: Int, q: Array<IntArray>, ans: IntArray): Int {
        permu(n, q.map { it.toSet() }.toTypedArray(), ans, 0, 1, IntArray(5))

        return res
    }

    private fun permu(n: Int, q: Array<Set<Int>>, ans: IntArray, idx: Int, op: Int, sel: IntArray) {
        if (idx == sel.size) {
            if (check(q, ans, sel.toSet())) ++res
            return
        }

        for (i in op..n) {
            sel[idx] = i
            permu(n, q, ans, idx + 1, i + 1, sel)
        }
    }

    private fun check(q: Array<Set<Int>>, ans: IntArray, sel: Set<Int>): Boolean {
        for (i in q.indices) if (q[i].intersect(sel).size != ans[i]) return false

        return true
    }
}
