package Programmers.KAKAO_WINTER_INTERNSHIP_2024.n_plus_1카드게임

fun main() {
    val coin = 3
    val cards = intArrayOf(1, 2, 3, 4, 5, 8, 6, 7, 9, 10, 11, 12)
    print(solution(coin, cards))
}

fun solution(coin: Int, cards: IntArray): Int {
    val n = cards.size
    var res = 1
    var chance = coin
    val have = HashSet<Int>()
    val temp = HashSet<Int>()

    for (i in 0 until n / 3) have.add(cards[i])

    for (i in n / 3 until n step 2) {
        var flag = false
        temp.add(cards[i])
        temp.add(cards[i + 1])

        for (x in have) {
            if (have.contains(n + 1 - x)) {
                have.remove(x)
                have.remove(n + 1 - x)
                flag = true
                break
            }
        }

        if (!flag && chance > 0) {
            for (x in have) {
                if (temp.contains(n + 1 - x)) {
                    have.remove(x)
                    --chance
                    flag = true
                    break
                }
            }
        }

        if (!flag && chance > 1) {
            for (x in temp) {
                if (temp.contains(n + 1 - x)) {
                    temp.remove(x)
                    temp.remove(n + 1 - x)
                    chance -= 2
                    flag = true
                    break
                }
            }
        }

        if (flag) ++res else break
    }

    return res
}