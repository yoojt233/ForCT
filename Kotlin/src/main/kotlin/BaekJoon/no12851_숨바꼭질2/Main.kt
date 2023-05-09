package BaekJoon.no12851_숨바꼭질2

import java.util.LinkedList

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() };
    val visited = Array<Visit?>(100001) { null };

    val q = LinkedList<Int>();
    visited[n] = Visit(0, 1);
    q.add(n);

    while (q.isNotEmpty()) {
        if (visited[m] != null) break;

        val size = q.size;
        val set = HashSet<Int>();
        for (it in 0 until size) {
            val cur = q.poll();
            var next = 0;


            for (i in 0 until 3) {
                when (i) {
                    0 -> next = cur - 1;
                    1 -> next = cur + 1;
                    2 -> next = cur * 2;
                }

                if (next !in visited.indices) continue;

                if (visited[next] == null) {
                    visited[next] = Visit(visited[cur]!!.time + 1, visited[cur]!!.chance);
                } else if (visited[next]!!.time == visited[cur]!!.time + 1) {
                    visited[next]!!.chance += visited[cur]!!.chance;
                } else continue;

                if (next != m) set.add(next);
            }
        }
        for(i in set) q.add(i);
    }

    print("${visited[m]!!.time}\n${visited[m]!!.chance}");
}

data class Visit(var time: Int, var chance: Int);