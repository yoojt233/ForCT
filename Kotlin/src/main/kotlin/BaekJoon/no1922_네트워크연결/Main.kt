package BaekJoon.no1922_네트워크연결

import java.util.PriorityQueue
import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt();
    val pq = PriorityQueue<Node>();
    repeat(readLine().toInt()) {
        val st = StringTokenizer(readLine());
        pq.add(Node(st.nextToken().toInt() - 1, st.nextToken().toInt() - 1, st.nextToken().toInt()));
    }

    var ans = 0;
    val parents = IntArray(n) { it };
    while (pq.isNotEmpty()) {
        val cur = pq.poll();
        if (find(parents, cur.from) != find(parents, cur.to)) {
            ans += cur.cost;
            union(parents, cur.from, cur.to);
        }
    }
    print(ans);
}

fun find(parents: IntArray, x: Int): Int {
    if (parents[x] != x) parents[x] = find(parents, parents[x]);
    return parents[x];
}

fun union(parents: IntArray, a: Int, b: Int) {
    val aRoot = find(parents, a);
    val bRoot = find(parents, b);

    if (aRoot != bRoot) parents[bRoot] = aRoot;
}

data class Node(val from: Int, val to: Int, val cost: Int) : Comparable<Node> {
    override fun compareTo(other: Node): Int {
        return cost - other.cost;
    }
}