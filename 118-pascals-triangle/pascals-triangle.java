class Solution {
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> ans = new ArrayList<>();
        int[][] pt = new int[numRows][numRows];

        for(int i = 0; i < numRows; i++) {
            for(int j = 0; j <= i; j++) {
                if(j == 0 || j == i) {
                    pt[i][j] = 1;
                } else {
                    pt[i][j] = pt[i - 1][j - 1]+pt[i - 1][j];
                }
            }

            List<Integer> sa = new ArrayList<>();

            for(int j = 0; j <= i; j++) {
                sa.add(pt[i][j]);
            }

            ans.add(sa);
        }

        return ans;
        
    }
}