package Programmers.`2021_Dev-Matching`.행렬테두리회전하기

import kotlin.math.min

lateinit var arr: Array<IntArray>;

fun main() {
    val rows = 6;
    val columns = 6;
    val queries = arrayOf(
        intArrayOf(2, 2, 5, 4), intArrayOf(3, 3, 6, 6), intArrayOf(5, 1, 6, 3)
    );

    val ans = solution(rows, columns, queries);
    print(ans);
}

fun solution(rows: Int, columns: Int, queries: Array<IntArray>): IntArray {
    arr = Array(rows) { IntArray(columns) };

    repeat(rows) { i ->
        repeat(columns) { j ->
            arr[i][j] = i * rows + j + 1;
        }
    }

    val ans = IntArray(queries.size);
    if (queries.size == 1) ans[0] = arr[queries[0][0] - 1][queries[0][1] - 1];
    else {
        for (i in queries.indices) ans[i] = turn(queries[i]);
    }
    return ans;
}

fun turn(query: IntArray): Int {
    val op = Pair(query[0] - 1, query[1] - 1);
    val ed = Pair(query[2] - 1, query[3] - 1);

    var res = arr[op.first][op.second];
    var temp = arr[op.first][op.second];

    for (i in op.first until ed.first) {
        arr[i][op.second] = arr[i + 1][op.second];
        res = min(res, arr[i][op.second]);
    }

    for (j in op.second until ed.second) {
        arr[ed.first][j] = arr[ed.first][j + 1];
        res = min(res, arr[ed.first][j]);
    }

    for (i in ed.first downTo op.first + 1) {
        arr[i][ed.second] = arr[i - 1][ed.second];
        res = min(res, arr[i][ed.second]);
    }

    for (j in ed.second downTo op.second + 1) {
        arr[op.first][j] = arr[op.first][j - 1];
        res = min(res, arr[op.first][j]);
    }
    arr[op.first][op.second + 1] = temp;

    return res;
}