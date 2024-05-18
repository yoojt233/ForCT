package BaekJoon.no1038_감소하는수

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()

    fun solve(): Long {
        if (n < 10) return n.toLong()
        else if (n >= 1023) return -1

        val q = ArrayDeque<Long>()
        for (i in 0..9) q.add(i.toLong())

        var cnt = 9
        OUT@ while (cnt < n) {
            val cur = q.removeFirst()
            val temp = cur % 10

            for (i in 0 until temp) {
                q.add(cur * 10 + i)
                ++cnt
                if (cnt == n) break@OUT
            }
        }

        return q.removeLast()
    }

    print(solve())
}
