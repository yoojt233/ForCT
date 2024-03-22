package BaekJoon.no16922_로마숫자만들기

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val ables = Array(n) { HashSet<Int>() }

    ables[0] = hashSetOf(1, 5, 10, 50)
    for (i in 1 until n) {
        for (prev in ables[i - 1]) {
            for (num in ables[0]) ables[i].add(prev + num)
        }
    }

    print(ables[n - 1].size)
}
