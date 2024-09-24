class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
        Arrays.sort(points, (first, second) -> {
            long f1 = first[0];
            long f2 = first[1];
            long s1 = second[0];
            long s2 = second[1];

            long firstpoint = (f1 * f1) + (f2 * f2);
            long secondpoint = (s1 * s1) + (s2 * s2);

            if(firstpoint < secondpoint) {
                return -1;
            } else if(secondpoint < firstpoint) {
                return 1;
            }
            return 0;
        });

        int[][] ans = new int[k][2];

        for(int i = 0; i < k; i++) {
            ans[i] = points[i];
        }

        return ans;
    }
}