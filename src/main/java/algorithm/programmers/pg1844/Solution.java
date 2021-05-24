package algorithm.programmers.pg1844;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[][] maps) {
        int ySize = maps.length;
        int xSize = maps[0].length;

        //방문 체크 배열
        boolean[][] isVisit = new boolean[101][101];
        //상하좌우 정보
        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, -1, 1};

        //현재 위치 세팅
        Queue<Pos> q = new LinkedList<>();
        q.add(new Pos(0, 0));
        isVisit[0][0] = true;

        //bfs
        while (!q.isEmpty()) {
            Pos cur = q.poll();

            //상하좌우 탐색
            for (int i = 0; i < 4; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];

                //maps 범위 체크
                if (ny < 0 || nx < 0 || ny >= ySize || nx >= xSize) continue;

                if (!isVisit[ny][nx] && maps[ny][nx] == 1) {
                    q.add(new Pos(ny, nx));
                    isVisit[ny][nx] = true;
                    maps[ny][nx] = maps[cur.y][cur.x] + 1;
                }
            }
        }

        if (maps[ySize - 1][xSize - 1] == 1) return -1;
        return maps[ySize - 1][xSize - 1];
    }

    static class Pos {
        int y;
        int x;

        Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}