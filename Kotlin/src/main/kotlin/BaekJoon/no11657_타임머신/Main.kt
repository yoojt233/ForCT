package BaekJoon.no11657_타임머신

data class Edge(val from: Int, val to: Int, val cost: Int)

const val limit = Long.MAX_VALUE

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val edges = ArrayList<Edge>()

    repeat(m) {
        val (from, to, cost) = readLine().split(" ").map { it.toInt() }
        edges.add(Edge(from - 1, to - 1, cost))
    }

    val res = move(edges, n, 0)

    if (!res.first) print(-1)
    else {
        val sb = StringBuilder()

        res.second.filterIndexed { i, _ -> i != 0 }.forEach { sb.append(if (it != limit) "$it\n" else "-1\n") }
        print(sb)
    }
}

fun move(edges: ArrayList<Edge>, n: Int, op: Int): Pair<Boolean, LongArray> {
    val res = LongArray(n) { limit }

    res[op] = 0
    for (i in 0 until n - 1) {
        for (e in edges) {
            if (res[e.from] == limit || res[e.from] + e.cost >= res[e.to]) continue
            res[e.to] = res[e.from] + e.cost
        }
    }

    for (e in edges) {
        if (res[e.from] == limit || res[e.from] + e.cost >= res[e.to]) continue
        return Pair(false, LongArray(0))
    }

    return Pair(true, res)
}
