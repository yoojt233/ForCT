package BaekJoon.no25418_정수a를k로만들기

fun main() = with(System.`in`.bufferedReader()) {
    var (op, ed) = readLine().split(" ").map { it.toInt() };

    var ans = 0;
    while (ed != op) {
        if (ed % 2 == 0 && ed / 2 >= op) ed /= 2 else ed -= 1;
        ++ans;
    }
    print(ans);
}