package Programmers.월간_코드_챌린지_시즌1.쿼드압축후개수새기

class Solution {
    fun solution(arr: Array<IntArray>): IntArray {
        val ans = intArrayOf(0, 0)

        fun check(r: Int, c: Int, s: Int, num: Int): Boolean {
            for (i in r until r + s) {
                for (j in c until c + s) {
                    if (arr[i][j] != num) return false
                }
            }

            return true
        }

        fun recul(r: Int, c: Int, s: Int) {
            val num = arr[r][c]

            if (check(r, c, s, num)) ++ans[num]
            else {
                val next = s.ushr(1)

                recul(r, c, next)
                recul(r + next, c, next)
                recul(r, c + next, next)
                recul(r + next, c + next, next)
            }
        }

        recul(0, 0, arr.size)

        return ans
    }
}

fun main() {
    val arr = arrayOf(
        intArrayOf(1, 1, 1, 1, 1, 1, 1, 1), intArrayOf(0, 1, 1, 1, 1, 1, 1, 1),
        intArrayOf(0, 0, 0, 0, 1, 1, 1, 1), intArrayOf(0, 1, 0, 0, 1, 1, 1, 1),
        intArrayOf(0, 0, 0, 0, 0, 0, 1, 1), intArrayOf(0, 0, 0, 0, 0, 0, 0, 1),
        intArrayOf(0, 0, 0, 0, 1, 0, 0, 1), intArrayOf(0, 0, 0, 0, 1, 1, 1, 1)
    )

    println(Solution().solution(arr).joinToString(" "))
}