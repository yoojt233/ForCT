package BaekJoon.no1774_우주신과의교감

import java.util.PriorityQueue
import kotlin.math.pow
import kotlin.math.sqrt

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val positions = Array(n) { Pair(0, 0) }
    val dist = PriorityQueue<Triple<Int, Int, Double>> { a, b -> if (a.third <= b.third) -1 else 1 }

    repeat(n) { i ->
        val (x, y) = readLine().split(" ").map { it.toInt() }
        positions[i] = (Pair(x, y))
    }

    fun getDist(i: Int, j: Int): Double {
        val a = positions[i]
        val b = positions[j]

        return sqrt((a.first - b.first).toDouble().pow(2) + (a.second - b.second).toDouble().pow(2))
    }

    for (i in 0 until n - 1) {
        for (j in i + 1 until n) dist.add(Triple(i, j, getDist(i, j)))
    }

    val parent = IntArray(n) { it }
    val cnt = IntArray(n) { 1 }

    repeat(m) {
        val (a, b) = readLine().split(" ").map { it.toInt() - 1 }
        union(parent, cnt, a, b)
    }

    var res = 0.00
    while (dist.isNotEmpty()) {
        val (op, ed, cost) = dist.poll()

        if (find(parent, op) != find(parent, ed)) {
            res += cost
            union(parent, cnt, op, ed)
        }
    }

    print(String.format("%.2f", res))
}

fun find(parent: IntArray, x: Int): Int {
    if (parent[x] != x) parent[x] = find(parent, parent[x])
    return parent[x]
}

fun union(parent: IntArray, cnt: IntArray, a: Int, b: Int) {
    val aRoot = find(parent, a)
    val bRoot = find(parent, b)

    if (aRoot != bRoot) {
        if (cnt[aRoot] >= cnt[bRoot]) {
            cnt[aRoot] += cnt[bRoot]
            cnt[bRoot] = 0
            parent[bRoot] = aRoot
        } else {
            cnt[bRoot] += cnt[aRoot]
            cnt[aRoot] = 0
            parent[aRoot] = bRoot
        }
    }
}
