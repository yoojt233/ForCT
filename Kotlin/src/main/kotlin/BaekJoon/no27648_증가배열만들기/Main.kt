package BaekJoon.no27648_증가배열만들기

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m, k) = readLine().split(" ").map { it.toInt() };
    if (n + m - 1 > k) print("NO");
    else {
        val sb = StringBuilder();
        sb.append("YES\n");
        repeat(n) { i ->
            repeat(m) { j ->
                sb.append("${i + j + 1} ");
            }
            sb.append("\n");
        }
        print(sb);
    }
}