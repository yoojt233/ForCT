package BaekJoon.no4803_트리

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    var case = 1

    fun find(parent: IntArray, x: Int): Int {
        if (parent[x] != x) parent[x] = find(parent, parent[x])
        return parent[x]
    }

    fun union(parent: IntArray, x: Int, y: Int) {
        val rootA = find(parent, x)
        val rootB = find(parent, y)

        parent[rootB] = rootA
    }

    while (true) {
        val (n, m) = readLine().split(" ").map { it.toInt() }
        if (n == 0 && m == 0) break

        val parent = IntArray(n + 1) { it }
        val except = HashSet<Int>()

        for (i in 0 until m) {
            val (a, b) = readLine().split(" ").map { it.toInt() }

            if (find(parent, a) == find(parent, b)) {
                except.add(a)
                continue
            }

            union(parent, a, b)
        }

        val temp = (parent.map { find(parent, it) }.toSet() - except.map { find(parent, it) }.toSet()).size - 1
        sb.append("Case ${case++}: ")
        when (temp) {
            0 -> sb.append("No trees.\n")
            1 -> sb.append("There is one tree.\n")
            else -> sb.append("A forest of $temp trees.\n")
        }
    }

    print(sb)
}
