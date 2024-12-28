class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] ans = new int[k][2];
        
        Arrays.sort(points, (first, second) -> {
            int f = first[0] * first[0] + first[1] * first[1];
            int s = second[0] * second[0] + second[1] * second[1];
            if(f < s) {
                return -1;
            } else if(f > s) {
                return 1;
            }
            return 0;
        });

        for(int i = 0; i < k; i++) {
            ans[i][0] = points[i][0];
            ans[i][1] = points[i][1];
        }
        return ans;


    }
}