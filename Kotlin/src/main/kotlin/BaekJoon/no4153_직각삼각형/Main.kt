package BaekJoon.no4153_직각삼각형

fun isTriangle(a: Int, b: Int, c: Int): Boolean {
    return a * a + b * b == c * c;
}

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder();

    while (true) {
        val (a, b, c) = readLine().split(" ").map { it.toInt() }.sorted();
        if (a == 0 && b == 0 && c == 0) break;
        sb.append(if (isTriangle(a, b, c)) "right\n" else "wrong\n");
    }

    println(sb);
}