package BaekJoon.no25918_북극곰은괄호를찢어

import kotlin.math.abs
import kotlin.math.max

fun main() = with(System.`in`.bufferedReader()) {
    readLine();
    val input = readLine();

    var cnt = 0;
    var day = 0;
    for (c in input) {
        if (c == '(') cnt += 1;
        else cnt -= 1;
        day = max(day, abs(cnt));
    }
    print(if (cnt == 0) day else -1)
}
