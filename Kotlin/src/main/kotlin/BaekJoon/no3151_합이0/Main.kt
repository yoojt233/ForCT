package BaekJoon.no3151_합이0

import kotlin.math.abs

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt();
    val nums = readLine().split(" ").map { it.toInt() }
    val cnt = IntArray(20001)
    val addValue = 10000

    var ans = 0L

    for (num in nums) cnt[num + addValue]++
    for (i in 0 until n - 1) {
        for (j in i + 1 until n) {
            val temp = nums[i] + nums[j]

            if (abs(temp) > 10000) continue
            ans += (cnt[-temp + addValue] - compare(-temp, nums[i]) - compare(-temp, nums[j]))
        }
    }

    println(ans / 3)
}

fun compare(a: Int, b: Int) = if (a == b) 1 else 0
