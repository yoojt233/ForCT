package BaekJoon.no1448_삼각형만들기

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt();
    val nums = IntArray(n);

    repeat(n) {
        nums[it] = readLine().toInt();
    }
    nums.sort();

    var last = n - 3;
    var ans = -1;
    while (last >= 0) {
        val lines = Triple(nums[last], nums[last + 1], nums[last + 2]);
        if (lines.third < lines.first + lines.second) {
            ans = lines.first + lines.second + lines.third;
            break;
        }
        --last;
    }
    print(ans);
}