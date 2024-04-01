package Implementation

class BinarySearch {
    fun binarySearch(arr: IntArray, want: Int): Int {
        var left = 0
        var right = arr.size - 1

        while (left <= right) {
            val mid = (left + right) / 2
            if (arr[mid] == want) return mid
            if (arr[mid] < want) left = mid + 1
            else right = mid - 1
        }

        return -(left + 1)
    }
}
