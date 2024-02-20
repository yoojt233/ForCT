package BaekJoon.no2661_좋은수열

var ans = ""

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    add(n, "")
    print(ans)
}

fun add(n: Int, cur: String) {
    if (ans != "") return
    if (cur.length == n) {
        ans = cur
        return
    }

    for (i in 1..3) {
        val next = cur + i.toString()
        if (check(next)) add(n, next)
    }
}

fun check(temp: String): Boolean {
    val len = temp.length

    for (i in 1..len / 2) {
        val boundary = len - i
        val left = temp.substring(boundary - i, boundary)
        val right = temp.substring(boundary, len)

        if (left == right) return false
    }

    return true
}
