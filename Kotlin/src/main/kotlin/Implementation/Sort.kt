package Implementation

class Sort {
    fun bubbleSort(arr: IntArray): IntArray {
        val n = arr.size
        val res = arr.clone()

        for (i in 0 until n - 1) {
            for (j in 1 until n - i) {
                if (res[j - 1] > res[j]) {
                    val temp = res[j]
                    res[j] = res[j - 1]
                    res[j - 1] = temp
                }
            }
        }
        return res
    }

    fun selectionSort(arr: IntArray): IntArray {
        val n = arr.size
        val res = arr.clone()

        for (i in 0 until n - 1) {
            var mini = i

            for (j in i + 1 until n) {
                if (res[j] < res[mini]) mini = j
            }

            val temp = res[i]
            res[i] = res[mini]
            res[mini] = temp
        }
        return res
    }

    fun insertionSort(arr: IntArray): IntArray {
        val n = arr.size
        val res = arr.clone()

        for (i in 1 until n) {
            var temp = res[i]
            var prev = i - 1

            while (prev >= 0 && res[prev] > temp) {
                res[prev + 1] = res[prev]
                --prev
            }
            res[prev + 1] = temp
        }
        return res
    }
}