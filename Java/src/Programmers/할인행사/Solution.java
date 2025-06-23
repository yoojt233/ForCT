package Programmers.할인행사;

import java.util.HashMap;

public class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        HashMap<String, Integer> bag = new HashMap<>();
        HashMap<String, Integer> target = new HashMap<>();

        int res = 0;
        int ed = 9;

        for (int i = 0; i < 10; i++) {
            String cur = discount[i];

            bag.put(cur, bag.getOrDefault(cur, 0) + 1);
        }

        for (int i = 0; i < want.length; i++) target.put(want[i], number[i]);

        if (check(bag, target)) ++res;

        while (ed + 1 < discount.length) {
            String del = discount[ed - 9];
            String add = discount[++ed];

            bag.put(del, bag.get(del) - 1);
            bag.put(add, bag.getOrDefault(add, 0) + 1);
        }

        return res;
    }

    private static boolean check(HashMap<String, Integer> bag, HashMap<String, Integer> target) {
        for (String w : target.keySet()) {
            if (bag.getOrDefault(w, 0) < target.get(w)) return false;
        }

        return true;
    }
}
