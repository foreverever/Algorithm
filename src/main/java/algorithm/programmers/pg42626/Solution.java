package algorithm.programmers.pg42626;

import java.util.PriorityQueue;

public class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int s : scoville) {
            pq.add(s);
        }
        return calc(pq, K);
    }

    private int calc(PriorityQueue<Integer> pq, int k) {
        int cnt = 0;

        while (!pq.isEmpty()) {
            int first = pq.poll();
            if (first >= k) return cnt;
            if (pq.isEmpty()) return -1;

            int second = pq.poll() * 2;
            pq.add(first + second);
            cnt++;
        }
        return cnt;
    }
}
