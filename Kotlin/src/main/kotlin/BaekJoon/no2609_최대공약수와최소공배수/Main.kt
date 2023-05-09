package BaekJoon.no2609_최대공약수와최소공배수

fun gcd(a: Int, b: Int): Int {
    return if (b == 0) a else gcd(b, a % b);
}

fun main() = with(System.`in`.bufferedReader()) {
    val (a, b) = readLine().split(" ").map { it.toInt() };
    val x = gcd(a, b);
    print("$x ${a / x * b}");
}