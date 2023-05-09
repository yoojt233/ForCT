package BaekJoon.no1931_회의실배정

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt();

    val meetings = Array(n) { Meeting(0, 0) };
    repeat(n) {
        var (op, ed) = readLine().split(" ").map { it.toInt() };
        meetings[it] = Meeting(op, ed);
    }

    meetings.sort();
    var ans = 1;
    var ed = meetings[0].ed;
    for(i in 1 until n){
        if(meetings[i].op >= ed){
            ++ans;
            ed = meetings[i].ed;
        }
    }
    print(ans);
}

data class Meeting(
    val op: Int,
    val ed: Int
) : Comparable<Meeting> {
    override fun compareTo(other: Meeting): Int {
        return if (ed != other.ed) ed - other.ed else op - other.op;
    }
}