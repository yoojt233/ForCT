package BaekJoon.no1334_다음팰린드롬수

import java.math.BigInteger

fun main() = with(System.`in`.bufferedReader()) {
    val origin = readLine()
    val n = origin.length
    var res = ""

    if (n < 2 && origin.toInt() < 9) res = (origin.toInt() + 1).toString()
    else if (n < 3 && origin.toInt() < 11) {
        res = "11"
    } else {
        val mid = origin.length / 2
        if (origin.length and 1 == 1) {
            var left = origin.substring(0, mid)
            var middle = origin[mid]
            var right = origin.substring(mid + 1, origin.length)

            res = if (left.reversed() > right) left + middle + left.reversed()
            else {
                if (middle != '9') left + middle.plus(1) + left.reversed()
                else {
                    var temp = BigInteger(left).add(BigInteger.ONE).toString()
                    if (left.length == temp.length) temp + '0' + temp.reversed()
                    else temp + temp.reversed()
                }
            }
        } else {
            var left = origin.substring(0, mid)
            var right = origin.substring(mid, origin.length)

            res = if (left.reversed() > right) left + left.reversed()
            else {
                var temp = BigInteger(left).add(BigInteger.ONE).toString()
                if (left.length == temp.length) temp + temp.reversed()
                else temp + temp.reversed().substring(1, temp.length)
            }
        }
    }

    print(res)
}
