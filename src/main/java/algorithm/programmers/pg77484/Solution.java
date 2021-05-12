package algorithm.programmers.pg77484;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        Map<Integer, Boolean> purchaseLottoNumberMap = new HashMap<>();
        int zeroCount = getZeroCount(lottos, purchaseLottoNumberMap);
        int winCount = getWinCount(win_nums, purchaseLottoNumberMap);

        int maxScore = calcScore(winCount + zeroCount);
        int minScore = calcScore(winCount);

        return new int[]{maxScore, minScore};
    }

    private int calcScore(int count) {
        return count < 2 ? 6 : 7 - count;
    }

    private int getWinCount(int[] win_nums, Map<Integer, Boolean> purchaseLottoNumberMap) {
        int winCount = 0;
        for (int win_num : win_nums) {
            if (purchaseLottoNumberMap.containsKey(win_num)) winCount++;
        }
        return winCount;
    }

    private int getZeroCount(int[] lottos, Map<Integer, Boolean> purchaseLottoNumberMap) {
        int zeroCount = 0;
        for (int lotto : lottos) {
            purchaseLottoNumberMap.put(lotto, true);
            if (lotto == 0) zeroCount++;
        }
        return zeroCount;
    }
}
