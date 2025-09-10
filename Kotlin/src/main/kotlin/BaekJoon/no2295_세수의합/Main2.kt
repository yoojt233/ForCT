package BaekJoon.no2295_세수의합

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val num = IntArray(n) { readLine().toInt() }
    val plus = buildSet {
        for (i in num) {
            for (j in num) {
                add(i + j)
            }
        }
    }

    var ans = 0

    for (d in num) {
        for (c in num) {
            if (plus.contains(d - c)) ans = maxOf(ans, d)
        }
    }

    println(ans)
}
