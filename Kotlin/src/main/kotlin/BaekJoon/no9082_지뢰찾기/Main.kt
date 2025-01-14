package BaekJoon.no9082_지뢰찾기

fun main() = with(System.`in`.bufferedReader()) {
    val t = readLine()!!.toInt()

    repeat(t) {
        val n = readLine().toInt()
        val cnts = readLine().toCharArray().map { it.digitToInt() }.toIntArray()
        readLine().toCharArray()

        var ans = 0
        var i = 0

        OUT@ while (i < n) {
            if (cnts[i] == 0) {
                i += 2
                continue@OUT
            }

            if (i == 0 && cnts[i] != 0 && cnts[i + 1] != 0) {
                --cnts[i]
                --cnts[i + 1]
                ++ans
            } else if (i == n - 1 && cnts[i - 1] != 0 && cnts[i] != 0) {
                --cnts[i]
                --cnts[i - 1]
                ++ans
            } else if (i > 0 && i < n - 1 && cnts[i - 1] != 0 && cnts[i] != 0 && cnts[i + 1] != 0) {
                --cnts[i - 1]
                --cnts[i]
                --cnts[i + 1]
                ++ans
            }

            ++i
        }

        println(ans)
    }
}
