package BaekJoon.no4195_친구네트워크

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    repeat(readLine().toInt()) {
        val parent = ArrayList<Int>()
        val name = HashMap<String, Int>()
        val children = HashMap<Int, Int>()
        var init = 0

        repeat(readLine().toInt()) {
            val (m1, m2) = readLine().split(" ")
            val a = name.computeIfAbsent(m1) {
                parent.add(init)
                children[init] = 1
                init++
            }
            val b = name.computeIfAbsent(m2) {
                parent.add(init)
                children[init] = 1
                init++
            }

            sb.append("${union(parent, children, a, b)}\n")
        }
    }
    print(sb)
}

fun union(parent: ArrayList<Int>, children: HashMap<Int, Int>, a: Int, b: Int): Int {
    val ra = find(parent, a)
    val rb = find(parent, b)

    val na = children[ra]!!
    if (ra == rb) return na

    val nb = children[rb]!!
    if (na >= nb) {
        parent[rb] = ra
        children[ra] = na + nb
    } else {
        parent[ra] = rb
        children[rb] = na + nb
    }
    return na + nb
}

fun find(parent: ArrayList<Int>, x: Int): Int {
    if (parent[x] == x) return x
    parent[x] = find(parent, parent[x])
    return parent[x]
}