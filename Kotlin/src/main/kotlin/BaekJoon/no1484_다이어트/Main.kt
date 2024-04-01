package BaekJoon.no1484_다이어트

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val pows = LongArray(50001) { it.toLong() * it }
    val temp = ArrayList<Int>()

    var left = 1
    var right = 2

    while (right < pows.size) {
        val diff = (pows[right] - pows[left]).toInt()

        if (diff == n) {
            temp.add(right)
            right = ++left
        }
        else if (diff < n) right++
        else ++left
    }

    if (temp.isNotEmpty()) temp.forEach { println(it) }
    else print(-1)
}
