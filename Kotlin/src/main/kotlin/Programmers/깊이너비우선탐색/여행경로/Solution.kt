package Programmers.깊이너비우선탐색.여행경로

data class Ticket(val to: String, var available: Boolean = false)

class Solution {
    fun solution(tickets: Array<Array<String>>): Array<String> {
        val map = HashMap<String, ArrayList<Ticket>>()
        var res = arrayOf<String>()
        var flag = false

        for (ticket in tickets) {
            if (!map.containsKey(ticket[0])) map[ticket[0]] = ArrayList()
            map[ticket[0]]!!.add(Ticket(ticket[1]))
        }

        for (key in map.keys) map[key]!!.sortBy { it.to }

        fun dfs(level: Int, from: String, order: Array<String>) {
            if (flag) return

            if (level == tickets.size) {
                res = order.clone()
                flag = true
                return
            }

            if (!map.containsKey(from)) return

            for (t in map[from]!!) {
                if (flag) break
                if (t.available) continue

                t.available = true
                order[level + 1] = t.to
                dfs(level + 1, t.to, order)
                t.available = false
            }
        }

        dfs(0, "ICN", Array(tickets.size + 1) { "ICN" })

        return res
    }
}

fun main() {
    val tickets = arrayOf(
        arrayOf("ICN", "SFO"), arrayOf("ICN", "ATL"), arrayOf("SFO", "ATL"),
        arrayOf("ATL", "ICN"), arrayOf("ATL", "SFO")
    )

    val res = Solution().solution(tickets)
    res.forEach { print("$it ") }
}
