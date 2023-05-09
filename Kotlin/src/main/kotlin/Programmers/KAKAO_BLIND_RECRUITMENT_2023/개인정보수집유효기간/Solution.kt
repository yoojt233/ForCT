package Programmers.KAKAO_BLIND_RECRUITMENT_2023.개인정보수집유효기간

fun main() {
    val today = "2020.01.01";
    val terms = arrayOf("Z 3", "D 5");
    val privacies = arrayOf("2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z");

    print(solution(today, terms, privacies));
}

fun solution(today: String, terms: Array<String>, privacies: Array<String>): IntArray {
    val (ty, tm, td) = today.split(".").map { it.toInt() };
    val isOver = BooleanArray(privacies.size);

    val term = HashMap<String, Int>();
    for (t in terms) {
        val tmp = t.split(" ");
        term[tmp[0]] = tmp[1].toInt();
    }

    for (i in privacies.indices) {
        val (time, sep) = privacies[i].split(" ");
        var (y, m, d) = time.split(".").map { it.toInt() };

        m += term.getOrDefault(sep, 0);
        while (m > 12) {
            ++y; m -= 12;
        }

        if (--d == 0) {
            d = 28;
            if (--m == 0) {
                m = 12; --y;
            }
        }

        if (ty > y || (ty == y && tm > m) || (ty == y && tm == m && td > d)) isOver[i] = true;
    }

    val res = ArrayList<Int>();
    for (i in isOver.indices) {
        if (isOver[i]) res.add(i + 1);
    }
    return res.toIntArray();
}