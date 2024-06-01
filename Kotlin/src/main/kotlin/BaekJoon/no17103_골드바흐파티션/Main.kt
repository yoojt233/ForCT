package BaekJoon.no17103_골드바흐파티션

import kotlin.math.sqrt

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    val primes = eratos()

    repeat(readLine().toInt()) {
        val target = readLine().toInt()
        var cnt = 0

        for (i in 2..target / 2) if (primes[i] && primes[target - i]) ++cnt
        sb.append("$cnt\n")
    }

    print(sb)
}

fun eratos(): BooleanArray {
    val limit = 1_000_000
    val nums = BooleanArray(limit + 1) { true }

    for (i in 2..sqrt(limit.toDouble()).toInt()) {
        if (!nums[i]) continue

        var idx = 2
        while (i * idx <= limit) nums[i * idx++] = false
    }

    return nums
}
