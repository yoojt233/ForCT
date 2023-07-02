package BaekJoon.no1138_한줄로서기

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt();
    val input = readLine().split(" ").map { it.toInt() }

    val line = IntArray(n);
    fun move(chance: Int): Int {
        var i = 0;
        var temp = 0;

        while (temp < chance) {
            if (line[i] == 0) ++temp;
            ++i;
        }

        while (line[i] != 0) ++i;
        return i;
    }

    for (i in input.indices) {
        val pos = move(input[i]);
        line[pos] = i + 1;
    }

    val sb = StringBuilder();
    for (i in line) sb.append("$i ");
    print(sb);
}