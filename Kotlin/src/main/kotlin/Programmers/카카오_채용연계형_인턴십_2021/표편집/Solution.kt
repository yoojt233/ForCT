package Programmers.카카오_채용연계형_인턴십_2021.표편집

import java.util.Stack

class Solution {
    fun solution(n: Int, k: Int, cmd: Array<String>): String {
        val prevs = Stack<Int>()
        var cur = k
        var remain = n

        for (command in cmd) {
            val c = command.split(" ")

            when (c[0]) {
                "U" -> cur -= c[1].toInt()
                "D" -> cur += c[1].toInt()
                "C" -> {
                    prevs.add(cur)
                    if (cur == --remain) --cur
                }
                "Z" -> {
                    ++remain
                    if (prevs.pop() <= cur) ++cur
                }
            }
        }

        val res = StringBuilder()

        repeat(remain) {
            res.append("O")
        }
        while (prevs.isNotEmpty()) res.insert(prevs.pop(), "X")

        return res.toString()
    }
}

fun main() {
    val n = 8
    val k = 2
    val cmd = arrayOf("D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z", "U 1", "C")

    print(Solution().solution(n, k, cmd))
}
