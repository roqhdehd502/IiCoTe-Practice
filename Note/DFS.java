// 깊이 우선 탐색(DFS)을 이용해 각 바이러스가 사방으로 퍼지도록 하기
public static void virus(int x, int y) {
    for (int i = 0; i < 4; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];
        // 상, 하, 좌, 우 중에서 바이러스가 퍼질 수 있는 경우
        if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
            if (temp[nx][ny] == 0) {
                // 해당 위치에 바이러스 배치하고, 다시 재귀적으로 수행
                temp[nx][ny] = 2;
                virus(nx, ny);
            }
        }
    }
}


// 깊이 우선 탐색 (DFS) 메서드
public static void dfs(int i, int now) {
    // 모든 연산자를 다 사용한 경우, 최솟값과 최댓값 업데이트
    if (i == n) {
        minValue = Math.min(minValue, now);
        maxValue = Math.max(maxValue, now);
    }
    else {
        // 각 연산자에 대하여 재귀적으로 수행
        if (add > 0) {
            add -= 1;
            dfs(i + 1, now + arr.get(i));
            add += 1;
        }
        if (sub > 0) {
            sub -= 1;
            dfs(i + 1, now - arr.get(i));
            sub += 1;
        }
        if (mul > 0) {
            mul -= 1;
            dfs(i + 1, now * arr.get(i));
            mul += 1;
        }
        if (divi > 0) {
            divi -= 1;
            dfs(i + 1, now / arr.get(i));
            divi += 1;
        }
    }
}
