package Programmers.`2021_Dev-Matching`.다단계칫솔판매

fun main() {
    val enroll = arrayOf("john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young")
    val referral = arrayOf("-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward")
    val seller = arrayOf("sam", "emily", "jaimie", "edward")
    val amount = intArrayOf(2, 3, 5, 4)

    solution(enroll, referral, seller, amount).forEach { print("$it ") }
}

data class Person(var parent: Int, var money: Int)

val backnumber = HashMap<String, Int>()
lateinit var people: Array<Person>

fun solution(enroll: Array<String>, referral: Array<String>, seller: Array<String>, amount: IntArray): IntArray {
    people = Array(enroll.size) { Person(-1, 0) }

    for (i in enroll.indices) backnumber[enroll[i]] = i
    for (i in referral.indices) people[i].parent = backnumber.getOrDefault(referral[i], -1)
    for (i in seller.indices) sell(backnumber[seller[i]]!!, amount[i] * 100)

    return IntArray(enroll.size) { people[it].money }
}

fun sell(num: Int, total: Int) {
    val cur = people[num]
    val rest = total / 10

    cur.money += (total - rest)
    if (cur.parent != -1 && rest > 0) sell(cur.parent, rest)
}
