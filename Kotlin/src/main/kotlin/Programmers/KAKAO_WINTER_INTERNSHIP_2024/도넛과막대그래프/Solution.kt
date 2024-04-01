package Programmers.KAKAO_WINTER_INTERNSHIP_2024.도넛과막대그래프

import java.util.Queue
import java.util.LinkedList

fun main() {
    val edges = arrayOf(
        intArrayOf(6, 1), intArrayOf(1, 2), intArrayOf(2, 1),
        intArrayOf(3, 4), intArrayOf(4, 5), intArrayOf(6, 4)
    )
    solution(edges).forEach { print("$it ") }
}

fun solution(edges: Array<IntArray>): IntArray {
    val res = intArrayOf(0, 0, 0, 0)
    // Key: Node 번호, Value: 어디서왔는가, 어디로가는가
    val graph = HashMap<Int, Pair<ArrayList<Int>, ArrayList<Int>>>()

    for (edge in edges) {
        val a = graph.getOrPut(edge[0]) { Pair(ArrayList(), ArrayList()) }
        val b = graph.getOrPut(edge[1]) { Pair(ArrayList(), ArrayList()) }

        a.second.add(edge[1])
        b.first.add(edge[0])
    }

    for (k in graph.keys) {
        if (graph[k]!!.first.size != 0 || graph[k]!!.second.size < 2) continue
        res[0] = k
        break
    }

    for (n in graph[res[0]]!!.second) ++res[check(graph, n)]

    return res
}

val visited = BooleanArray(1000000)

fun check(graph: HashMap<Int, Pair<ArrayList<Int>, ArrayList<Int>>>, n: Int): Int {
    var node = 1
    var edge = 0
    val q: Queue<Int> = LinkedList()

    visited[n] = true
    q.add(n)
    while (q.isNotEmpty()) {
        val cur = q.poll()

        for (next in graph[cur]!!.second) {
            ++edge
            if (visited[next]) continue

            ++node
            visited[next] = true
            q.add(next)
        }
    }

    return if (node == edge) 1
    else if (node - edge == 1) 2
    else 3
}