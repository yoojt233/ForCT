package BaekJoon.no10845_큐

import java.util.LinkedList

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder();
    val q = LinkedList<String>();
    repeat(readLine().toInt()) {
        val cmd = readLine().split(" ");
        when (cmd[0]) {
            "push" -> q.add(cmd[1]);
            "pop" -> sb.append(if (q.isEmpty()) -1 else q.pop()).append("\n");
            "size" -> sb.append("${q.size}\n");
            "empty" -> sb.append(if (q.isEmpty()) 1 else 0).append("\n");
            "front" -> sb.append(if (q.isEmpty()) -1 else q.first).append("\n");
            "back" -> sb.append(if (q.isEmpty()) -1 else q.last).append("\n");
        }
    }

    print(sb);
}