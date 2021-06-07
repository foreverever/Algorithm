package algorithm.codility.l7.brackets;


import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {
    public int solution(String S) {
        Map<Character, Character> closeMap = new HashMap<>();
        closeMap.put('{', '}');
        closeMap.put('[', ']');
        closeMap.put('(', ')');

        Stack<Character> st = new Stack<>();

        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (closeMap.containsKey(c)) {
                st.push(c);
                continue;
            }
            if (st.isEmpty()) return 0;
            char open = st.pop();
            if (c != closeMap.get(open)) return 0;
        }
        
        if (!st.isEmpty()) return 0;
        return 1;
    }
}
