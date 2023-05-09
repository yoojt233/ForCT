package BaekJoon.no2473_세용액

import kotlin.math.abs

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt();
    val liquid = readLine().split(" ").map { it.toLong() }.sorted();

    var ans = Triple(0L, 0L, 0L);
    var std = Long.MAX_VALUE;
    for (i in liquid.indices) {
        var left = i + 1;
        var right = n - 1;

        while (left < right) {
            var sum = liquid[i] + liquid[left] + liquid[right];
            if (abs(sum) < std) {
                ans = Triple(liquid[i], liquid[left], liquid[right]);
                std = abs(sum);
            }

            if (sum < 0) ++left; else if (sum > 0) --right; else break;
        }
    }
    print("${ans.first} ${ans.second} ${ans.third}");
}