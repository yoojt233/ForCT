package BaekJoon.no11758_CCW

fun main() = with(System.`in`.bufferedReader()) {
    val points = Array(3) { Pair(0, 0) }

    for (i in 0 until 3) {
        val (x, y) = readLine().split(" ").map { it.toInt() }
        points[i] = Pair(x, y)
    }

    val temp =
        (points[1].first - points[0].first) * (points[2].second - points[0].second) - (points[1].second - points[0].second) * (points[2].first - points[0].first)

    if (temp > 0) print(1)
    else if (temp < 0) print(-1)
    else print(temp)
}
