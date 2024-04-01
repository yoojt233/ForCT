package Programmers.연습문제.요격시스템

fun main() {
    val targets = arrayOf(
        intArrayOf(4, 5),
        intArrayOf(4, 8),
        intArrayOf(10, 14),
        intArrayOf(11, 13),
        intArrayOf(5, 12),
        intArrayOf(3, 7),
        intArrayOf(1, 4)
    )
    print(solution(targets))
}

fun solution(targets: Array<IntArray>): Int {
    var res = 1

    targets.sortBy { it[1] }
    var last = targets[0][1]
    for (i in 1 until targets.size) {
        if (targets[i][0] < last) continue
        ++res
        last = targets[i][1]
    }

    return res
}