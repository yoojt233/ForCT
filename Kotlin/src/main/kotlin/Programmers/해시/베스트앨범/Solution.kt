package Programmers.해시.베스트앨범

import java.util.PriorityQueue

fun main() = with(System.`in`.bufferedReader()) {
    val genres = arrayOf("classic", "pop", "classic", "classic", "pop")
    val plays = intArrayOf(500, 600, 150, 800, 2500)

    solution(genres, plays).forEach { print(it) }
}

fun solution(genres: Array<String>, plays: IntArray): IntArray {
    val total = HashMap<String, Int>()
    val musics = HashMap<String, PriorityQueue<Music>>()

    for (i in genres.indices) {
        val genre = genres[i]
        val music = Music(i, plays[i])

        total[genre] = total.getOrDefault(genre, 0) + music.play
        val temp = musics.getOrDefault(genre, PriorityQueue())
        temp.add(music)
        musics[genre] = temp
    }

    val res = ArrayList<Int>()
    for (g in total.keys.sortedByDescending { total[it] }) {
        for (i in 0 until 2) {
            if (musics[g]!!.isEmpty()) break
            res.add(musics[g]!!.poll().idx)
        }
    }
    return res.toIntArray()
}

data class Music(val idx: Int, val play: Int) : Comparable<Music> {
    override fun compareTo(other: Music): Int {
        return other.play - play
    }
}