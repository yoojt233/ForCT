package BaekJoon.no1111_IQTest

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt();
    val nums = readLine().split(" ").map { it.toInt() };

    when (n) {
        1 -> print("A");
        2 -> print(if (nums[0] == nums[1]) nums[0] else "A");
        else -> {
            var flag = true;
            var ans = 0;

            val numer = nums[1] - nums[2];
            val denom = nums[0] - nums[1];

            if (denom != 0 && numer % denom != 0) flag = false;
            else {
                val a = if (denom != 0) numer / denom else 0;
                val b = nums[1] - a * nums[0];

                for (i in 1 until n - 1) {
                    if (nums[i + 1] != nums[i] * a + b) {
                        flag = false;
                        break;
                    }
                }
                if (flag) ans = nums.last() * a + b;
            }
            print(if (flag) ans else "B");
        }
    }
}
