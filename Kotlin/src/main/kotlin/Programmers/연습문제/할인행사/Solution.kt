package Programmers.연습문제.할인행사

fun main() {
    val want = arrayOf("banana", "apple", "rice", "pork", "pot")
    val number = intArrayOf(3, 2, 2, 2, 1)
    val discount = arrayOf(
        "chicken",
        "apple",
        "apple",
        "banana",
        "rice",
        "apple",
        "pork",
        "banana",
        "pork",
        "rice",
        "pot",
        "banana",
        "apple",
        "banana"
    )

    print(Solution().solution(want, number, discount))
}

class Solution {
    fun solution(want: Array<String>, number: IntArray, discount: Array<String>): Int {
        val tenDay = HashMap<String, Int>()
        var res = 0

        fun check(): Boolean {
            for (i in want.indices) {
                if (!tenDay.containsKey(want[i]) || tenDay[want[i]]!! < number[i]) return false
            }

            return true
        }

        for (i in 0 until 10) {
            val product = discount[i]

            if (tenDay.containsKey(product)) tenDay[product] = tenDay[product]!! + 1
            else tenDay[product] = 1
        }

        if (check()) ++res

        for (i in 0 until discount.size - 10) {
            val except = discount[i]
            val add = discount[i + 10]

            tenDay[except] = tenDay[except]!! - 1

            if (tenDay.containsKey(add)) tenDay[add] = tenDay[add]!! + 1
            else tenDay[add] = 1

            if (check()) ++res
        }

        return res
    }
}