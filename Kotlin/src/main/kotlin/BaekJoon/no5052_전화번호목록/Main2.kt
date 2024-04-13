package BaekJoon.no5052_전화번호목록

import java.util.PriorityQueue

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()

    repeat(readLine().toInt()) {
        val pq = PriorityQueue<String>()
        var flag = true

        repeat(readLine().toInt()) {
            pq.add(readLine())
        }

        while (pq.size > 1) {
            val cur = pq.poll()

            if (pq.peek().startsWith(cur)) {
                flag = false
                break
            }
        }

        sb.append(if (flag) "YES\n" else "NO\n")
    }

    print(sb)
}
