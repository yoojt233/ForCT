package BaekJoon.no16934_게임닉네임

data class Trie(var isEnd: Boolean, val children: Array<Trie?>) {
    constructor() : this(false, Array(26) { null })
}

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    val root = Trie()
    val exist = HashMap<String, Int>()
    val n = readLine().toInt()

    fun insert(nickname: String): String {
        var res = -1
        var temp = root

        for (x in nickname.indices) {
            val ascii = nickname[x] - 'a'

            if (temp.children[ascii] == null) {
                temp.children[ascii] = Trie()
                if (res == -1) res = x
            }

            temp = temp.children[ascii]!!
        }
        temp.isEnd = true

        return if (res != -1) nickname.substring(0, res + 1) else nickname
    }

    repeat(n) {
        val temp = readLine()

        if (exist.containsKey(temp)) {
            val chance = exist[temp]!! + 1

            sb.append("$temp$chance\n")
            exist[temp] = chance
        } else {
            exist[temp] = 1
            sb.append("${insert(temp)}\n")
        }
    }

    print(sb)
}
