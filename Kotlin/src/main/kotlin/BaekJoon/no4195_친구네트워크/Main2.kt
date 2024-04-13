package BaekJoon.no4195_친구네트워크

var parent = intArrayOf(0)
var children = intArrayOf(0)

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    repeat(readLine().toInt()) {
        val n = readLine().toInt()
        parent = IntArray(n * 2) { it }
        children = IntArray(n * 2) { 1 }
        val name = HashMap<String, Int>()
        var init = 0

        repeat(n) {
            val (x, y) = readLine().split(" ")
            val a = name.computeIfAbsent(x) { init++ }
            val b = name.computeIfAbsent(y) { init++ }

            sb.append("${union(a, b)}\n")
        }
    }
    print(sb)
}

fun union(a: Int, b: Int): Int {
    val ra = find(a)
    val rb = find(b)

    return if (ra != rb) {
        val na = children[ra]
        val nb = children[rb]

        if (na >= nb) {
            parent[rb] = ra
            children[ra] += nb
        } else {
            parent[ra] = rb
            children[rb] += na
        }
        na + nb
    } else children[ra]
}


fun find(x: Int): Int {
    return if (parent[x] == x) x
    else {
        parent[x] = find(parent[x])
        parent[x]
    }
}