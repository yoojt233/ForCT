package BaekJoon.no2666_벽장문의이동

import kotlin.math.abs

lateinit var order: IntArray
var m = 20
var ans = Integer.MAX_VALUE

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    var (d1, d2) = readLine().split(" ").map { it.toInt() - 1 }

    m = readLine().toInt()
    order = IntArray(m)
    repeat(m) {
        order[it] = readLine().toInt() - 1
    }

    dfs(0, 0, d1, d2)
    print(ans)
}

fun dfs(idx: Int, sum: Int, d1: Int, d2: Int) {
    if (sum >= ans) return

    if (idx == m) {
        ans = ans.coerceAtMost(sum)
        return
    }

    val cur = order[idx]
    val left = abs(cur - d1)
    val right = abs(cur - d2)

    if (cur <= d1) dfs(idx + 1, sum + left, cur, d2)
    else if (cur > d2) dfs(idx + 1, sum + right, d1, cur)
    else {
        dfs(idx + 1, sum + left, cur, d2)
        dfs(idx + 1, sum + right, d1, cur)
    }
}
