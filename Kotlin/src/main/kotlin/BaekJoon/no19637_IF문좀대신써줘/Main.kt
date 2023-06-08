package BaekJoon.no19637_IF문좀대신써줘

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val panels = Array(n) { "" };
    val scores = IntArray(n);

    repeat(n) {
        val (panel, score) = readLine().split(" ");
        panels[it] = panel
        scores[it] = score.toInt();
    }

    val sb = StringBuilder();
    repeat(m) {
        sb.append("${panels[binarySearch(scores, readLine().toInt())]}\n")
    }
    print(sb);
}

fun binarySearch(arr: IntArray, n: Int): Int {
    var op = 0
    var ed = arr.size - 1

    while (op < ed) {
        val mid = (op + ed) / 2;
        if (n <= arr[mid]) {
            ed = mid
        } else {
            op = mid + 1
        }
    }

    return ed;
}
