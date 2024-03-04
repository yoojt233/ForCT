package BaekJoon.no1132_합

import kotlin.math.pow

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val words = Array(n) { readLine() }.sortedWith(compareByDescending<String> { it!!.length }.thenByDescending { it })

    val isFirst = BooleanArray(10)
    val cnt = HashMap<Char, Long>()

    for (word in words) {
        isFirst[convert(word[0])] = true
        calc(word, cnt)
    }

    val temp = cnt.keys.sortedByDescending { cnt[it] }.toMutableList()

    if (temp.size == 10 && isFirst[convert(temp.last())]) {
        for (i in 8 downTo 0) {
            if (isFirst[convert(temp[i])]) continue

            val x = temp[i]
            temp.removeAt(i)
            temp.add(x)
            break
        }
    }

    var highest = 9
    var ans = 0L
    for (c in temp) ans += (cnt[c]!! * highest--)

    print(ans)
}

fun convert(c: Char): Int {
    return c - 'A'
}

fun calc(word: String, cnt: HashMap<Char, Long>) {
    val len = word.length

    for (i in word.indices) {
        val c = word[i]
        val digit = ((10.0).pow(len - i - 1)).toLong()

        cnt[c] = cnt.getOrDefault(c, 0) + digit
    }
}
