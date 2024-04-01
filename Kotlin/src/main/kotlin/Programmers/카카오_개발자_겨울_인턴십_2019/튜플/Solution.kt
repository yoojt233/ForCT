package Programmers.카카오_개발자_겨울_인턴십_2019.튜플

fun main() {
    val s = "{{1,2,3},{2,1},{1,2,4,3},{2}}"
    solution(s).forEach { print("$it\n") }
}


data class Group(val lists: IntArray) : Comparable<Group> {
    constructor(input: String) : this(input.split(",").map { it.toInt() }.toIntArray())

    override fun compareTo(other: Group): Int {
        return lists.size - other.lists.size
    }
}

fun solution(s: String): IntArray {
    val temp = s.substring(2, s.length - 2).split("},{")
    val groups = ArrayList<Group>()

    for (t in temp) groups.add(Group(t))

    groups.sort()

    val res = IntArray(groups.size)
    val set = HashSet<Int>()

    for (i in groups.indices) {
        for (v in groups[i].lists) {
            if (set.contains(v)) continue
            set.add(v)
            res[i] = v
            break
        }
    }

    return res
}
