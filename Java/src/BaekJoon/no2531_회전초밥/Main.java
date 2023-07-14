package BaekJoon.no2531_회전초밥;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] input = new int[4];

        // [0] : 접시 수, [1] : 초밥 가짓 수, [2] : 연속해서 먹는 접시 수, [3] : 쿠폰 번호
        for (int i = 0; i < 4; i++)
            input[i] = Integer.parseInt(st.nextToken());

        // 접시에 놓인 초밥
        int[] plates = new int[input[0]];
        for (int i = 0; i < input[0]; i++)
            plates[i] = Integer.parseInt(br.readLine());

        // 초밥 번호
        int[] sushi = new int[input[1] + 1];

        int max = 0; // 제일 많이 먹은 초밥 가짓 수를 저장할 max 값
        int kind = 0; // 현재 먹은 가짓 수

        // 처음 연속갯수 먹었을 때
        for (int i = 0; i < input[2]; i++) {
            sushi[plates[i]]++;
            if (sushi[plates[i]] == 1)
                max++;
            kind = max;
        }
        if (sushi[input[3]] == 0) ++max;

        int op = 0, ed = input[2] - 1;
        for (int i = 1; i < input[0]; i++) {
            sushi[plates[op]]--;
            if (sushi[plates[op]] == 0)
                kind--;

            op++;
            ed++;

            ed %= input[0];
            sushi[plates[ed]]++;
            if (sushi[plates[ed]] == 1)
                kind++;

            max = Integer.max(max, sushi[input[3]] == 0 ? kind + 1 : kind);
        }

        System.out.print(max);
        br.close();
    }
}
