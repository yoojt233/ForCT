package Programmers.KAKAO_BLIND_RECRUITMENT_2022.주차요금계산

import kotlin.math.ceil

fun main() {
    val fees = intArrayOf(120, 0, 60, 591)
    val records = arrayOf("16:00 3961 IN", "16:00 0202 IN", "18:00 3961 OUT", "18:00 0202 OUT", "23:58 3961 IN")

    Solution().solution(fees, records).map { println(it) }
}

class Solution {
    fun solution(fees: IntArray, records: Array<String>): IntArray {
        val limit = 23 * 60 + 59

        val parking = HashMap<String, Int>()
        val res = HashMap<String, Int>()

        for (record in records) {
            val (temp, number, status) = record.split(" ")
            val time = transTime(temp)

            if (status == "IN") parking[number] = time
            else {
                res[number] = res.getOrDefault(number, 0) + (time - parking[number]!!)
                parking.remove(number)
            }
        }

        for ((number, time) in parking) res[number] = res.getOrDefault(number, 0) + (limit - time)

        return res.keys.sorted().map { calc(fees, res[it]!!) }.toIntArray()
    }

    private fun transTime(temp: String): Int {
        val (hour, minute) = temp.split(":").map { it.toInt() }

        return hour * 60 + minute
    }

    private fun calc(fees: IntArray, total: Int): Int {
        var res = fees[1]

        if (total > fees[0]) res += ceil((total - fees[0]).toDouble() / fees[2]).toInt() * fees[3]

        return res
    }
}
