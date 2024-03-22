package BaekJoon.no19699_소난다

import kotlin.math.sqrt

val set = HashSet<Int>()

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val cows = readLine().split(" ").map { it.toInt() }.toIntArray()
    val total = cows.sum()
    val primes = eratos(total)

    combo(m, 0, 0, 0, cows, primes)

    if (set.isEmpty()) print(-1)
    else set.sorted().forEach { print("$it ") }
}

fun eratos(total: Int): HashSet<Int> {
    val isPrime = BooleanArray(total + 1) { true }
    val res = HashSet<Int>()

    for (i in 2..sqrt((total + 1).toDouble()).toInt()) {
        if (isPrime[i]) {
            for (x in i * 2..total step i) isPrime[x] = false
        }
    }

    for (i in 2..total) {
        if (!isPrime[i]) continue
        res.add(i)
    }

    return res
}

fun combo(m: Int, level: Int, cur: Int, sum: Int, cows: IntArray, primes: HashSet<Int>) {
    if (level == m) {
        if (primes.contains(sum)) set.add(sum)
        return
    }

    if (cur >= cows.size) return

    combo(m, level, cur + 1, sum, cows, primes)
    combo(m, level + 1, cur + 1, sum + cows[cur], cows, primes)
}
