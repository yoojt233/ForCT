package BaekJoon.no25180_썸팰린드롬

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt();
    var ans = (n - 1) / 9 + 1;
    if (ans % 2 == 0 && n % 2 != 0) ++ans;
    print(ans);
}