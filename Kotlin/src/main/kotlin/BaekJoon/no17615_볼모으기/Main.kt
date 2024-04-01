package BaekJoon.no17615_볼모으기

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val input = readLine()

    fun count(str: String, target: Char): Int {
        var res = 0
        for (i in str.indices) if (str[i] == target) ++res
        return res
    }

    val ans = minOf(
        count(input.trimStart('R'), 'R'), count(input.trimStart('B'), 'B'),
        count(input.trimEnd('R'), 'R'), count(input.trimEnd('B'), 'B')
    )
    print(ans)
}
