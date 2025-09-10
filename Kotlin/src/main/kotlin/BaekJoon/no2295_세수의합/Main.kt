package BaekJoon.no2295_세수의합

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val num = IntArray(n) { readLine().toInt() }.sortedArray()
    // a + b
    val plus = buildList {
        for (i in num.indices) {
            for (j in num.indices) {
                add(num[i] + num[j])
            }
        }
    }.sorted()

    // c = d - (a + b)
    OUT@ for (i in num.indices.reversed()) {
        val d = num[i]

        for (p in plus) {
            if (p >= d) break
            if (num.binarySearch(d - p) >= 0) {
                print(d)
                break@OUT
            }
        }
    }
}
