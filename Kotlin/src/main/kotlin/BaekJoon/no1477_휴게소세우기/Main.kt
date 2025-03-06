package BaekJoon.no1477_휴게소세우기

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m, l) = readLine().split(" ").map { it.toInt() }
    val nums = if (n > 0) readLine().split(" ").map { it.toInt() }.toHashSet() else HashSet()

    var left = 1
    var right = l

    nums.add(0)
    nums.add(l)

    val rest = nums.toIntArray().sorted()

    while (left < right) {
        val mid = (left + right).ushr(1)

        var total = 0

        for (i in 0..n) total += (rest[i + 1] - rest[i] - 1) / mid

        if (total > m) left = mid + 1 else right = mid
    }

    println(right)
}
