package BaekJoon.no22866_탑보기

import java.util.Stack
import kotlin.math.abs

lateinit var heights: List<Int>
lateinit var cnt: IntArray
lateinit var near: IntArray

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    heights = readLine().split(" ").map { it.toInt() }
    cnt = IntArray(n)
    near = IntArray(n) { 100001 }

    see(n, true)
    see(n, false)

    val sb = StringBuilder()
    for (i in 0 until n) sb.append(if (cnt[i] > 0) "${cnt[i]} ${near[i] + 1}\n" else "0\n")
    print(sb)
}

fun see(n: Int, dir: Boolean) {
    val res = Stack<Int>()
    if (dir) {
        for (i in 0 until n) {
            while (res.isNotEmpty() && heights[res.peek()] <= heights[i]) res.pop()
            cnt[i] = res.size
            if (cnt[i] > 0) near[i] = res.peek()
            res.push(i)
        }
    } else {
        for (i in n - 1 downTo 0) {
            while (res.isNotEmpty() && heights[res.peek()] <= heights[i]) res.pop()
            cnt[i] += res.size
            if (res.isNotEmpty() && abs(res.peek() - i) < abs(near[i] - i)) near[i] = res.peek()
            res.push(i)
        }
    }
}
