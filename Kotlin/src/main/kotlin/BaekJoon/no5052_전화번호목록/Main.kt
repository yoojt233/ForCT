package BaekJoon.no5052_전화번호목록

data class Trie(var isEnd: Boolean, val children: Array<Trie?>) {
    constructor() : this(false, Array(10) { null })
}

var flag = true

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()

    repeat(readLine().toInt()) {
        flag = true
        val n = readLine().toInt()
        val numbers = Array(n) { "" }
        val root = Trie()

        for (i in 0 until n) numbers[i] = readLine()
        numbers.sort()
        for (number in numbers) {
            insert(root, number)
            if (!flag) break
        }

        sb.append(if (flag) "YES\n" else "NO\n")
    }

    print(sb)
}

fun insert(root: Trie, number: String) {
    var temp = root

    for (x in number) {
        val ascii = x - '0'
        if (temp.children[ascii] == null) temp.children[ascii] = Trie()
        else if (temp.children[ascii]!!.isEnd) {
            flag = false
            return
        }
        temp = temp.children[ascii]!!
    }
    temp.isEnd = true
}