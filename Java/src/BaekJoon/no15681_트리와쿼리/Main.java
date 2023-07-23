package BaekJoon.no15681_트리와쿼리;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken()) - 1;
        int Q = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N];
        for (int i = 0; i < N; ++i) graph[i] = new ArrayList();

        for (int i = 0; i < N - 1; ++i) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;

            graph[from].add(to);
            graph[to].add(from);
        }

        boolean[] visited = new boolean[N];
        int[] dp = new int[N];
        visited[R] = true;
        tree(R, dp, visited);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; ++i) {
            int want = Integer.parseInt(br.readLine()) - 1;
            sb.append(dp[want] + "\n");
        }
        System.out.print(sb);
    }

    private static int tree(int cur, int[] dp, boolean[] visited) {
        if (dp[cur] == 0) {
            ++dp[cur];
            for (int next : graph[cur]) {
                if (visited[next]) continue;
                visited[next] = true;
                dp[cur] += tree(next, dp, visited);
            }
        }
        return dp[cur];
    }
}
