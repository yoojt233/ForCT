package BaekJoon.no1072_게임

fun main() = with(System.`in`.bufferedReader()) {
    val (x, y) = readLine().split(" ").map { it.toLong() }
    val z = 100 * y / x

    fun binarySearch(): Int {
        var left = 1
        var right = 1_000_000_000

        while (left <= right) {
            val mid = (left + right) / 2
            val temp = 100 * (y + mid) / (x + mid)

            if (temp == z) left = mid + 1
            else right = mid - 1
        }

        return left
    }

    print(if (z < 99) binarySearch() else -1)
}
