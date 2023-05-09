package BaekJoon.no6588_골드바흐의추측

fun main() = with(System.`in`.bufferedReader()) {
    val range = 1000001;
    val nums = BooleanArray(range);
    val prime = ArrayList<Int>();

    for (i in 2 until range) {
        if (nums[i]) continue;
        prime.add(i);

        var idx = 2;
        while (i * idx < range) nums[i * idx++] = true;
    }

    val sb = StringBuilder();
    while (true) {
        val n = readLine().toInt();
        if (n == 0) break;

        for (i in prime) {
            if (!nums[n -i]) {
                sb.append("$n = $i + ${n - i}").appendLine();
                break;
            }
        }
    }
    print(sb);
}
