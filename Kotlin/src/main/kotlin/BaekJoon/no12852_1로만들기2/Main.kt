package BaekJoon.no12852_1로만들기2

// BFS
import java.util.LinkedList

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder();
    val n = readLine().toInt();

    val q = LinkedList<ArrayList<Int>>();
    q.add(arrayListOf(n));
    while (!q.isEmpty()) {
        val cur = q.poll();
        if (cur.last() == 1) {
            sb.append("${cur.size - 1}\n");
            for (i in cur) {
                sb.append("$i ");
            }
            print(sb);
            break;
        }

        if (cur.last() % 3 == 0) {
            val tmp = cur.toMutableList();
            tmp.add(cur.last() / 3);
            q.add(tmp as ArrayList<Int>);
        }

        if (cur.last() % 2 == 0) {
            val tmp = cur.toMutableList();
            tmp.add(cur.last() / 2);
            q.add(tmp as ArrayList<Int>);
        }

        cur.add(cur.last() - 1);
        q.add(cur);
    }
}