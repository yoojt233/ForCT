package Programmers.KAKAO_BLIND_RECRUITMENT_2019.길찾기게임

fun main() {
    val nodeinfo = arrayOf(
        intArrayOf(5, 3), intArrayOf(11, 5),
        intArrayOf(13, 3), intArrayOf(3, 5),
        intArrayOf(6, 1), intArrayOf(1, 3),
        intArrayOf(8, 6), intArrayOf(7, 2),
        intArrayOf(2, 2)
    )

    for (order in Solution().solution(nodeinfo)) {
        order.forEach { print("$it ") }
        println()
    }
}

data class Node(val idx: Int, val x: Int, val y: Int, var left: Node?, var right: Node?) : Comparable<Node> {
    constructor(idx: Int, x: Int, y: Int) : this(idx, x, y, null, null)

    override fun compareTo(other: Node): Int {
        return if (y != other.y) other.y - y
        else x - other.x
    }
}

class Tree(val root: Node) {
    val pre = ArrayList<Int>()
    val post = ArrayList<Int>()

    fun insert(cur: Node, node: Node) {
        if (cur.x >= node.x) {
            if (cur.left == null) cur.left = node
            else insert(cur.left!!, node)
        } else {
            if (cur.right == null) cur.right = node
            else insert(cur.right!!, node)
        }
    }

    fun find(cur: Node?) {
        if (cur == null) return

        pre.add(cur.idx)
        find(cur.left)
        find(cur.right)
        post.add(cur.idx)
    }
}

class Solution {
    fun solution(nodeinfo: Array<IntArray>): Array<IntArray> {
        val nodes = nodeinfo.mapIndexed { idx, pos -> Node(idx + 1, pos[0], pos[1]) }.sorted()
        val tree = Tree(nodes[0])

        for (i in 1 until nodes.size) tree.insert(tree.root, nodes[i])
        tree.find(tree.root)

        return arrayOf(tree.pre.toIntArray(), tree.post.toIntArray())
    }
}
