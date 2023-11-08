package Implementation

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
}