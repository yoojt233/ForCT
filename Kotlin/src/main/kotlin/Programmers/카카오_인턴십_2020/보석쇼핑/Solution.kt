package Programmers.카카오_인턴십_2020.보석쇼핑

class Solution {
    fun solution(gems: Array<String>): IntArray {
        val res = intArrayOf(1, gems.size + 1)
        val bag = HashSet<String>()
        val species = gems.toHashSet()
        val dict = HashMap<String, Int>()

        var op = 0

        for (gem in species) dict[gem] = 0

        for (i in gems.indices) {
            val cur = gems[i]

            dict[cur] = dict[cur]!! + 1

            if (bag.contains(cur)) {
                while (dict[gems[op]]!! > 1) {
                    dict[gems[op]] = dict[gems[op]]!! - 1
                    op++
                }
            }

            bag.add(cur)

            if (bag.size == species.size && i - op < res[1] - res[0]) {
                res[0] = op + 1
                res[1] = i + 1
            }
        }

        return res
    }
}

fun main() {
    val gems = arrayOf(
        "A", "A", "A", "B", "B"
    )

    Solution().solution(gems).forEach { print("$it ") }
}