package BaekJoon.no25418_정수a를k로만들기

import java.util.LinkedList;

fun main() = with(System.`in`.bufferedReader()) {
    val (op, ed) = readLine().split(" ").map { it.toInt() };
    print(bfs(op, ed));
}

fun bfs(op: Int, ed: Int): Int {
    var time = 0;
    val visited = BooleanArray(ed - op);
    val q = LinkedList<Int>();
    q.add(op);

    while (q.isNotEmpty()) {
        val size = q.size;
        repeat(size) {
            val cur = q.poll();
            for (i in 0 until 2) {
                val next = if (i == 0) cur + 1 else cur * 2;

                if (next > ed || visited[next - op - 1]) continue;
                else if (next == ed) return time + 1;

                visited[next - op - 1] = true;
                q.add(next);
            }
        }
        ++time;
    }
    return time;
}