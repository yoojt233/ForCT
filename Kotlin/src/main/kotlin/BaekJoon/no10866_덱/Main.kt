package BaekJoon.no10866_덱

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder();

    val dq = ArrayDeque<String>();
    val n = readLine().toInt();
    repeat(n) {
        var cmd = readLine().split(" ");
        when (cmd[0]) {
            "push_front" -> dq.addFirst(cmd[1]);
            "push_back" -> dq.addLast(cmd[1]);
            "pop_front" -> sb.append(if (dq.isEmpty()) -1 else dq.removeFirst()).append("\n");
            "pop_back" -> sb.append(if (dq.isEmpty()) -1 else dq.removeLast()).append("\n");
            "size" -> sb.append(dq.size).append("\n");
            "empty" -> sb.append(if (dq.isEmpty()) 1 else 0).append("\n");
            "front" -> sb.append(if (dq.isEmpty()) -1 else dq.first()).append("\n");
            "back" -> sb.append(if (dq.isEmpty()) -1 else dq.last()).append("\n");
        }
    }
    println(sb);
}

