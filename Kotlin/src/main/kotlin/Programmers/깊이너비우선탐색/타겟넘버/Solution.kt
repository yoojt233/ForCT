package Programmers.깊이너비우선탐색.타겟넘버

fun main() {
    val numbers = intArrayOf(1, 1, 1, 1, 1)
    val target = 3

    print(Solution().solution(numbers, target))
}

class Solution {
    fun solution(numbers: IntArray, target: Int): Int {
        var res = 0

        fun dfs(level: Int, sum: Int) {
            if (level == numbers.size) {
                if (sum == target) ++res
                return
            }

            dfs(level + 1, sum + numbers[level])
            dfs(level + 1, sum - numbers[level])
        }

        dfs(0, 0)

        return res
    }
}
