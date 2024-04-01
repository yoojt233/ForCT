package BaekJoon.no3015_오아시스재결합

import java.util.Stack

data class Number(val num: Int, var cnt: Int)

fun main() = with(System.`in`.bufferedReader()) {
    var res = 0L
    val stack = Stack<Number>()

    repeat(readLine().toInt()) {
        val cur = readLine().toInt()
        if (stack.isEmpty()) stack.add(Number(cur, 1))
        else {
            if (stack.peek().num > cur) {
                ++res
                stack.add(Number(cur, 1))
            } else {
                while (stack.isNotEmpty() && stack.peek().num < cur) res += stack.pop().cnt
                if (stack.isNotEmpty()) {
                    if (stack.peek().num == cur) res += stack.peek().cnt++
                    else stack.add(Number(cur, 1))
                    if (stack.size > 1) ++res
                } else stack.add(Number(cur, 1))
            }
        }
    }
    print(res)
}
