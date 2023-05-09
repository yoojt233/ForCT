package BaekJoon.no9012_괄호

import java.util.Stack

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder();
    repeat(readLine().toInt()) {
        val stck = Stack<Char>();
        var flag = true;
        for (s in readLine()) {
            if (s == ')') {
                if (!stck.isEmpty() && stck.peek() == '(') stck.pop();
                else {
                    flag = false;
                    break;
                };
            } else stck.push(s);
        }
        sb.append(if (flag && stck.isEmpty()) "YES\n" else "NO\n");
    }
    print(sb);
}