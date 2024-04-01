package BaekJoon.no30426_Rebirth

val unstable = HashSet<Int>()

fun main() = with(System.`in`.bufferedReader()) {
    val (N, cur, K) = readLine().split(" ").map { it.toInt() }
    val quests = Array(K) { Pair(0, 0) }

    repeat(K) { i ->
        val (c, w) = readLine().split(" ").map { it.toInt() }
        quests[i] = Pair(c, w)
    }

    repeat(readLine().toInt()) {
        unstable.add(readLine().toInt())
    }

    var targets = HashSet<Int>()
    targets.add(0)
    for (i in K - 1 downTo 0) {
        val quest = quests[i]
        val temp = HashSet<Int>()
        for (target in targets) bottomUp(N, target, temp, quest)
        targets = temp
    }

    print(if (cur in targets) "utopia" else "dystopia")
}

fun bottomUp(N: Int, target: Int, set: HashSet<Int>, quest: Pair<Int, Int>) {
    val temp = target + N
    var first = temp - quest.first
    var second = temp - quest.second

    while (first < 0) first += N
    while (second < 0) second += N

    if (first % N !in unstable) set.add(first % N)
    if (second % N !in unstable) set.add(second % N)
}