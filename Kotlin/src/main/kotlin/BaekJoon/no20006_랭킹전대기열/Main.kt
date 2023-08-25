package BaekJoon.no20006_랭킹전대기열

import java.util.ArrayList
import java.util.PriorityQueue

data class Player(val level: Int, val id: String) : Comparable<Player> {
    override fun compareTo(other: Player): Int {
        return id.compareTo(other.id)
    }

    override fun toString(): String {
        return "$level $id"
    }
}

data class Room(val least: Int, val most: Int, val players: PriorityQueue<Player>)

val rooms = ArrayList<Room>()

fun main() = with(System.`in`.bufferedReader()) {
    val (p, m) = readLine().split(" ").map { it.toInt() }

    repeat(p) {
        val temp = readLine().split(" ")
        val player = Player(temp[0].toInt(), temp[1])
        find(m, player)
    }

    val sb = StringBuilder()
    for (room in rooms) {
        sb.append(if (room.players.size == m) "Started!\n" else "Waiting!\n")
        while (room.players.isNotEmpty()) sb.append("${room.players.poll()}\n")
    }
    print(sb)
}

fun find(m: Int, player: Player) {
    var flag = false
    for (room in rooms) {
        if (room.players.size == m || player.level !in room.least..room.most) continue
        room.players.add(player)
        flag = true
        break
    }

    if (!flag) {
        val pq = PriorityQueue<Player>()
        pq.add(player)
        rooms.add(Room(player.level - 10, player.level + 10, pq))
    }
}
