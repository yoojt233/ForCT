package BaekJoon.no1041_주사위

import kotlin.math.min;

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toLong();
    val nums = readLine().split(" ").map { it.toInt() }.toIntArray();
    var sum = 0L;

    if (n != 1L) {
        val side = IntArray(3);
        side[0] = min(nums[0], nums[5]); side[1] = min(nums[1], nums[4]); side[2] = min(nums[2], nums[3]);
        side.sort();
        sum = (5 * n * n - 8 * n + 4) * side[0] + 8 * (n - 1) * side[1] + 4 * side[2];
    } else {
        nums.sort();
        for(i in 0 until 5) sum += nums[i];
    }
    print(sum);
}
