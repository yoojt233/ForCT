package BaekJoon.no15685_드래곤커브

import java.util.LinkedList

val possible = HashSet<Int>();
val dx = intArrayOf(0, -1, 0, 1);
val dy = intArrayOf(1, 0, -1, 0);

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt();

    repeat(n) {
        dragon(readLine().split(" ").map { it.toInt() });
    }

    var ans = 0;
    for (i in possible) {
        if (possible.contains(i + 1) && possible.contains(i + 101) && possible.contains(i + 102)) ++ans;
    }

    print(ans);
}

fun dragon(input: List<Int>) {
    var r = input[1];
    var c = input[0];
    possible.add(r * 101 + c);

    val dir = LinkedList<Int>();
    dir.add(input[2]);

    repeat(input[3]) {
        val size = dir.size;
        for (i in size - 1 downTo 0) dir.add((dir[i] + 1) % 4);
    }

    for (d in dir) {
        r += dx[d];
        c += dy[d];
        possible.add(r * 101 + c);
    }
}
