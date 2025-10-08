package BaekJoon.no2109_순회강연;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class Lesson implements Comparable<Lesson> {
    int d;
    int p;

    public Lesson(int d, int p) {
        this.d = d;
        this.p = p;
    }

    @Override
    public int compareTo(Lesson other) {
        return (this.d != other.d) ? this.d - other.d : other.p - this.p;
    }
}

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        PriorityQueue<Lesson> pq = new PriorityQueue<>();
        PriorityQueue<Integer> sel = new PriorityQueue<>();
        int n = Integer.parseInt(br.readLine());
        int size = 0, ans = 0;

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");

            pq.add(new Lesson(Integer.parseInt(input[1]), Integer.parseInt(input[0])));
        }

        while (!pq.isEmpty()) {
            Lesson cur = pq.poll();

            if (cur.d > size) {
                sel.add(cur.p);
                ++size;
            } else {
                int first = sel.poll();
                sel.add(Math.max(first, cur.p));
            }
        }

        while (!sel.isEmpty()) ans += sel.poll();
        System.out.println(ans);
    }
}
