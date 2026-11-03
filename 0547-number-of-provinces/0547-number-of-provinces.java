class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && isConnected[i][j] == 1) {
                    adj.get(i).add(j);
                }
            }
        }
        int[] visited = new int[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                count++;
                dfs(i, adj, visited);
            }
        }
        return count;
    }
    public void dfs(int node,ArrayList<ArrayList<Integer>> adj,int[] visited){
        visited[node]=1;
       for (Integer i : adj.get(node)) {
            if(visited[i]==0){
                dfs(i,adj,visited);
            }
        }
    }
}