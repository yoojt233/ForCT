package BaekJoon.no2098_외판원순회

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt();

    val cities = Array(n) { IntArray(n) { 0 } };
    repeat(n) { i ->
        cities[i] = readLine().split(" ").map { it.toInt() }.toIntArray();
    }

    repeat(n - 1) {
        val visited = Array(n) { false };

    }
}