package BaekJoon.no5639_이진검색트리

fun main() = with(System.`in`.bufferedReader()) {
    val root = Node(null, 0, null);

    while (true) {
        val input = readLine() ?: break;

        if (root.number == 0) root.number = input.toInt();
        else dfs(root, input.toInt());
    }

    val sb = StringBuilder();
    fun search(parent: Node) {
        if (parent.left != null) search(parent.left!!);
        if (parent.right != null) search(parent.right!!);

        sb.append("${parent.number}\n");
    }
    search(root);
    print(sb);
}

fun dfs(parent: Node, num: Int) {
    if (parent.number > num) {
        if (parent.left == null) parent.left = Node(null, num, null) else dfs(parent.left!!, num);
    } else {
        if (parent.right == null) parent.right = Node(null, num, null) else dfs(parent.right!!, num);
    }
}

data class Node(
    var left: Node?,
    var number: Int,
    var right: Node?
)