package Programmers.연습문제.카운트다운

import kotlin.math.max

class Solution {
    fun solution(target: Int): IntArray {
        val dp = Array(target + 1) { intArrayOf(Int.MAX_VALUE, 0) }

        dp[0][0] = 0
        for (i in 1..target) {
            for (j in 1..20) {
                if (i >= 50) {
                    if (dp[i][0] > dp[i - 50][0] + 1) {
                        dp[i][0] = dp[i - 50][0] + 1
                        dp[i][1] = dp[i - 50][1] + 1
                    } else if (dp[i][0] == dp[i - 50][0] + 1) dp[i][1] = max(dp[i][1], dp[i - 50][1] + 1)
                }

                if (i >= j) {
                    if (dp[i][0] > dp[i - j][0] + 1) {
                        dp[i][0] = dp[i - j][0] + 1
                        dp[i][1] = dp[i - j][1] + 1
                    } else if (dp[i][0] == dp[i - j][0] + 1) dp[i][1] = max(dp[i][1], dp[i - j][1] + 1)
                }

                if (i >= 2 * j) {
                    if (dp[i][0] > dp[i - 2 * j][0] + 1) {
                        dp[i][0] = dp[i - 2 * j][0] + 1
                        dp[i][1] = dp[i - 2 * j][1]
                    }
                }

                if (i >= 3 * j) {
                    if (dp[i][0] > dp[i - 3 * j][0] + 1) {
                        dp[i][0] = dp[i - 3 * j][0] + 1
                        dp[i][1] = dp[i - 3 * j][1]
                    }
                }
            }
        }

        return intArrayOf(dp[target][0], dp[target][1])
    }
}
