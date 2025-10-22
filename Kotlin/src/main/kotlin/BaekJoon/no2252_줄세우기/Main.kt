package BaekJoon.no2252_줄세우기

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val graph = Array(n + 1) { ArrayList<Int>() }
    val degrees = IntArray(n + 1)
    val dq = ArrayDeque<Int>()
    val sb = StringBuilder()

    repeat(m) {
        val (front, back) = readLine().split(" ").map { it.toInt() }

        graph[front].add(back)
        ++degrees[back]
    }

    for (i in 1..n) {
        if (degrees[i] != 0) continue

        sb.append("$i ")
        dq.add(i)
    }

    while (dq.isNotEmpty()) {
        val cur = dq.removeFirst()

        for (next in graph[cur]) {
            --degrees[next]

            if (degrees[next] == 0) {
                sb.append("$next ")
                dq.add(next)
            }
        }
    }

    println(sb.toString())
}
