package BaekJoon.no2263_트리의순회

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt();
    val inorder = readLine().split(" ").map { it.toInt() };
    val postorder = readLine().split(" ").map { it.toInt() };
    val sb = StringBuilder();

    val where = IntArray(n + 1);
    for (i in inorder.indices) {
        where[inorder[i]] = i;
    }

    fun dc(last: Int, postOp: Int, postEd: Int) {
        if (postOp > postEd) return;
        val idx = where[postorder[postEd]];
        sb.append("${postorder[postEd]} ");

        val right = last - idx;
        if (idx - 1 >= 0) dc(idx - 1, postOp, postEd - right - 1);
        if (idx + 1 < n) dc(last, postEd - right, postEd - 1);
    }

    dc(n - 1, 0, n - 1);
    print(sb);
}