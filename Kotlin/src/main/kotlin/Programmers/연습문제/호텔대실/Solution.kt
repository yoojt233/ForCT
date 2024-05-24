package Programmers.연습문제.호텔대실

data class Reservation(val op: Int, val ed: Int) : Comparable<Reservation> {
    constructor(a: List<Int>, b: List<Int>) : this(a[0] * 100 + a[1], b[0] * 100 + b[1])

    override fun compareTo(other: Reservation): Int {
        return if (op != other.op) op - other.op else ed - other.ed
    }
}


class Solution {
    private fun cleaning(ed: Int): Int {
        var temp = ed % 100 + 10

        if (temp >= 60) temp += 40

        return (ed / 100) * 100 + temp
    }

    fun solution(book_time: Array<Array<String>>): Int {
        val times = ArrayList<Reservation>()
        val reserve = ArrayList<Int>()

        for (t in book_time) {
            val op = t[0].split(":").map { it.toInt() }
            val ed = t[1].split(":").map { it.toInt() }

            times.add(Reservation(op, ed))
        }
        times.sort()

        for (time in times) {
            var flag = true

            for (i in reserve.indices) {
                if (reserve[i] > time.op) continue

                flag = false
                reserve[i] = cleaning(time.ed)
                break
            }

            if (flag) reserve.add(cleaning(time.ed))
        }


        return reserve.size
    }
}

fun main() {
    val book_time = arrayOf(
        arrayOf("10:20", "12:30"),
        arrayOf("10:20", "12:30"),
        arrayOf("10:20", "12:30")
    )
    print(Solution().solution(book_time))
}