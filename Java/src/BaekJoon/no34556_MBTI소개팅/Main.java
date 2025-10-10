package BaekJoon.no34556_MBTI소개팅;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int ans = 0;
    static String[] men;
    static String[] women;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        men = new String[n];
        women = new String[n];

        for (int i = 0; i < n; i++) men[i] = br.readLine();
        for (int i = 0; i < n; i++) women[i] = br.readLine();

        permu(n, 0, new int[n], new boolean[n]);

        System.out.println(ans);
    }

    private static void permu(int n, int level, int[] sel, boolean[] visited) {
        if (level == n) {
            int temp = 0;

            for (int i = 0; i < n; i++) temp += getScore(men[sel[i]], women[i]);
            ans = Math.max(ans, temp);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;

            visited[i] = true;
            sel[level] = i;
            permu(n, level + 1, sel, visited);
            visited[i] = false;
        }
    }

    private static int getScore(String man, String woman) {
        int res = 0;

        for (int i = 0; i < man.length(); i++) {
            if (man.charAt(i) != woman.charAt(i)) ++res;
        }

        return res;
    }
}
