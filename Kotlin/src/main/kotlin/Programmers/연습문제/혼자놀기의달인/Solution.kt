package Programmers.연습문제.혼자놀기의달인

import java.util.PriorityQueue

fun main() {
    val cards = intArrayOf(8, 6, 3, 7, 2, 5, 1, 4)

    print(Solution().solution(cards))
}

class Solution {
    fun solution(cards: IntArray): Int {
        val cnt = PriorityQueue<Int>(reverseOrder())
        val visited = BooleanArray(cards.size)

        for (i in cards.indices) {
            if (visited[i]) continue

            var temp = 0
            var cur = i

            while (!visited[cur]) {
                visited[cur] = true
                ++temp
                cur = cards[cur] - 1
            }

            cnt.add(temp)
        }

        return if (cnt.size == 1) 0 else cnt.poll() * cnt.poll()
    }
}
