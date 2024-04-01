package HackerRank.Implementation.TheTimeinWords;

import java.io.*;
import java.util.*;

class Result {
    public static String timeInWords(int h, int m) {
        boolean flag = (m <= 30) ? true : false;
        if (!flag) m = 60 - m;

        HashMap<Integer, String> number = init();
        String res = "";
        if (m == 0) {
            res += number.get(h);
            res += " o' clock";
        } else if (m == 15 || m == 30) {
            res += number.get(m);
            res += (flag) ? " past " : " to ";
            if (!flag) {
                h += 1;
                if (h > 12) h -= 12;
            }
            res += number.get(h);
        } else {
            res += number.get(m);
            res += (m != 1) ? " minutes " : " minute ";
            res += (flag) ? "past " : "to ";
            if (!flag) {
                h += 1;
                if (h > 12) h -= 12;
            }
            res += number.get(h);
        }

        return res;
    }

    public static HashMap<Integer, String> init() {
        HashMap<Integer, String> res = new HashMap<>();
        res.put(1, "one");
        res.put(2, "two");
        res.put(3, "three");
        res.put(4, "four");
        res.put(5, "five");
        res.put(6, "six");
        res.put(7, "seven");
        res.put(8, "eight");
        res.put(9, "nine");
        res.put(10, "ten");
        res.put(11, "eleven");
        res.put(12, "twelve");
        res.put(13, "thirteen");
        res.put(14, "fourteen");
        res.put(15, "quarter");
        res.put(16, "sixteen");
        res.put(17, "seventeen");
        res.put(18, "eighteen");
        res.put(19, "nineteen");
        res.put(20, "twenty");
        res.put(21, "twenty one");
        res.put(22, "twenty two");
        res.put(23, "twenty three");
        res.put(24, "twenty four");
        res.put(25, "twenty five");
        res.put(26, "twenty six");
        res.put(27, "twenty seven");
        res.put(28, "twenty eight");
        res.put(29, "twenty nine");
        res.put(30, "half");
        return res;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int h = Integer.parseInt(bufferedReader.readLine().trim());

        int m = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.timeInWords(h, m);

        System.out.println(result);
        bufferedReader.close();
    }
}
