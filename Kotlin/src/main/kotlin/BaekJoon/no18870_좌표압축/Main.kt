package BaekJoon.no18870_좌표압축

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine();

    val origin = readLine().split(" ").map { it.toInt() };
    val tmp = origin.sorted().distinct();

    val rank = HashMap<Int, Int>();
    for (i in tmp.indices) {
        rank[tmp[i]] = i;
    }

    val sb = StringBuilder();
    for (i in origin) {
        sb.append("${rank[i]} ");
    }
    print(sb);
}