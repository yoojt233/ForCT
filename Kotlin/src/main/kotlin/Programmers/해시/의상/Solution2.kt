package Programmers.해시.의상

fun main() = with(System.`in`.bufferedReader()) {
    fun solution(clothes: Array<Array<String>>): Int {
        return clothes.groupBy { it[1] }.values.fold(1) { res, i -> res * (i.size + 1) } - 1
    }

    val clothes = arrayOf(
        arrayOf("crow_mask", "face"),
        arrayOf("blue_sunglasses", "face"),
        arrayOf("smoky_makeup", "face")
    )
    print(solution(clothes))
}