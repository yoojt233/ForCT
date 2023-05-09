package BaekJoon.no10828_스택

import java.util.Stack

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder();
    val stck = Stack<String>();
    repeat(readLine().toInt()) {
        val cmd = readLine().split(" ");
        when (cmd[0]) {
            "push" -> stck.push(cmd[1]);
            "pop" -> sb.append(if (stck.isEmpty()) -1 else stck.pop()).append("\n");
            "size" -> sb.append("${stck.size}\n");
            "empty" -> sb.append(if (stck.isEmpty()) 1 else 0).append("\n");
            "top" -> sb.append(if (stck.isEmpty()) -1 else stck.peek()).append("\n");
        }
    }
    print(sb);
}