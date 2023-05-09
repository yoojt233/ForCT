package BaekJoon.no20040_사이클게임

lateinit var parents: IntArray;

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() };
    var ans = 0;
    parents = IntArray(n) { it };
    for (i in 1..m) {
        val (a, b) = readLine().split(" ").map { it.toInt() };
        val aRoot = find(a);
        val bRoot = find(b);
        if (aRoot == bRoot) {
            ans = i;
            break;
        }
        union(aRoot, bRoot);
    }
    print(ans);
}

fun union(aRoot: Int, bRoot: Int) {
    parents[bRoot] = aRoot;
}

fun find(a: Int): Int {
    return if (parents[a] == a) a else find(parents[a]);
}
