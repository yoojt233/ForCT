package Programmers.힙.디스크컨트롤러

import java.util.PriorityQueue

fun main() {
    val jobs = arrayOf(intArrayOf(0, 3), intArrayOf(1, 9), intArrayOf(2, 6))
    print(Solution().solution(jobs))
}

class Solution {
    fun solution(jobs: Array<IntArray>): Int {
        val waiting = PriorityQueue<IntArray>(compareBy { it[0] })
        for (job in jobs) waiting.add(job)

        val able = PriorityQueue<IntArray>(compareBy { it[1] })
        var currentTime = 0
        var total = 0

        while (waiting.isNotEmpty() || able.isNotEmpty()) {
            if (waiting.isNotEmpty() && able.isEmpty() && waiting.peek()[0] > currentTime) {
                currentTime = waiting.peek()[0]
                continue
            }

            while (waiting.isNotEmpty() && waiting.peek()[0] <= currentTime) able.add(waiting.poll())

            val take = able.poll()
            currentTime += take[1]
            total += (currentTime - take[0])
        }

        return total / jobs.size
    }
}