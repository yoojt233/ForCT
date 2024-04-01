package BaekJoon.no3758_KCPC

import kotlin.math.max

fun main() = with(System.`in`.bufferedReader()) {
    val t = readLine().toInt()
    val sb = StringBuilder()
    repeat(t) {
        val (n, k, me, m) = readLine().split(" ").map { it.toInt() }
        val teams = Array(n) { Team(IntArray(k + 1), it, 0, 0, 0) }
        repeat(m) {
            val (id, i, s) = readLine().split(" ").map { v -> v.toInt() }
            val cur = teams[id - 1]
            cur.scores[i] = max(cur.scores[i], s)
            ++cur.chance
            cur.last = it
        }

        for (team in teams) team.getTotal()
        teams.sort()

        for (i in teams.indices) {
            if (teams[i].id == me - 1) {
                sb.append("${i + 1}\n")
                break
            }
        }
    }
    print(sb)
}

data class Team(val scores: IntArray, val id: Int, var total: Int, var chance: Int, var last: Int) : Comparable<Team> {
    fun getTotal() {
        total = scores.sum()
    }

    override fun compareTo(other: Team): Int {
        return if (total != other.total) other.total - total
        else if (chance != other.chance) chance - other.chance
        else last - other.last
    }
}
