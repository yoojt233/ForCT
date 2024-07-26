package Programmers.연습문제.숫자변환하기

import java.util.PriorityQueue

fun main() {
    val (x, y, n) = intArrayOf(2, 5, 4)
    print(Solution().solution(x, y, n))
}

class Solution {
    fun solution(x: Int, y: Int, n: Int): Int {
        if (x == y) return 0

        val already = HashSet<Int>()
        val q = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })
        q.add(Pair(x, 0))

        while (q.isNotEmpty()) {
            val (v, c) = q.poll()

            if (v > y) continue

            for (i in 0 until 3) {
                val next = when (i) {
                    0 -> v + n
                    1 -> v * 2
                    else -> v * 3
                }

                if (next > y || already.contains(next)) continue
                else if (next == y) return c + 1

                already.add(next)
                q.add(Pair(next, c + 1))
            }
        }

        return -1
    }
}
