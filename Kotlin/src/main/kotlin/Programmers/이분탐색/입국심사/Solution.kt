package Programmers.이분탐색.입국심사

import kotlin.math.min

fun main() {
    val n = 6
    val times = intArrayOf(7, 10)
    print(solution(n, times))
}

fun solution(n: Int, times: IntArray): Long {
    times.sort()

    var minTime = 1L
    var maxTime = times[0].toLong() * n
    var ans = maxTime

    while (minTime <= maxTime) {
        val mid = (minTime + maxTime) / 2
        var pass = 0

        for (i in times.indices) {
            pass += (mid / times[i]).toInt()
            if (pass >= n) break
        }

        if (pass < n) minTime = mid + 1
        else {
            ans = min(ans, mid)
            maxTime = mid - 1
        }
    }

    return ans
}

