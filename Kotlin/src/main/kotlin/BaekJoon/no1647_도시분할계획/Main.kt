package BaekJoon.no1647_도시분할계획

import kotlin.math.max

val edges = ArrayList<Edge>();

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() };

    repeat(m) {
        val (from, to, cost) = readLine().split(" ").map { it.toInt() };
        edges.add(Edge(from, to, cost));
    }
    edges.sort();
    print(mst(n));
}

fun mst(n: Int): Int {
    val parents = IntArray(n + 1) { it };
    var total = 0;
    var highest = 0;

    for (edge in edges) {
        if (find(parents, edge.from) == find(parents, edge.to)) continue;
        total += edge.cost;
        union(parents, edge.from, edge.to);
        highest = max(highest, edge.cost);
    }
    return total - highest;
}

fun find(parents: IntArray, x: Int): Int {
    if (x == parents[x]) return x;
    parents[x] = find(parents, parents[x]);
    return parents[x];
}

fun union(parents: IntArray, a: Int, b: Int) {
    val aRoot = find(parents, a);
    val bRoot = find(parents, b);

    if (aRoot != bRoot) parents[bRoot] = aRoot;
}

data class Edge(val from: Int, val to: Int, val cost: Int) : Comparable<Edge> {
    override fun compareTo(other: Edge): Int {
        return cost - other.cost;
    }
}