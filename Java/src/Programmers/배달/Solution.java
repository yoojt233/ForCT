package Programmers.배달;

import java.util.Arrays;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.PriorityQueue;

class Node implements Comparable<Node> {
    int to;
    int cost;

    public Node(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node other) {
        return cost - other.cost;
    }
}

class Solution {
    public int solution(int N, int[][] road, int K) {
        HashMap<Integer, ArrayList<Node>> graph = new HashMap<>();

        for (int i = 1; i <= N; i++) graph.put(i, new ArrayList<>());

        for (int[] r : road) {
            int from = r[0];
            int to = r[1];
            int cost = r[2];

            if (cost > K) continue;

            graph.get(from).add(new Node(to, cost));
            graph.get(to).add(new Node(from, cost));
        }

        int[] d = dijkstra(N, K, graph);
        int res = 0;

        for (int i : d) {
            if (i <= K) ++res;
        }

        return res;
    }

    private int[] dijkstra(int N, int K, HashMap<Integer, ArrayList<Node>> graph) {
        int[] res = new int[N + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>();

        Arrays.fill(res, Integer.MAX_VALUE);
        pq.add(new Node(1, 0));
        res[1] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (cur.cost > res[cur.to]) continue;

            for (Node next : graph.get(cur.to)) {
                int nc = res[cur.to] + next.cost;

                if (nc > K || nc >= res[next.to]) continue;

                res[next.to] = nc;
                pq.add(new Node(next.to, nc));
            }
        }

        return res;
    }
}
