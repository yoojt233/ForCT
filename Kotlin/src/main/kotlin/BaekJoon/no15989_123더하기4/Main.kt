package BaekJoon.no15989_123더하기4

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder();
    val dp = Array(10000) { IntArray(3) };

    for (i in 0 until 3) {
        for (j in 0..i) dp[i][j] = 1;
    }

    var top = 3;
    repeat(readLine().toInt()) {
        val target = readLine().toInt() - 1;
        while (target >= top) {
            dp[top][0] = dp[top - 1][0];
            dp[top][1] = dp[top - 2][0] + dp[top - 2][1];
            dp[top][2] = dp[top - 3][0] + dp[top - 3][1] + dp[top - 3][2];
            ++top;
        }
        sb.append("${dp[target][0] + dp[target][1] + dp[target][2]}\n");
    }

    print(sb);
}

/**
 * 결국 끝자리가 1로 끝나는 dp[i][0]은 무조건 1이므로 해당 부분을 없애고 2차원 배열의 size를 2로 줄인 경우
 */
//fun main() = with(System.`in`.bufferedReader()) {
//    val sb = StringBuilder();
//    val dp = Array(10000) { IntArray(2) };
//
//    for (i in 1 until 3) {
//        for (j in 0 until i) dp[i][j] = 1;
//    }
//
//    var top = 3;
//    repeat(readLine().toInt()) {
//        val target = readLine().toInt() - 1;
//        while (target >= top) {
//            dp[top][0] = 1 + dp[top - 2][0];
//            dp[top][1] = 1 + dp[top - 3][0] + dp[top - 3][1];
//            ++top;
//        }
//        sb.append("${1 + dp[target][0] + dp[target][1]}\n");
//    }
//
//    print(sb);
//}