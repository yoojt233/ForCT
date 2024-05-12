package BaekJoon.no1107_리모컨

import kotlin.math.*

fun main() = with(System.`in`.bufferedReader()) {
    val target = readLine().toInt()
    val n = readLine().toInt()

    var cnt = abs(target - 100)
    var broken = HashSet<Int>()
    if (n > 0) broken = readLine().split(" ").map { it.toInt() }.toHashSet()

    fun check(x: Int): Int {
        if (x == 0) return if (broken.contains(0)) 0 else 1

        var op = x
        var res = 0

        while (op > 0) {
            if (op % 10 in broken) return 0
            op /= 10
            ++res
        }

        return res
    }

    if (target != 100) {
        for (i in 0..10_000_000) {
            val res = check(i)
            if (res > 0) cnt = min(cnt, abs(target - i) + res)
        }
    }

    print(cnt)
}
