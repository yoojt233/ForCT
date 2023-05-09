package Programmers.`2021_Dev-Matching`.로또의최고순위와최저순위

fun main() {
    val lottos = intArrayOf(44, 1, 0, 0, 31, 25);
    val win_nums = intArrayOf(31, 10, 45, 1, 6, 19);

    solution(lottos, win_nums).forEach { print("$it\n") };
}

fun solution(lottos: IntArray, win_nums: IntArray): IntArray {
    val win_set = win_nums.toHashSet();
    var correct = 0;
    var joker = 0;
    for (i in lottos) {
        if (i == 0) ++joker; else if (win_set.contains(i)) ++correct;
    }

    fun rank(cnt: Int): Int {
        var res = 7 - cnt;
        return if (res > 6) 6 else res;
    }

    val ans = IntArray(2);
    ans[0] = rank(joker + correct);
    ans[1] = rank(correct);
    return ans;
}