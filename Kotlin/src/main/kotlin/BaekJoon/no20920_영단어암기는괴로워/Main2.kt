package BaekJoon.no20920_영단어암기는괴로워

import java.util.PriorityQueue

data class Voca(val word: String, val cnt: Int) : Comparable<Voca> {
    override fun compareTo(other: Voca): Int {
        return if (cnt != other.cnt) other.cnt - cnt
        else if (word.length != other.word.length) other.word.length - word.length
        else word.compareTo(other.word)
    }
}

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val save = HashMap<String, Int>()
    repeat(n) {
        val temp = readLine()
        if (temp.length < m) return@repeat
        save[temp] = save.getOrDefault(temp, 0) + 1
    }

    val pq = PriorityQueue<Voca>()
    for ((k, v) in save) pq.add(Voca(k, v))

    val sb = StringBuilder()
    while (pq.isNotEmpty()) sb.append(pq.poll().word).appendLine()
    print(sb)
}
