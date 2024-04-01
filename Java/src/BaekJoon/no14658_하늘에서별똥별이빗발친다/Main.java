package BaekJoon.no14658_하늘에서별똥별이빗발친다;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] input = new int[4];
    static Pos[] stars;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 4; ++i)
            input[i] = Integer.parseInt(st.nextToken());

        stars = new Pos[input[3]];
        for (int i = 0; i < input[3]; ++i) {
            st = new StringTokenizer(br.readLine());
            stars[i] = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        int best = 0;
        for (Pos a : stars) {
            for (Pos b : stars)
                best = Math.max(best, count(a.r, b.c));
        }
        System.out.println(input[3] - best);
    }

    private static int count(int r, int c) {
        int res = 0;
        int L = input[2] + 1;
        for (Pos star : stars) {
            if (r <= star.r && star.r < r + L && c <= star.c && star.c < c + L)
                ++res;
        }
        return res;
    }
}

class Pos {
    int r, c;

    public Pos(int r, int c) {
        this.r = r;
        this.c = c;
    }
}