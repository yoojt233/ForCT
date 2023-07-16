package BaekJoon.no2230_수고르기

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val nums = IntArray(n);
    repeat(n) {
        nums[it] = readLine().toInt();
    }

    nums.sort();
    var ans = nums[n - 1] - nums[0];

    var op = 0;
    var ed = 0;
    while (op < n && ed < n) {
        val diff = nums[ed] - nums[op];
        if (diff < m) ++ed;
        else {
            if (diff < ans) ans = diff;
            ++op;
        }
    }

    print(ans);
}