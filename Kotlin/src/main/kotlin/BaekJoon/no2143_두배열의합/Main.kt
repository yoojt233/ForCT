package BaekJoon.no2143_두배열의합

data class arr(
    val len: Int,
    val values: List<Int>,
    val sums: LongArray
)

fun main() = with(System.`in`.bufferedReader()) {
    val t = readLine().toInt();
    val a = init(readLine().toInt(), readLine());
    val b = init(readLine().toInt(), readLine());

    val aGroup = getPoss(a);

    var ans = 0L;
    for (i in 1..b.len) {
        for (j in i..b.len) {
            val want = b.sums[j] - b.sums[i - 1];
            ans += aGroup.getOrDefault(t - want, 0);
        }
    }
    print(ans);
}

fun getPoss(x: arr): HashMap<Long, Long> {
    val res = HashMap<Long, Long>();
    var op = 0;
    var ed = 1;
    while (op < x.len) {
        val tmp = x.sums[ed] - x.sums[op];
        res[tmp] = res.getOrDefault(tmp, 0) + 1;
        ++ed;
        if (ed > x.len) {
            ++op;
            ed = op + 1;
        }
    }
    return res;
}

fun init(len: Int, nums: String): arr {
    val values = nums.split(" ").map { it.toInt() };
    val sums = LongArray(len + 1);
    repeat(len) {
        sums[it + 1] = sums[it] + values[it];
    }
    return arr(len, values, sums);
}
