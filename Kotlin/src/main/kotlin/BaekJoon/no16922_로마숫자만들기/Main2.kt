package BaekJoon.no16922_로마숫자만들기

val set = HashSet<Int>()

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()

    combo(n, 0, 0, 0, intArrayOf(1, 5, 10, 50))

    print(set.size)
}

fun combo(n: Int, level: Int, idx: Int, sum: Int, num: IntArray) {
    if (level == n) {
        set.add(sum)
        return
    }

    for (i in idx until 4) combo(n, level + 1, i, sum + num[i], num)
}
