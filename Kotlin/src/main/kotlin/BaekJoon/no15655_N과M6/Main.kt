package BaekJoon.no15655_N과M6

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() };
    val nums = readLine().split(" ").map { it.toInt() }.toIntArray().sorted();
    val sb = StringBuilder();

    val chosen = IntArray(m);
    fun combo(depth: Int, op: Int) {
        if (depth == m) {
            chosen.forEach { sb.append("$it ") };
            sb.append("\n");
            return;
        }

        for (i in op until n) {
            chosen[depth] = nums[i];
            combo(depth + 1, i + 1);
        }
    }
    combo(0, 0);
    print(sb);
}