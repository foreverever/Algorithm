package algorithm.programmers.pg12985;

public class Solution {
    public int solution(int n, int a, int b) {
        int round = 1;

        int mx, mn = 0;

        if (a > b) {
            mx = a;
            mn = b;
        } else {
            mx = b;
            mn = a;
        }

        while (!isFight(mx, mn)) {
            mx = mx % 2 == 0 ? mx / 2 : (mx / 2) + 1;
            mn = mn % 2 == 0 ? mn / 2 : (mn / 2) + 1;
            round++;
        }
        return round;
    }

    private boolean isFight(int mx, int mn) {
        return mx - mn == 1 && mx % 2 == 0 && mn % 2 == 1;
    }
}
