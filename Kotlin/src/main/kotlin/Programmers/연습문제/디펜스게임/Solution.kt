package Programmers.연습문제.디펜스게임

import java.util.PriorityQueue

fun main() {
    val n = 7
    val k = 3
    val enemy = intArrayOf(4, 2, 4, 5, 3, 3, 1)

    fun solution(n: Int, k: Int, enemy: IntArray): Int {
        if (k >= enemy.size) return enemy.size

        var res = 0
        var soldier = n
        var boom = k
        val pq = PriorityQueue<Int>(reverseOrder())

        for (i in enemy) {
            pq.add(i)
            soldier -= i
            while (soldier < 0 && boom > 0) {
                soldier += pq.poll()
                --boom
            }
            if (soldier < 0) break
            ++res
        }

        return res
    }

    print(solution(n, k, enemy))
}