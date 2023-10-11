package Programmers.해시.의상

fun main() = with(System.`in`.bufferedReader()) {
    fun solution(clothes: Array<Array<String>>): Int {
        val kinds = HashMap<String, HashSet<String>>()
        for (cloth in clothes) {
            val name = cloth[0]
            val kind = cloth[1]

            if (kinds.containsKey(kind)) kinds[kind]!!.add(name)
            else kinds[kind] = hashSetOf(name)
        }

        var res = 1
        kinds.forEach { (_, set) -> res *= (set.size + 1) }
        return res - 1
    }

    val clothes = arrayOf(
        arrayOf("crow_mask", "face"),
        arrayOf("blue_sunglasses", "face"),
        arrayOf("smoky_makeup", "face")
    )
    print(solution(clothes))
}