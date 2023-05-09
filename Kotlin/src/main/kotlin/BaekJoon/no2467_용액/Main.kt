package BaekJoon.no2467_용액

import kotlin.math.abs

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt();
    val liquid = readLine().split(" ").map { it.toInt() };

    var left = 0;
    var right = n - 1;
    var tmp = Int.MAX_VALUE;

    var ans = Pair(0, 0);
    while (left < right) {
        var sum = liquid[left] + liquid[right];
        if (abs(sum) < tmp) {
            ans = Pair(liquid[left], liquid[right]);
            tmp = abs(sum);
        }

        if (sum < 0) ++left; else if (sum > 0) --right; else break;
    }
    print("${ans.first} ${ans.second}");
}