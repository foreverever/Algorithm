package algorithm.programmers.pg60057;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(String s) {
        int totalSize = s.length();
        int ans = Integer.MAX_VALUE;

        for (int size = 1; size <= totalSize; size++) {
            Queue<Character> q = new LinkedList();
            String first = "";
            String second = "";
            String result = "";

            for (int i = 0; i < totalSize; i++) {
                if (first.length() < size) {
                    first += s.charAt(i);
                    continue;
                }
                q.add(s.charAt(i));
            }

            int cnt = 1;
            while (!q.isEmpty()) {
                second += q.poll();
                if (first.length() == second.length()) {
                    if (first.equals(second)) cnt++;
                    else {
                        result = makeResult(first, result, cnt);
                        first = second;
                        cnt = 1;
                    }
                    second = "";
                }
            }
            result = makeResult(first, result, cnt);
            if (!second.isEmpty()) result += second;
            ans = Math.min(result.length(), ans);
        }
        return ans;
    }

    private String makeResult(String first, String result, int cnt) {
        if (cnt > 1) result += (cnt + first);
        else result += first;
        return result;
    }
}