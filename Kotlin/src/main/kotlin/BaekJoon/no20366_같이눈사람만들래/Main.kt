package BaekJoon.no20366_같이눈사람만들래

import kotlin.math.abs
import kotlin.math.min

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val snow = readLine().split(" ").map { it.toInt() }.toIntArray()

    var ans = Int.MAX_VALUE

    snow.sort()

    OUT@ for (i in 0 until n - 1) {
        for (j in i + 1 until n) {
            val elsa = snow[i] + snow[j]

            var left = 0
            var right = n - 1

            while (left < right) {
                if (left == i || left == j) ++left
                else if (right == i || right == j) --right
                else {
                    val anna = snow[left] + snow[right]
                    val temp = abs(elsa - anna)
                    ans = min(ans, temp)

                    if (anna > elsa) --right
                    else if (anna < elsa) ++left
                    else {
                        ans = 0
                        break@OUT
                    }
                }
            }
        }
    }

    print(ans)
}
