package Programmers.연습문제.하샤드수

fun main() = with(System.`in`.bufferedReader()) {
    fun solution(x: Int): Boolean {
        var sum = 0
        var num = x

        while (num > 0) {
            sum += (num % 10)
            num /= 10
        }

        return x % sum == 0
    }

    val x = 12
    print(solution(x))
}