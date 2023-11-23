package Programmers.연습문제.인사고과

import kotlin.math.max

fun main() {
    val scores = arrayOf(intArrayOf(2, 2), intArrayOf(1, 4), intArrayOf(3, 2), intArrayOf(3, 2), intArrayOf(2, 1))
    print(solution(scores))
}

fun solution(scores: Array<IntArray>): Int {
    val wanho = Pair(scores[0][0], scores[0][1])
    var temp = 0
    var res = 0
    val lists = scores.sortedWith(
        compareBy({ -it[0] }, { it[1] })
    )

    for (score in lists) {
        if (temp > score[1]) {
            if (score[0] == wanho.first && score[1] == wanho.second) return -1
        } else {
            temp = max(temp, score[1])
            if (score[0] + score[1] > wanho.first + wanho.second) ++res
        }
    }

    return res + 1
}
