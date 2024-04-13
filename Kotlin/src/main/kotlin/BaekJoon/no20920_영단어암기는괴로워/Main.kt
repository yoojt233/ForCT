package BaekJoon.no20920_영단어암기는괴로워

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val dict = HashMap<String, Int>()

    repeat(n) {
        val temp = readLine()
        if (temp.length >= m) dict[temp] = dict.getOrDefault(temp, 0) + 1
    }

    val res =
        dict.keys.sortedWith(compareByDescending<String> { dict[it] }.thenByDescending { it.length }.thenBy { it })

    val sb = StringBuilder()
    res.forEach { sb.append("$it\n") }
    print(sb)
}