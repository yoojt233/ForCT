package Programmers.연습문제.부대복귀

fun main() {
    val n = 5
    val roads = arrayOf(intArrayOf(1, 2), intArrayOf(1, 4), intArrayOf(2, 4), intArrayOf(2, 5), intArrayOf(4, 5))
    val sources = intArrayOf(1, 3, 5)
    val destination = 5
    solution(n, roads, sources, destination).forEach { print("$it ") }
}

fun solution(n: Int, roads: Array<IntArray>, sources: IntArray, destination: Int): IntArray {
    val res = IntArray(sources.size)
    val board = Array(n + 1) { ArrayList<Int>() }

    for (road in roads) {
        board[road[0]].add(road[1])
        board[road[1]].add(road[0])
    }

    for (i in sources.indices) res[i] = bfs(board, sources[i], destination, BooleanArray(n + 1))

    return res
}

fun bfs(board: Array<ArrayList<Int>>, op: Int, destination: Int, visited: BooleanArray): Int {
    if (op == destination) return 0

    var time = 0
    val q = ArrayDeque<Int>()
    q.add(op)

    while (q.isNotEmpty()) {
        val len = q.size
        repeat(len) {
            val cur = q.removeFirst()

            for (next in board[cur]) {
                if (visited[next]) continue
                else if (next == destination) return time + 1
                visited[next] = true
                q.add(next)
            }
        }
        ++time
    }

    return -1
}

