package HackerRank.Search.MissingNumbers

import java.util.PriorityQueue

fun missingNumbers(arr: Array<Int>, brr: Array<Int>, n: Int, m: Int): Array<Int> {
    arr.sort();

    val pq = PriorityQueue<Int>();
    for (i in brr) pq.add(i);

    val res = HashSet<Int>();
    for (i in arr) {
        while (true) {
            val temp = pq.poll();
            if (temp == i) break;
            res.add(temp);
        }
    }

    while (pq.isNotEmpty()) res.add(pq.poll());
    val a = res.toArray();
    a.sort();
    val ans = Array(res.size) { 0 };
    for (i in a.indices) ans[i] = a[i] as Int;
    return ans;
}

fun main(args: Array<String>) {
    val n = readLine()!!.trim().toInt()

    val arr = readLine()!!.trimEnd().split(" ").map { it.toInt() }.toTypedArray()

    val m = readLine()!!.trim().toInt()

    val brr = readLine()!!.trimEnd().split(" ").map { it.toInt() }.toTypedArray()

    val result = missingNumbers(arr, brr, n, m)

    println(result.joinToString(" "))
}