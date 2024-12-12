package BaekJoon.no13325_이진트리

import kotlin.math.abs
import kotlin.math.max
import kotlin.math.pow

data class Node(val idx: Int, var sum: Int, var parent: Int, var left: Int, var right: Int)

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val size = (2.0.pow(n + 1) - 1).toInt()
    val nodes = IntArray(size + 1)
    val temp = readLine().split(" ").map { it.toInt() }.toIntArray()

    var ans = 0

    for (i in temp.indices) nodes[i + 2] = temp[i]

    fun dfs(cur: Int): Int {
        if (cur * 2 >= size) {
            ans += nodes[cur]

            return nodes[cur]
        }

        val left = dfs(cur * 2)
        val right = dfs(cur * 2 + 1)

        ans += (nodes[cur] + abs(left - right))

        return nodes[cur] + max(left, right)
    }

    dfs(1)

    print(ans)
}
