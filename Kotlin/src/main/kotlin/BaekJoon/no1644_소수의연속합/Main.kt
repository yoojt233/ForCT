package BaekJoon.no1644_소수의연속합

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt();

    val primes = getPrime(n);
    val sums = arrayListOf(0);
    for (i in 0 until primes.size) sums.add(sums[i] + primes[i]);

    var ans = 0;
    var op = 0;
    var ed = 0;
    while (op < sums.size && ed < sums.size) {
        val sum = sums[ed] - sums[op];
        if (sum == n) {
            ++ans;
            ++op;
        } else if (sum < n) ++ed;
        else ++op;
    }
    print(ans);
}

fun getPrime(n: Int): ArrayList<Int> {
    val nums = BooleanArray(n + 1);
    for (i in 2..n) {
        if (!nums[i]) {
            var idx = 2;
            while (i * idx < n + 1) {
                nums[i * idx++] = true;
            }
        }
    }

    val res = ArrayList<Int>();
    for (i in 2..n) {
        if (!nums[i]) res.add(i);
    }

    return res;
}
