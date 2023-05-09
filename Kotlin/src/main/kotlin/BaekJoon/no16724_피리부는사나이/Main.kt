package BaekJoon.no16724_피리부는사나이

lateinit var board: Array<CharArray>;
lateinit var parents: IntArray;
lateinit var treeSize: IntArray;

fun main() = with(System.`in`.bufferedReader()) {
    val (r, c) = readLine().split(" ").map { it.toInt() };

    board = Array(r) { CharArray(c) { ' ' } }
    repeat(r) {
        board[it] = readLine().toCharArray();
    }

    parents = IntArray(r * c) { it };
    treeSize = IntArray(r * c) { 1 };
    for (i in 0 until r) {
        for (j in 0 until c) {
            val cur = i * c + j;
            when (board[i][j]) {
                'U' -> union(cur, cur - c);
                'D' -> union(cur, cur + c);
                'L' -> union(cur, cur - 1);
                'R' -> union(cur, cur + 1);
            }
        }
    }

    val root = HashSet<Int>();
    for (i in parents) root.add(find(i));
    print(root.size);
}

fun find(num: Int): Int {
    if (parents[num] == num) return num;
    parents[num] = find(parents[num]);
    return parents[num];
}

fun union(a: Int, b: Int) {
    if (b < 0 || b >= parents.size) return;
    val aRoot = find(a);
    val bRoot = find(b);
    if (aRoot != bRoot) {
        if (treeSize[aRoot] > treeSize[bRoot]) {
            parents[bRoot] = aRoot;
            treeSize[aRoot] += treeSize[bRoot];
        } else {
            parents[aRoot] = bRoot;
            treeSize[bRoot] += treeSize[aRoot];
        };
    }
}