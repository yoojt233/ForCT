package BaekJoon.no1205_등수구하기

fun main() = with(System.`in`.bufferedReader()) {
    val input = readLine().split(" ").map { x -> x.toInt() }.toIntArray();
    var ranking = Array(input[2], { -1 });
    var ans = 1;

    if (input[0] != 0) {
        val origin = readLine().split(" ");
        for (i in origin.indices) {
            ranking[i] = origin[i].toInt();
        }

        if(input[1] <= ranking[input[2] - 1]) {
            ans = -1;
        } else {
            for(i in ranking.indices) {
                if(input[1] >= ranking[i]) {
                    ans = i + 1;
                    break;
                }
            }
        }
    }

    println(ans);
}