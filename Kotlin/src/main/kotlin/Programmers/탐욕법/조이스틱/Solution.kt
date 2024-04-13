package Programmers.탐욕법.조이스틱

fun main() {
    val name = "JEROEN"
    print(solution(name))
}

fun solution(name: String): Int {
    val ud = IntArray(name.length) { name[it] - 'A' }.map { it.coerceAtMost(26 - it) }
    var lf = name.length - 1

    for (i in name.indices) {
        var next = i + 1

        while (next < name.length && name[next] == 'A') ++next
        lf = minOf(lf, i * 2 + (name.length - next), i + (name.length - next) * 2)
    }

    return ud.sum() + lf
}
