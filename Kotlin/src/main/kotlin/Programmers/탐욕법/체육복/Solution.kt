package Programmers.탐욕법.체육복

fun main() {
    val n = 5
    val lost = intArrayOf(2, 4)
    val reserve = intArrayOf(3)

    print(Solution().solution(n, lost, reserve))
}

class Solution {
    fun solution(n: Int, lost: IntArray, reserve: IntArray): Int {
        val lostMember = (lost.sorted() - reserve.toSet()).toMutableList()
        val reserveMember = (reserve.sorted() - lost.toSet()).toMutableList()

        var res = n - lostMember.size

        for (i in lostMember) {
            if (reserveMember.contains(i - 1)) {
                reserveMember.remove(i - 1)
                ++res
            } else if (reserveMember.contains(i + 1)) {
                reserveMember.remove(i + 1)
                ++res
            }
        }

        return res
    }
}
