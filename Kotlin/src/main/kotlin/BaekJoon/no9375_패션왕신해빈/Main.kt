package BaekJoon.no9375_패션왕신해빈

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder();
    val n = readLine().toInt();
    repeat(n) {
        val items = HashMap<String, ArrayList<String>>();
        val i = readLine().toInt();
        repeat(i) {
            val (item, category) = readLine().split(" ");
            val c = items.getOrDefault(category, ArrayList<String>());
            c.add(item);
            items[category] = c;
        }
        var ans = 1;
        for (x in items) ans *= x.value.size + 1;
        sb.append("${ans - 1}\n");
    }
    print(sb);
}