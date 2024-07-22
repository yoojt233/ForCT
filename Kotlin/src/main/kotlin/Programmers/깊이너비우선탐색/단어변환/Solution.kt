package Programmers.깊이너비우선탐색.단어변환

fun main() {
    val (begin, target) = arrayOf("hit", "cog")
    val words = arrayOf("hot", "dot", "dog", "lot", "log", "cog")

    print(Solution().solution(begin, target, words))
}

class Solution {
    fun solution(begin: String, target: String, words: Array<String>): Int {
        val dict = HashSet<String>()
        val alphas = HashMap<Int, HashMap<Char, Boolean>>()

        for (i in begin.indices) alphas[i] = HashMap()

        for (word in words) {
            dict.add(word)

            for (i in word.indices) {
                if (!alphas[i]!!.containsKey(word[i])) alphas[i]!![word[i]] = false
            }
        }

        if (!dict.contains(target)) return 0

        var ans = Int.MAX_VALUE
        var arr = begin.toCharArray()

        fun dfs(level: Int) {
            if (level > ans) return

            if (arr.joinToString("") == target) {
                ans = level
                return
            }

            for (i in begin.indices) {
                for (c in alphas[i]!!.keys) {
                    if (c == arr[i] || alphas[i]!![c] == true) continue

                    val temp = arr[i]
                    arr[i] = c
                    alphas[i]!![c] = true

                    val next = arr.joinToString("")
                    if (dict.contains(next)) dfs(level + 1)

                    arr[i] = temp
                    alphas[i]!![c] = false
                }
            }
        }

        dfs(0)

        return if (ans != Int.MAX_VALUE) ans else 0
    }
}
