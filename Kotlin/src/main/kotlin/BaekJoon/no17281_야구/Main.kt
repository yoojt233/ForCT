package BaekJoon.no17281_야구

import kotlin.math.max

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val hits = Array(n) { readLine().split(" ").map { it.toInt() }.toIntArray() }
    var ans = 0

    fun play(sel: IntArray): Int {
        var score = 0
        var cur = 0

        repeat(n) { i ->
            val runner = BooleanArray(3)
            var out = 0

            while (out < 3) {
                val player = sel[cur]

                when (hits[i][player]) {
                    1 -> {
                        if (runner[2]) ++score

                        runner[2] = runner[1]
                        runner[1] = runner[0]
                        runner[0] = true
                    }

                    2 -> {
                        if (runner[2]) ++score
                        if (runner[1]) ++score

                        runner[2] = runner[0]
                        runner[1] = true
                        runner[0] = false
                    }

                    3 -> {
                        score += runner.count { it }

                        runner[2] = true
                        runner[1] = false
                        runner[0] = false
                    }

                    4 -> {
                        score += (runner.count { it } + 1)

                        runner.fill(false)
                    }

                    else -> ++out
                }

                cur = (cur + 1) % 9
            }
        }

        return score
    }


    fun permu(cnt: Int, sel: IntArray, visited: BooleanArray) {
        if (cnt >= 9) {
            ans = max(ans, play(sel))
            return
        }

        if (cnt == 3) permu(cnt + 1, sel, visited)
        else {
            for (i in 1 until 9) {
                if (visited[i]) continue

                sel[cnt] = i
                visited[i] = true
                permu(cnt + 1, sel, visited)
                visited[i] = false
            }
        }
    }

    permu(0, IntArray(9).apply { this[3] = 0 }, BooleanArray(9))

    print(ans)
}
