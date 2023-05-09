package BaekJoon.no12904_A와B

fun main() = with(System.`in`.bufferedReader()) {
    val origin = readLine().toCharArray();
    val target = readLine().toCharArray();

    fun flip(ed: Int) {
        var temp = "";
        for (i in 0 until ed) temp += target[i];
        temp = temp.reversed();

        for (i in 0 until ed) {
            target[i] = temp[i];
        }
    }

    for (i in target.size - 1 downTo origin.size) {
        if (target[i] == 'B') flip(i);
    }

    var flag = true;
    for (i in origin.indices) {
        if (origin[i] != target[i]) {
            flag = false;
            break;
        }
    }
    print(if (flag) 1 else 0);
}