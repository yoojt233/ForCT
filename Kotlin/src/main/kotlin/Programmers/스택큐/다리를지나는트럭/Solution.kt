package Programmers.스택큐.다리를지나는트럭

fun main() {
    val bridge_length = 5
    val weight = 5
    val truck_weights = intArrayOf(2, 2, 2, 2, 1, 1, 1, 1, 1)

    print(Solution().solution(bridge_length, weight, truck_weights))
}

class Solution {
    fun solution(bridge_length: Int, weight: Int, truck_weights: IntArray): Int {
        val enter = IntArray(truck_weights.size) { 1 }
        var cur = truck_weights[0]
        var left = 0

        for (i in 1 until truck_weights.size) {
            if (enter[i - 1] + 1 - enter[left] >= bridge_length) cur -= truck_weights[left++]

            if (cur + truck_weights[i] <= weight) enter[i] = enter[i - 1] + 1
            else {
                while (cur + truck_weights[i] > weight) cur -= truck_weights[left++]
                enter[i] = enter[left - 1] + bridge_length
            }

            cur += truck_weights[i]
        }

        return enter.last() + bridge_length
    }
}
