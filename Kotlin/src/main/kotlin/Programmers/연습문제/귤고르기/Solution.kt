package Programmers.연습문제.귤고르기

fun main() {
    val k = 6
    val tangerine = intArrayOf(1, 3, 2, 5, 4, 5, 2, 3)
    print(solution(k, tangerine))
}

fun solution(k: Int, tangerine: IntArray): Int {
    val cnt = HashMap<Int, Int>()
    var res = 0
    var x = 0

    for (t in tangerine) cnt[t] = cnt.getOrDefault(t, 0) + 1
    val temp = cnt.values.sortedDescending()

    for (i in temp) {
        ++res
        x += i
        if (x >= k) break
    }
    
//    val temp = tangerine.groupBy { it }.values.sortedByDescending { it.size }
//
//    for (i in temp) {
//        ++res
//        x += i.size
//        if (x >= k) break
//    }

    return res


}