package BaekJoon.no1474_밑줄

import java.util.LinkedList
import java.util.Queue
import java.util.Stack

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val words = Array(n) { "" }
    var total = 0
    val lower: Queue<Int> = LinkedList()
    val upper = Stack<Int>()

    repeat(n) {
        val temp = readLine()
        words[it] = temp
        total += temp.length

        if (it != 0) {
            if (temp[0] in 'A'..'Z') upper.add(it) else lower.add(it)
        }
    }

    var extra = (m - total) % (n - 1)
    var underline = ""
    repeat((m - total) / (n - 1)) {
        underline += "_"
    }

    for (i in 1 until n) words[i] = underline + words[i]
    while (extra-- > 0) {
        val temp = if (lower.isNotEmpty()) lower.poll() else upper.pop()
        words[temp] = "_" + words[temp]
    }

    val sb = StringBuilder()
    words.forEach { word -> sb.append(word) }
    print(sb)
}