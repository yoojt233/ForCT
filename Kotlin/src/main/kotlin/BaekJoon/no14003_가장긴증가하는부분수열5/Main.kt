package BaekJoon.no14003_가장긴증가하는부분수열5

import java.util.Stack

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt();
    val nums = readLine().split(" ").map { it.toInt() };

    val lis = arrayListOf(Int.MIN_VALUE);
    val len = Array(n + 1) { 0 };
    for (i in nums.indices) {
        val cur = nums[i];
        if (cur > lis.last()) {
            lis.add(cur);
            len[i + 1] = lis.size - 1;
        } else {
            var where = lis.binarySearch(cur);
            if (where < 0) where = -where - 1;

            lis[where] = cur;
            len[i + 1] = where;
        }
    }

    var size = lis.size - 1;

    val sb = StringBuilder();
    sb.append("$size\n");

    val stck = Stack<Int>();
    for (i in len.size - 1 downTo 0) {
        if (size == 0) break;
        if (len[i] == size) {
            stck.push(nums[i - 1]);
            --size;
        }
    }

    while (stck.isNotEmpty()) {
        sb.append("${stck.pop()} ");
    }

    print(sb);
}