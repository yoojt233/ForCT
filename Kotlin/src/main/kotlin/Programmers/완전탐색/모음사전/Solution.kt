package Programmers.완전탐색.모음사전

fun main() {
    val word = "AAAAE"
    print(solution(word))
}

fun solution(word: String): Int {
    val alphabet = arrayOf("A", "E", "I", "O", "U")
    val chances = HashMap<String, Int>()
    var idx = 0

    fun bruteForce(prev: String) {
        if (prev.length > 5) return

        chances[prev] = idx++
        for (c in alphabet) bruteForce(prev + c)
    }

    bruteForce("")
    return chances[word]!!
}