package Programmers.월간_코드_챌린지_시즌2.모두0으로만들기

import kotlin.math.abs

const val mxN = 300000
var graph = Array(mxN) { mutableListOf<Int>() }
var temp = LongArray(mxN)
var ans = 0L

fun dfs(par: Int, n: Int): Long {
    var res = temp[n]

    for (i in 0 until graph[n].size) {
        if (graph[n][i] == par) continue

        res += dfs(n, graph[n][i])
    }

    ans += abs(res)

    return res
}

class Solution {
    fun solution(a: IntArray, edges: Array<IntArray>): Long {
        if (a.sum() != 0) return -1

        // temp = LongArray(a.size) { a[it].toLong() }으로 초기화 후 실행 시 메모리 초과로 런타임 에러 발생.
        for (i in a.indices) temp[i] = a[i].toLong()
        for ((a, b) in edges) {
            graph[a].add(b)
            graph[b].add(a)
        }

        if (dfs(-1, 0) != 0L) ans = -1

        return ans
    }
}

fun main() {
    val a = intArrayOf(-5, 0, 2, 1, 2)
    val edges = arrayOf(
        intArrayOf(0, 1), intArrayOf(3, 4),
        intArrayOf(2, 3), intArrayOf(0, 3)
    )

    println(Solution().solution(a, edges))
}