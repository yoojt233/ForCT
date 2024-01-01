package BaekJoon.no1431_시리얼번호

import java.util.PriorityQueue

data class SerialNumber(val name: String, val num: Int) : Comparable<SerialNumber> {
    override fun compareTo(other: SerialNumber): Int {
        return if (name.length != other.name.length) name.length - other.name.length
        else if (num != other.num) num - other.num
        else name.compareTo(other.name)
    }
}

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    val n = readLine().toInt()
    val pq = PriorityQueue<SerialNumber>()

    repeat(n) {
        val temp = readLine()
        pq.add(SerialNumber(temp, temp.filter { it in '0'..'9' }.sumOf { it.digitToInt() }))
    }

    while (pq.isNotEmpty()) sb.append("${pq.poll().name}\n")
    print(sb)
}
