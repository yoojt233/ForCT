package BaekJoon.no7432_디스크트리

import java.util.TreeMap

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt();
    val root = Node(TreeMap<String, Node>());
    repeat(n) {
        val temp = readLine().split("\\");
        var parent = root;
        for (i in temp.indices) {
            if (parent.children.containsKey(temp[i])) parent = parent.children[temp[i]]!!;
            else {
                parent.children[temp[i]] = Node(TreeMap<String, Node>());
                parent = parent.children[temp[i]]!!;
            }
        }
    }

    val sb = StringBuilder();
    dfs(root, sb, 0);
    print(sb);
}

fun dfs(parent: Node, sb: StringBuilder, level: Int) {
    for (key in parent.children.keys) {
        for (i in 0 until level) sb.append(" ");
        sb.append(key).appendLine();
        dfs(parent.children[key]!!, sb, level + 1);
    }
}

class Node(val children: TreeMap<String, Node>)