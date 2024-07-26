package Programmers.KAKAO_BLIND_RECRUITMENT_2021.순위검색

fun main() {
    val info = arrayOf(
        "java backend junior pizza 150",
        "python frontend senior chicken 210",
        "python frontend senior chicken 150",
        "cpp backend senior pizza 260",
        "java backend junior chicken 80",
        "python backend senior chicken 50"
    )

    val query = arrayOf(
        "java and backend and junior and pizza 100",
        "python and frontend and senior and chicken 200",
        "cpp and - and senior and pizza 250",
        "- and backend and senior and - 150",
        "- and - and - and chicken 100",
        "- and - and - and - 150"
    )

    Solution().solution(info, query).forEach { println(it) }
}

class Solution {
    val applicants = HashMap<String, ArrayList<Int>>()

    fun solution(info: Array<String>, query: Array<String>): IntArray {
        val res = IntArray(query.size)

        info.forEach { save(0, "", it.split(" ")) }
        for (key in applicants.keys) applicants[key]!!.sort()

        for (i in query.indices) {
            val cond = query[i].split(" ")
            var key = ""
            var value = cond.last().toInt()

            for (i in 0..6 step 2) key += cond[i]
            res[i] = if (!applicants.containsKey(key)) 0 else binarySearch(applicants[key]!!, value)
        }

        return res
    }

    private fun save(idx: Int, prev: String, input: List<String>) {
        if (idx == 4) {
            if (applicants.containsKey(prev)) applicants[prev]!!.add(input[idx].toInt())
            else {
                val temp = ArrayList<Int>()

                temp.add(input[idx].toInt())
                applicants[prev] = temp
            }

            return
        }

        save(idx + 1, prev + input[idx], input)
        save(idx + 1, "$prev-", input)
    }

    private fun binarySearch(list: ArrayList<Int>, target: Int): Int {
        var (left, right) = intArrayOf(0, list.size - 1)

        while (left <= right) {
            val mid = (left + right) / 2

            if (list[mid] >= target) right = mid - 1
            else left = mid + 1
        }

        return list.size - left
    }
}
