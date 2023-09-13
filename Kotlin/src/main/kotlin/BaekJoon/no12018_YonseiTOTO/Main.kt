package BaekJoon.no12018_YonseiTOTO

fun main() = with(System.`in`.bufferedReader()) {
    var (n, have) = readLine().split(" ").map { it.toInt() }
    val toSingUp = IntArray(n)

    repeat(n) { i ->
        val (already, only) = readLine().trim().split(" ").map { it.toInt() }
        val mileages = readLine().split(" ").map { it.toInt() }.toIntArray().sorted()
        toSingUp[i] = if (already < only) 1 else mileages[already - only]
    }

    var ans = 0
    for (need in toSingUp.sorted()) {
        if (have < need) break
        ++ans
        have -= need
    }
    print(ans)
}
