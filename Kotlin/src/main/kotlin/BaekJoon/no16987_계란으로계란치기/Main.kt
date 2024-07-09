package BaekJoon.no16987_계란으로계란치기

class Egg(var durability: Int, val weight: Int) {
    fun clash(v: Int): Boolean {
        durability -= v
        return durability <= 0
    }

    fun rollback(v: Int) {
        durability += v
    }
}

fun main() = with(System.`in`.bufferedReader()) {
    var n = readLine()!!.trim().toInt()
    val eggs = ArrayList<Egg>()

    repeat(n) {
        val (d, w) = readLine().split(" ").map { it.toInt() }
        eggs.add(Egg(d, w))
    }

    var ans = 0

    fun solve(cur: Int, cnt: Int) {
        if (cur == n) {
            ans = ans.coerceAtLeast(cnt)
            return
        }

        if (eggs[cur].durability <= 0) {
            solve(cur + 1, cnt)
            return
        }

        var flag = false
        for (i in eggs.indices) {
            if (eggs[i].durability <= 0 || i == cur) continue

            flag = true
            var temp = cnt

            if (eggs[i].clash(eggs[cur].weight)) ++temp
            if (eggs[cur].clash(eggs[i].weight)) ++temp

            solve(cur + 1, temp)

            eggs[i].rollback(eggs[cur].weight)
            eggs[cur].rollback(eggs[i].weight)
        }

        if (!flag) solve(cur + 1, cnt)
    }

    solve(0, 0)
    print(ans)
}
