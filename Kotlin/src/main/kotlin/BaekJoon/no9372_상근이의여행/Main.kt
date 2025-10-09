package BaekJoon.no9372_상근이의여행

fun main() = with(System.`in`.bufferedReader()) {
    val t = readLine().toInt()

    repeat(t) {
        val (n, m) = readLine().split(" ").map { it.toInt() }

        repeat(m) {
            readLine().split(" ").map { it.toInt() }
        }

        println(n - 1)
    }
}
