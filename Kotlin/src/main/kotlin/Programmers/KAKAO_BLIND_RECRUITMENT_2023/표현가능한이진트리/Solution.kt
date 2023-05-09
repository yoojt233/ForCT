package Programmers.KAKAO_BLIND_RECRUITMENT_2023.표현가능한이진트리

fun main() {
    var numbers = longArrayOf(423);
    solution(numbers).map { print(it) };
}

val b = intArrayOf(1, 3, 7, 15, 31, 63);

fun solution(numbers: LongArray): IntArray {
    val ans = IntArray(numbers.size);
    repeat(numbers.size) {
        var cur = numbers[it].toString(2);

        var bs = b.binarySearch(cur.length);
        if (bs < 0) bs = -bs - 1;

        val tree = CharArray(b[bs]);
        val zero = b[bs] - cur.length;
        for (i in 0 until b[bs]) {
            tree[i] = if (i < zero) '0' else cur[i - zero];
        }

        ans[it] = if (check(tree, 0, b[bs] - 1)) 1 else 0;
    }
    return ans;
}

fun check(tree: CharArray, op: Int, ed: Int): Boolean {
    val mid = (op + ed) / 2;
    if (tree[mid] == '0') {
        for (i in op..ed) {
            if (tree[i] != '0') return false;
        }
        return true;
    } else if (ed + 1 - op > 3) {
        return check(tree, op, mid - 1) && check(tree, mid + 1, ed);
    } else return true;
}

