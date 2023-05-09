package Programmers.KAKAO_BLIND_RECRUITMENT_2023.택배배달과수거하기

import java.lang.Integer.max
import java.util.*

fun main() {
    val cap = 2;
    val n = 7;
    val deliveries = intArrayOf(1, 0, 2, 0, 1, 0, 2);
    val pickups = intArrayOf(0, 2, 0, 1, 0, 2, 0);

    print(solution(cap, n, deliveries, pickups));
}

fun solution(cap: Int, n: Int, deliveries: IntArray, pickups: IntArray): Long {
    val d = Stack<House>();
    val p = Stack<House>();

    repeat(n) {
        if (deliveries[it] != 0) d.push(House(it + 1, deliveries[it]));
        if (pickups[it] != 0) p.push(House(it + 1, pickups[it]));
    }

    var sum = 0L;
    while (d.isNotEmpty() || p.isNotEmpty()) {
        sum += max(drive(d, cap), drive(p, cap)) * 2;
    }
    return sum;
}

fun drive(stack: Stack<House>, cap: Int): Int {
    if (stack.isEmpty()) return 0;
    val res = stack.peek().dist;

    var x = cap;
    while (!(x == 0 || stack.isEmpty())) {
        val cur = stack.peek();
        if (cur.box > x) {
            cur.box -= x;
            x = 0;
        } else {
            x -= cur.box;
            stack.pop();
        }
    }
    return res;
}

data class House(
    val dist: Int,
    var box: Int
)
