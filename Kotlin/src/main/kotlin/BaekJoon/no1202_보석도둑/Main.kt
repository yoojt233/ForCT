package BaekJoon.no1202_보석도둑

import java.util.PriorityQueue

data class Jewelry(val weight: Int, val cost: Int) : Comparable<Jewelry> {
    override fun compareTo(other: Jewelry): Int {
        return if (weight != other.weight) weight - other.weight else other.cost - cost;
    }
}


fun main() = with(System.`in`.bufferedReader()) {
    val (N, K) = readLine().split(" ").map { it.toInt() };

    val jewels = Array<Jewelry?>(N) { null };
    repeat(N) { i ->
        val (weight, cost) = readLine().split(" ").map { it.toInt() };
        jewels[i] = Jewelry(weight, cost);
    }
    jewels.sort();

    val bags = IntArray(K);
    repeat(K) {
        bags[it] = readLine().toInt();
    }
    bags.sort();

    var ans = 0L;
    val pq = PriorityQueue<Int>(reverseOrder());

    var j = 0;
    for (bag in bags) {
        for (i in j until N) {
            if (jewels[j]!!.weight <= bag) pq.add(jewels[j++]!!.cost)
            else break;
        }

        if (pq.isNotEmpty()) ans += pq.poll();
    }

    print(ans);
}