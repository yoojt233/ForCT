package BaekJoon.no1059_좋은구간

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt();
    val nums = readLine().split(" ").map { it.toInt() }.sorted();
    val target = readLine().toInt();

    val idx = nums.binarySearch(target);
    var sum = 0;
    if (idx < 0) {
        val opIdx = -(idx + 2);
        val edIdx = -(idx + 1);

        val op = if (opIdx >= 0) nums[opIdx] else 0;
        val ed = nums[edIdx];
        sum = -(target - op) * (target - ed) - 1;
    }
    print(sum);
}