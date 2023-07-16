package BaekJoon.no2910_빈도정렬

fun main() = with(System.`in`.bufferedReader()) {
    val (n, c) = readLine().split(" ").map { it.toInt() }
    val nums = readLine().split(" ").map { it.toInt() }.toIntArray()

    val appear = HashMap<Int, Int>()
    val chance = HashMap<Int, Int>()
    var idx = 0
    for (i in nums) {
        val temp = chance.getOrDefault(i, 0)
        if (temp == 0) appear[i] = idx++
        chance[i] = temp + 1
    }

    val keys = chance.keys.sortedWith(compareByDescending<Int> { chance[it] }.thenBy { appear[it] })
    val sb = StringBuilder()
    for (key in keys) {
        for (i in 0 until chance[key]!!) sb.append("$key ")
    }
    print(sb)
}