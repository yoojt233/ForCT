package Implementation

import java.util.LinkedList
import java.util.Queue
import java.util.Stack

class Graph {
    fun dfsByRecursive(cur: Int, graph: Array<ArrayList<Int>>, visited: BooleanArray) {
        visited[cur] = true
        print(cur)

        for (next in graph[cur]) {
            if (visited[next]) continue
            dfsByRecursive(next, graph, visited)
        }
    }

    fun dfsByStack(op: Int, graph: Array<ArrayList<Int>>) {
        val stack = Stack<Int>()
        val visited = BooleanArray(graph.size)

        visited[op] = true
        stack.push(op)
        while (stack.isNotEmpty()) {
            val cur = stack.pop()
            print(cur)

            for (next in graph[cur]) {
                if (visited[next]) continue
                visited[next] = true
                stack.push(next)
            }
        }
    }

    fun bfsByQueue(op: Int, graph: Array<ArrayList<Int>>) {
        val q: Queue<Int> = LinkedList()
        val visited = BooleanArray(graph.size)

        q.offer(op)
        visited[op] = true
        while (q.isNotEmpty()) {
            val cur = q.poll()

            for (next in graph[cur]) {
                if (visited[next]) continue
                visited[next] = true
                q.offer(next)
            }
        }
    }
}
