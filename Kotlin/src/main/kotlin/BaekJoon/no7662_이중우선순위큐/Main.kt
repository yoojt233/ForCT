package BaekJoon.no7662_이중우선순위큐

import java.util.TreeMap

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder();

    repeat(readLine().toInt()) {
        var n = readLine().toInt();
        val ts = TreeMap<Int, Int>();

        repeat(n) {
            var (cmd, num) = readLine().split(" ");
            when (cmd) {
                "I" -> ts[num.toInt()] = ts.getOrDefault(num.toInt(), 0) + 1;
                "D" -> if (ts.isNotEmpty()) {
                    if (num == "-1") {
                        val key = ts.firstKey();
                        val remain = ts.getOrDefault(key, 1) - 1;
                        if (remain <= 0) ts.remove(key); else ts[key] = remain;
                    } else {
                        val key = ts.lastKey();
                        val remain = ts.getOrDefault(key, 1) - 1;
                        if (remain <= 0) ts.remove(key); else ts[key] = remain;
                    }
                }
            }
        }
        sb.append(if (ts.isEmpty()) "EMPTY\n" else "${ts.lastKey()} ${ts.firstKey()}\n");
    }
    print(sb);
}

