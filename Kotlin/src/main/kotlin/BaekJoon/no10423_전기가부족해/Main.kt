package BaekJoon.no10423_전기가부족해

data class Edge(val op: Int, val ed: Int, val cost: Int) : Comparable<Edge> {
    override fun compareTo(other: Edge): Int {
        return cost - other.cost
    }
}

lateinit var parents: IntArray

fun main() = with(System.`in`.bufferedReader()) {
    fun read(): List<Int> {
        return readLine().split(" ").map { it.toInt() }
    }

    val (n, m, k) = read()
    val powers = read().toIntArray()
    parents = IntArray(n) { it }
    val edges = ArrayList<Edge>()
    var ans = 0

    for (p in powers) parents[p - 1] = -1

    repeat(m) {
        val (op, ed, cost) = read()
        edges.add(Edge(op - 1, ed - 1, cost))
    }
    edges.sort()


    for (edge in edges) {
        if (find(edge.op) == find(edge.ed)) continue

        ans += edge.cost
        union(edge.op, edge.ed)

        if (check()) break
    }

    print(ans)
}

fun find(city: Int): Int {
    if (parents[city] != city && parents[city] != -1) parents[city] = find(parents[city])
    return parents[city]
}

fun union(a: Int, b: Int) {
    val rootA = find(a)
    val rootB = find(b)

    if (rootA == rootB) return

    if (rootA == -1) parents[rootB] = rootA
    else parents[rootA] = rootB
}

fun check(): Boolean {
    for (p in parents) if (p != -1) return false

    return true
}
