package Programmers.KAKAO_BLIND_RECRUITMENT_2022.양궁대회

fun main() {
    val n = 10
    val info = intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 3, 4, 3)

    Solution().solution(n, info).forEach { print("$it ") }
}

class Solution {
    fun solution(n: Int, info: IntArray): IntArray {
        var maxGap = 0
        var res = IntArray(11)

        fun getGap(targets: IntArray): Int {
            var ryan = 0
            var apeach = 0

            for (i in 0 until 11) {
                if (info[i] + targets[i] == 0) continue

                val score = (10 - i)

                if (info[i] >= targets[i]) apeach += score
                else ryan += score
            }

            return ryan - apeach
        }

        fun shoot(remain: Int, targets: IntArray, visited: BooleanArray) {
            if (remain == 0) {
                val gap = getGap(targets)

                if (gap >= maxGap) {
                    maxGap = gap
                    res = targets.clone()
                }

                return
            }

            for (i in 0 until 11) {
                if (visited[i]) continue

                val arrow = if (remain >= info[i] + 1) info[i] + 1 else remain

                visited[i] = true
                targets[i] += arrow
                shoot(remain - arrow, targets, visited)
                targets[i] -= arrow
                visited[i] = false
            }
        }

        shoot(n, IntArray(11), BooleanArray(11))

        return if (maxGap == 0) intArrayOf(-1) else res
    }
}
