package Programmers.스택큐.프로세스

import java.util.LinkedList
import java.util.Queue

fun main() {
    val priorities = intArrayOf(1, 1, 9, 1, 1, 1)
    val location = 0
    print(solution(priorities, location))
}

fun solution(priorities: IntArray, location: Int): Int {
    val cnt = IntArray(101)
    val q: Queue<Pair<Int, Int>> = LinkedList()
    priorities.forEachIndexed { i, v ->
        ++cnt[v]
        q.add(Pair(i, v))
    }

    fun getMax(x: Int): Int {
        var op = x
        while (cnt[op] == 0) --op
        return op
    }

    var target = getMax(100)
    var time = 0
    while (q.isNotEmpty()) {
        val cur = q.poll()

        if (cur.second == target) {
            ++time
            if (cur.first == location) return time
            if (--cnt[target] == 0) target = getMax(target)
        } else q.add(cur)
    }

    return -1
}