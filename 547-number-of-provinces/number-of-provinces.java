class Solution {
    public int findCircleNum(int[][] isConnected) {
        
        int n = isConnected.length;
        int m = isConnected[0].length;
        List<Integer>[] graph = new List[n];
        int[] visited = new int[n];



        for(int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
            for(int j = 0; j < m; j++) {
                if(i != j) {
                    int v = isConnected[i][j];
                    if(v == 1) {
                        graph[i].add(j);
                    }
                }
            }
        }
        int province = 0;

        for(int i = 0; i < n; i++) {
            if(visited[i] == 0) {
                bfs(i, visited, graph);
                province++;
            }
        }

        return province;

    }

    public void bfs(int start, int[] visited, List<Integer>[] graph) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        while(!q.isEmpty()) {
            int size = q.size();

            for(int i = 1; i <= size; i++) {
                int curr = q.poll();
                if(visited[curr] == 1) {
                    continue;
                }
                visited[curr] = 1;
                for(Integer num : graph[curr]) {
                    if(visited[num] == 0) {
                        q.add(num);
                    }
                }
            }
        }
    }
}