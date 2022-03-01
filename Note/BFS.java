// 너비 우선 탐색(BFS) 수행
Queue<Integer> q = new LinkedList<Integer>();
q.offer(x);
while (!q.isEmpty()) {
    int now = q.poll();
    // 현재 도시에서 이동할 수 있는 모든 도시를 확인
    for (int i = 0; i < graph.get(now).size(); i++) {
        int nextNode = graph.get(now).get(i);
        // 아직 방문하지 않은 도시라면
        if (d[nextNode] == -1) {
            // 최단 거리 갱신
            d[nextNode] = d[now] + 1;
            q.offer(nextNode);
        }
    }
}


// 너비 우선 탐색(BFS) 진행
while (!q.isEmpty()) {
    Virus virus = q.poll();
    // 정확히 second만큼 초가 지나거나, 큐가 빌 때까지 반복
    if (virus.getSecond() == targetS) break;
    // 현재 노드에서 주변 4가지 위치를 각각 확인
    for (int i = 0; i < 4; i++) {
        int nx = virus.getX() + dx[i];
        int ny = virus.getY() + dy[i];
        // 해당 위치로 이동할 수 있는 경우
        if (0 <= nx && nx < n && 0 <= ny && ny < n) {
            // 아직 방문하지 않은 위치라면, 그 위치에 바이러스 넣기
            if (graph[nx][ny] == 0) {
                graph[nx][ny] = virus.getIndex();
                q.offer(new Virus(virus.getIndex(), virus.getSecond() + 1, nx, ny));
            }
        }
    }
}


// 큐가 빌 때까지 반복
while(!q.empty) {
  Position pos = q.poll();
  x = pos.getX();
  y = pos.getY();
  // 현재 위치에서 4가지 방향을 확인하며
  for(int i=0; i<4; i++) {
    int nx = x + dx[i];
    int ny = y + dy[i];
    // 바로 옆에 있는 나라를 확인하여
    if(0 <= nx && nx < n && 0 <= ny && ny < n && unions[nx][ny] == -1) {
      // 옆에 있는 나라와 인구 차이가 l명 이상, r명 이하라면
      int gap = Math.abs(graph[nx][ny] - graph[x][y]);
      if (l <= gap && gat <= r) {
        q.offer(new Position(nx, ny));
        // 연합에 추가하기
        unions[nx][ny] = index;
        summary += graph[nx][ny];
        count += 1;
        united.add(new Position(nx, ny));
      }
    }
  }
}
