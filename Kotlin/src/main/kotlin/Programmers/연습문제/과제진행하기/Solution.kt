package Programmers.연습문제.과제진행하기

import java.util.Stack

class Solution {
    data class Sub(val name: String, val remain: Int)

    fun solution(plans: Array<Array<String>>): Array<String> {
        val res = ArrayList<String>()
        val stack = Stack<Sub>()

        var cur = 0

        plans.sortedBy { it[1] }.forEach { (name, time, cost) ->
            val t = transTime(time)

            while (stack.isNotEmpty()) {
                val (n, remain) = stack.pop()

                if (cur + remain <= t) {
                    cur += remain
                    res.add(n)
                } else {
                    stack.add(Sub(n, cur + remain - t))
                    break
                }
            }

            stack.add(Sub(name, cost.toInt()))
            cur = t
        }

        while (stack.isNotEmpty()) res.add(stack.pop().name)

        return res.toTypedArray()
    }

    fun transTime(time: String): Int {
        val (hour, minute) = time.split(":").map { it.toInt() }
        return hour * 60 + minute
    }
}

fun main() {
    val plans = arrayOf(
        arrayOf("science", "12:40", "50"),
        arrayOf("music", "12:20", "40"),
        arrayOf("history", "14:00", "30"),
        arrayOf("computer", "12:30", "100")
    )

    Solution().solution(plans).forEach { println(it) }
}
