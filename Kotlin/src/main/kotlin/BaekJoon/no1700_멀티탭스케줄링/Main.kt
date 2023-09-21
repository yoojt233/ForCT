package BaekJoon.no1700_멀티탭스케줄링

import java.util.LinkedList
import java.util.Queue
import java.util.Stack

fun main() = with(System.`in`.bufferedReader()) {
    val (n, k) = readLine().split(" ").map { it.toInt() }
    val elecs = readLine().split(" ").map { it.toInt() }
    val used = BooleanArray(k + 1)
    val q: Queue<Int> = LinkedList()

    for (number in elecs) q.offer(number)

    var using = 0
    var ans = 0
    while (q.isNotEmpty()) {
        val cur = q.poll()

        if (used[cur]) continue
        if (using < n) {
            used[cur] = true
            ++using
        } else {
            val temp = Stack<Int>()
            repeat(q.size) {
                val next = q.poll()
                q.offer(next)
                if (used[next] && next !in temp) temp.push(next)
            }

            if (temp.size == n) used[temp.pop()] = false
            else {
                for (i in used.indices) {
                    if (used[i] && i !in temp) {
                        used[i] = false
                        break
                    }
                }
            }

            used[cur] = true
            ++ans
        }
    }

    print(ans)
}
