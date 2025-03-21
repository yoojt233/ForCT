package Programmers.카카오_개발자_겨울_인턴십_2019.불량사용자

fun main() {
    val user_id = arrayOf("frodo", "fradi", "crodo", "abc123", "frodoc")
    val banned_id = arrayOf("fr*d*", "abc1**")

    print(Solution().solution(user_id, banned_id))
}

class Solution {
    val res = HashSet<String>()

    fun solution(user_id: Array<String>, banned_id: Array<String>): Int {
        val possible = Array(banned_id.size) { ArrayList<Int>() }

        for (i in banned_id.indices) {
            val nomanner = banned_id[i]

            for (j in user_id.indices) {
                val id = user_id[j]

                if ((nomanner.length == id.length) && isBanned(nomanner, id)) possible[i].add(j)
            }
        }

        combo(0, possible, HashSet())

        return res.size
    }

    fun combo(idx: Int, possible: Array<ArrayList<Int>>, sel: HashSet<Int>) {
        if (idx == possible.size) {
            var temp = ""

            sel.toIntArray().sorted().forEach { temp += it.toString() }
            res.add(temp)

            return
        }

        for (candidate in possible[idx]) {
            if (sel.contains(candidate)) continue

            sel.add(candidate)
            combo(idx + 1, possible, sel)
            sel.remove(candidate)
        }
    }

    fun isBanned(enc: String, origin: String): Boolean {
        for (i in 0 until enc.length) {
            if (enc[i] == '*' || enc[i] == origin[i]) continue

            return false
        }

        return true
    }
}
