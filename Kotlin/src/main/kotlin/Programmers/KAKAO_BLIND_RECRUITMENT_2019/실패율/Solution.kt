package Programmers.KAKAO_BLIND_RECRUITMENT_2019.실패율

fun main() {
    val N = 5
    val stages = intArrayOf(2, 1, 2, 6, 2, 4, 3, 3)
    solution(N, stages).forEach { print("$it ") }
}

data class Stage(val num: Int, var stay: Int, var reach: Int)

fun solution(N: Int, stages: IntArray): IntArray {
    val research = Array(N) { Stage(it + 1, 0, 0) }

    for (s in stages) {
        if (s > N) {
            for (i in 0 until N) ++research[i].reach
        } else {
            for (i in 0 until s) ++research[i].reach
            ++research[s - 1].stay
        }
    }

    research.sortWith(compareBy({ -(it.stay / it.reach.toDouble()) }, { it.num }))
    return IntArray(N) { research[it].num }
}