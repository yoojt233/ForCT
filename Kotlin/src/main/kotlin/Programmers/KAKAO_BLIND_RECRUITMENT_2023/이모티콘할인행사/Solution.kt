package Programmers.KAKAO_BLIND_RECRUITMENT_2023.이모티콘할인행사

import kotlin.math.max

fun main() {
    val users = arrayOf(
        intArrayOf(40, 2900),
        intArrayOf(23, 10000),
        intArrayOf(11, 5200),
        intArrayOf(5, 5900),
        intArrayOf(40, 3100),
        intArrayOf(27, 9200),
        intArrayOf(32, 6900),
    );
    val emoticons = intArrayOf(1300, 1500, 1600, 4900);

    val ans = solution(users, emoticons);
    ans.map { print("$it ") };
}

val sales = ArrayList<IntArray>();

fun solution(users: Array<IntArray>, emoticons: IntArray): IntArray {
    val rate = intArrayOf(10, 20, 30, 40);
    possibilities(0, rate, IntArray(emoticons.size));

    val ans = IntArray(2);
    for (sale in sales) {
        val price = IntArray(emoticons.size) { emoticons[it] * (100 - sale[it]) / 100 };

        var plus = 0;
        var sell = 0;
        for (user in users) {
            var sum = 0;
            repeat(emoticons.size) { i ->
                if (sale[i] >= user[0]) sum += price[i];
            }

            if (sum >= user[1]) ++plus; else sell += sum;
        }

        if (plus > ans[0]) {
            ans[0] = plus;
            ans[1] = sell;
        } else if (plus == ans[0]) ans[1] = max(ans[1], sell);
    }
    return ans;
}

fun possibilities(cur: Int, rate: IntArray, res: IntArray) {
    if (cur == res.size) {
        sales.add(res.clone());
        return;
    }

    for (i in rate.indices) {
        res[cur] = rate[i];
        possibilities(cur + 1, rate, res);
    }
}

