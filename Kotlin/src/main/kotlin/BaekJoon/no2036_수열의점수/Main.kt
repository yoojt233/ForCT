package BaekJoon.no2036_수열의점수

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val nums = IntArray(n) { readLine().toInt() }
    val minus = ArrayList<Int>()
    val plus = ArrayList<Int>()

    var zero = 0
    var ans = 0L

    for (num in nums) {
        if (num == 0) ++zero
        else if (num == 1) ++ans
        else if (num > 0) plus.add(num)
        else minus.add(num)
    }

    minus.sort()
    plus.sortDescending()

    for (i in 0 until plus.size / 2) ans += (plus[2 * i].toLong() * plus[2 * i + 1])
    if (plus.size % 2 != 0) ans += plus.last()
    for (i in 0 until minus.size / 2) ans += (minus[2 * i].toLong() * minus[2 * i + 1])
    if (minus.size % 2 != 0 && zero == 0) ans += minus.last()

    println(ans)
}
