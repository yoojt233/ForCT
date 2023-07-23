package BaekJoon.no2529_부등호

import kotlin.math.max

var maximum = "0";
var minimum = "9";


fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt();
    val symbols = readLine().split(" ").map { it[0] };

    for (i in 1..n) {
        maximum += i;
        minimum += (9 - i);
    }

    val visited = BooleanArray(10);
    dfs(0, "", symbols, visited, n)
    print("$maximum\n$minimum")
}

fun dfs(level: Int, num: String, symbols: List<Char>, visited: BooleanArray, n: Int) {
    if (level > n) {
        val temp = num.toLong();
        if (temp > maximum.toLong()) maximum = num;
        if (temp < minimum.toLong()) minimum = num;
        return;
    }

    for (i in 0..9) {
        if (visited[i]) continue;
        if (level == 0 || check(num[level - 1].code - 48, i, symbols[level - 1])) {
            visited[i] = true;
            dfs(level + 1, num + i, symbols, visited, n);
            visited[i] = false;
        }
    }
}

fun check(last: Int, cur: Int, symbol: Char): Boolean {
    return if (symbol == '<') last < cur else last > cur;
}
