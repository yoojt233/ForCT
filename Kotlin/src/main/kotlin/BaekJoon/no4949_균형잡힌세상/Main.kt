package BaekJoon.no4949_균형잡힌세상

import java.util.Stack

fun main() = with(System.`in`.bufferedReader()) {
    var str = readLine();
    val sb = StringBuilder();

    while (!str.equals(".")) {
        val stack = Stack<Char>();
        str.replace(" ", "");
        val tmp = str.toCharArray();
        var flag = true;

        for (s in tmp) {
            if (s == '(' || s == '[') {
                stack.push(s);
            } else if (s == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    flag = false;
                    break;
                }
            } else if (s == ']') {
                if (!stack.isEmpty() && stack.peek() == '[') {
                    stack.pop();
                } else {
                    flag = false;
                    break;
                }
            }
        }

        if(flag && !stack.isEmpty()) {
            flag = false;
        }

        sb.append(if (flag) "yes\n" else "no\n");
        str = readLine();
    }

    println(sb);
}