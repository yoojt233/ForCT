package Programmers.연습문제.연속된부분수열의합

import java.util.*

fun main() {
    val sequence = intArrayOf(1,1,1,2,3,4,5);
    val k = 5;
    val ans = solution(sequence, k);
    ans.forEach { print(it) };
}

data class Candidate(val op: Int, val ed: Int, val size: Int) : Comparable<Candidate> {
    override fun compareTo(other: Candidate): Int {
        return if (size != other.size) size - other.size else op - other.op;
    }

    fun toIntArray(): IntArray {
        val arr = IntArray(2);
        arr[0] = op;
        arr[1] = ed;
        return arr;
    }
}

fun solution(sequence: IntArray, k: Int): IntArray {
    var op = 0;
    var ed = 0;
    val len = sequence.size - 1;

    var temp = sequence[op];
    val answers = PriorityQueue<Candidate>();
    while (true) {
        if (temp == k) answers.add(Candidate(op, ed, ed - op + 1));
        if (op == len && ed == len) break;
        if (temp < k && ed < len) {
            ++ed;
            temp += sequence[ed];
        } else {
            temp -= sequence[op];
            ++op;
        }
    }
    val ans = answers.poll();
    return ans.toIntArray();
}

