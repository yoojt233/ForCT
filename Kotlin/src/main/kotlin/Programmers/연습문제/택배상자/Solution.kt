package Programmers.연습문제.택배상자

import java.util.Stack

fun main() {
    val order = intArrayOf(4, 3, 1, 2, 5)
    print(solution(order))
}

fun solution(order: IntArray): Int {
    var res = 0
    val stack = Stack<Int>()
    var idx = 0
    var num = 1

    while (idx < order.size) {
        val target = order[idx++]

        while (num < target) stack.add(num++)

        if (num++ == target) ++res
        else {
            if (stack.isNotEmpty() && stack.peek() == target) {
                ++res
                stack.pop()
            } else break
        }
    }

    return res
}