package BaekJoon.no2056_작업

import java.util.LinkedList
import java.util.Queue

data class Node(var t: Int, var prev: Int, val nexts: HashSet<Int>) {
    constructor() : this(0, 0, HashSet())
}

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val nodes = Array(n) { Node() }
    val times = IntArray(n)
    val q: Queue<Int> = LinkedList()
    var res = 0

    repeat(n) {
        val node = nodes[it]
        val input = readLine().split(" ").map { i -> i.toInt() }

        node.t = input[0]
        node.prev = input[1]
        if (input[1] == 0) {
            times[it] = node.t
            res = res.coerceAtLeast(node.t)
            q.add(it)
        } else {
            for (i in 0 until input[1]) nodes[input[i + 2] - 1].nexts.add(it)
        }
    }

    while (q.isNotEmpty()) {
        val cur = q.poll()

        for (next in nodes[cur].nexts) {
            if (--nodes[next].prev == 0) q.add(next)

            times[next] = times[next].coerceAtLeast(times[cur] + nodes[next].t)
            res = res.coerceAtLeast(times[next])
        }
    }

    print(res)
}
