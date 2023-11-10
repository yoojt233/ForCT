package BaekJoon.no2258_정육점;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Meat[] meats = new Meat[n];
        for (int i = 0; i < n; ++i) {
            st = new StringTokenizer(br.readLine());
            meats[i] = new Meat(st.nextToken(), st.nextToken());
        }

        Arrays.sort(meats);
        boolean flag = false;
        int ans = Integer.MAX_VALUE;
        int total = 0;
        int w = 0;
        int prev = 0;
        for (Meat meat : meats) {
            total = (prev < meat.cost) ? meat.cost : total + meat.cost;
            w += meat.weight;

            if (w >= m) {
                flag = true;
                ans = Math.min(ans, total);
            }

            prev = meat.cost;
        }
        System.out.print(flag ? ans : -1);
    }
}

class Meat implements Comparable<Meat> {
    int weight, cost;

    public Meat(int weight, int cost) {
        this.weight = weight;
        this.cost = cost;
    }

    public Meat(String weight, String cost) {
        this.weight = Integer.parseInt(weight);
        this.cost = Integer.parseInt(cost);
    }

    @Override
    public int compareTo(Meat o) {
        boolean equal = this.cost == o.cost;
        return equal ? o.weight - this.weight : this.cost - o.cost;
    }
}
