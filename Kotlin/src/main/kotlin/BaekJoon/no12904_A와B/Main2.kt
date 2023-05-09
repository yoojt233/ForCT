package BaekJoon.no12904_A와B

fun main() = with(System.`in`.bufferedReader()) {
    val origin = readLine();
    val target = StringBuilder(readLine());

    var n = target.length - 1;
    while (origin.length != target.length) {
        val temp = target.last();
        target.deleteCharAt(n);
        if (temp == 'B') target.reverse();
        --n;
    }
    print(if (origin.equals(target.toString())) 1 else 0);
}