package Programmers.연습문제.마법의엘리베이터

fun main() {
    val storey = 2554
    print(solution(storey))
}

fun solution(storey: Int): Int {

    fun trimZero(x: Int): Int {
        var res = x

        while (res != 0 && res % 10 == 0) res /= 10
        return res
    }

    var res = 0
    var cur = trimZero(storey)

    while (cur > 0) {
        val temp = cur % 100
        val num = Pair(temp / 10, temp % 10)
        val next = if (num.second > 5) 10 - num.second else num.second

        if (num.second > 5) cur += next
        else if (num.second < 5) cur -= next
        else cur += if (num.first >= 5) next else -next

        res += next
        cur = trimZero(cur / 10)
    }

    return res
}
