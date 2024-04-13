package BaekJoon.no29717_슬라임잡고레벨업

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    repeat(readLine().toInt()) {
        val n = readLine().toLong()
        val exp = n * (n + 1) / 2
        var left = 1L
        var right = 1e9.toLong()

        while (left <= right) {
            val mid = (left + right) / 2
            if (mid * (mid + 1) <= exp) left = mid + 1
            else right = mid - 1
        }
        sb.append("$left\n")
    }
    print(sb)
}