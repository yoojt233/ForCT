package Programmers.연습문제.롤케이크자르기

fun main() {
    val topping = intArrayOf(1, 2, 3, 1, 4)
    print(solution(topping))
}


fun solution(topping: IntArray): Int {
    var idx = 0
    val tops = Pair(HashMap<Int, Int>(), HashMap<Int, Int>())
    val cnt = IntArray(2)

    topping_add(topping[idx++], tops.first, cnt, 0)
    for (i in idx until topping.size) topping_add(topping[i], tops.second, cnt, 1)

    var res = if (cnt[0] == cnt[1]) 1 else 0

    while (idx < topping.size) {
        val cur = topping[idx++]

        topping_add(cur, tops.first, cnt, 0)
        topping_remove(cur, tops.second, cnt, 1)

        if (cnt[0] == cnt[1]) ++res
    }

    return res
}

fun topping_add(cur: Int, have: HashMap<Int, Int>, cnt: IntArray, id: Int) {
    val temp = have.getOrDefault(cur, 0)

    if (temp == 0) ++cnt[id]
    have[cur] = temp + 1
}

fun topping_remove(cur: Int, have: HashMap<Int, Int>, cnt: IntArray, id: Int) {
    val temp = have[cur]!!

    if (temp - 1 == 0) {
        have.remove(cur)
        --cnt[id]
    } else have[cur] = temp - 1
}
