package Programmers.카카오_인턴십_2020.수식최대화

import kotlin.math.abs
import kotlin.math.max

fun main() {
    val expression = "100-200*300-500+20"
    print(Solution().solution(expression))
}

class Solution {
    fun solution(expression: String): Long {
        var res = 0L
        val orders = arrayOf("+-*", "+*-", "*-+", "*+-", "-+*", "-*+")
        val operators = expression.replace(("\\d").toRegex(), "").toList()
        val numbers = expression.split("+", "*", "-").map { it.toLong() }.toList()

        for (order in orders) res = max(res, calc(operators, numbers, order))

        return res
    }

    private fun calc(operators: List<Char>, numbers: List<Long>, order: String): Long {
        val ops = operators.toMutableList()
        val nums = numbers.toMutableList()

        for (i in 0 until 3) {
            var j = 0

            while (j < ops.size) {
                if (order[i] == ops[j]) {
                    when (order[i]) {
                        '+' -> nums[j] += nums[j + 1]
                        '-' -> nums[j] -= nums[j + 1]
                        else -> nums[j] *= nums[j + 1]
                    }

                    ops.removeAt(j)
                    nums.removeAt(j + 1)
                } else ++j
            }
        }

        return abs(nums.sum())
    }
}
