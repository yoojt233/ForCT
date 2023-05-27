package BaekJoon.no28107_회전초밥;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        PriorityQueue<order> pq = new PriorityQueue<>();
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            for (int j = 0; j < n; ++j) pq.add(new order(i, Integer.parseInt(st.nextToken())));
        }

        st = new StringTokenizer(br.readLine());
        PriorityQueue<Integer> sushi = new PriorityQueue<>();
        for (int i = 0; i < M; ++i) sushi.add(Integer.parseInt(st.nextToken()));

        int[] ans = new int[N];
        while (!sushi.isEmpty()) {
            int cur = sushi.poll();

            while (!pq.isEmpty() && pq.peek().num < cur) pq.poll();
            if (pq.isEmpty()) break;
            else if (pq.peek().num > cur) continue;
            ++ans[pq.poll().client];
        }

        for (int i : ans) System.out.print(i + " ");
    }
}

class order implements Comparable<order> {
    int client;
    int num;

    public order(int client, int num) {
        this.client = client;
        this.num = num;
    }

    @Override
    public int compareTo(order o) {
        if (num != o.num) return num - o.num;
        return client - o.client;
    }
}