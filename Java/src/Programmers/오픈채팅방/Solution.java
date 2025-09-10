package Programmers.오픈채팅방;

import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;

class Solution {
    public String[] solution(String[] records) {
        HashMap<String, String> nickname = new HashMap<>();
        HashMap<String, ArrayList<Integer>> index = new HashMap<>();
        HashSet<String> uid = new HashSet<>();
        ArrayList<String> chats = new ArrayList<>();

        for (String record : records) {
            String[] temp = record.split(" ");

            String cmd = temp[0];
            String id = temp[1];

            if (!cmd.equals("Leave")) nickname.put(id, temp[2]);
            if (!uid.contains(id)) index.put(id, new ArrayList<>());
            if (!cmd.equals("Change")) {
                String s = id;

                s += (cmd.equals("Enter") ? "님이 들어왔습니다." : "님이 나갔습니다.");
                index.get(id).add(chats.size());
                chats.add(s);
            }

            uid.add(id);
        }

        String[] res = new String[chats.size()];

        for (String id : uid) {
            String nick = nickname.get(id);

            for (int idx : index.get(id)) {
                res[idx] = chats.get(idx).replaceAll(id, nick);
            }
        }

        return res;
    }
}
