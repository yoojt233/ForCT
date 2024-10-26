package BaekJoon.no1464_뒤집기3

fun main() = with(System.`in`.bufferedReader()) {
    val dq = ArrayDeque<Char>()

    for (c in readLine()) {
        if (dq.isNotEmpty() && c < dq.last() && c <= dq.first()) dq.addFirst(c)
        else dq.add(c)
    }

    print(dq.joinToString(""))

//    var ans = ""
//    for (c in readLine()) ans = if (ans.isNotBlank() && c < ans.last() && c <= ans.first()) c + ans else ans + c
//    print(ans)
}
