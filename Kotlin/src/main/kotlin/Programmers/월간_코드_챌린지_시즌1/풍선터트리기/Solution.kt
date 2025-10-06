package Programmers.월간_코드_챌린지_시즌1.풍선터트리기

import kotlin.math.min

class Solution {
    fun solution(a: IntArray): Int {
        val n = a.size
        val leftDp = IntArray(n) { Int.MAX_VALUE }
        val rightDp = IntArray(n) { Int.MAX_VALUE }

        var res = 0

        for (i in 1 until n) {
            leftDp[i] = min(leftDp[i - 1], a[i - 1])
            rightDp[n - i - 1] = min(rightDp[n - i], a[n - i])
        }

        for (i in a.indices) {
            if (a[i] > leftDp[i] && a[i] > rightDp[i]) continue
            ++res
        }

        return res
    }
}
