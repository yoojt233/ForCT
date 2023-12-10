package BaekJoon.no3649_로봇프로젝트

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()

    while (true) {
        val temp = readLine() ?: break

        val x = temp.toInt() * 10000000
        val n = readLine().toInt()
        val lego = IntArray(n) { readLine().toInt() }
        lego.sort()

        var left = 0
        var right = n - 1
        var flag = false

        while (left < right) {
            val sum = lego[left] + lego[right]
            if (sum == x) {
                flag = true
                sb.append("yes ${lego[left]} ${lego[right]}\n")
                break
            } else if (sum > x) --right
            else ++left
        }

        if (!flag) sb.append("danger\n")
    }

    print(sb)
}