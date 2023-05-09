package BaekJoon.no9012_괄호

import java.util.Stack

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder();

    val n = readLine().toInt();
    repeat(n) {
        sb.append(isVPS(readLine())).append("\n");
    }
    println(sb);
}

fun isVPS(line: String?): String {
    val stck = Stack<Char>();
    if (line != null) {
        for (s in line) {
            when (s) {
                '(' -> stck.push(s);
                ')' ->
                    if (!stck.isEmpty() && stck.peek() == '(') stck.pop()
                    else return "NO";
            }
        }
    }
    return if (stck.isEmpty()) "YES" else "NO";
}
