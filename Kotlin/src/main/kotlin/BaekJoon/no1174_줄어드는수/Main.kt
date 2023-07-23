package BaekJoon.no1174_줄어드는수

fun main() = with(System.`in`.bufferedReader()) {
    var n = readLine().toInt();

    val nums = intArrayOf(9, 8, 7, 6, 5, 4, 3, 2, 1, 0)
    val possible = HashSet<Long>();

    fun permu(num: Long, idx: Int) {
        if (idx > 10) return;
        possible.add(num);
        for (i in idx until 10) permu(num * 10 + nums[i], i + 1)
    }

    permu(0, 0)
    val ans = possible.toLongArray();
    ans.sort();
    print(if (n > ans.size) -1 else ans[n - 1])
}
