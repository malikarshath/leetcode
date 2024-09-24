class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        int n = matrix.length;
        int m = matrix[0].length;

        int left = 0;
        int right = m - 1;
        int top = 0;
        int bottom = n - 1;
        List<Integer> ans = new ArrayList<>();

        while(left <= right && top <= bottom) {

            for(int k = left; k <= right; k++) { 
                ans.add(matrix[top][k]);
            }
            top++;

            for(int k = top; k <= bottom; k++) {
                ans.add(matrix[k][right]);
            }
            right--;

            if(top <= bottom) {
                for(int k = right; k >= left; k--) {
                    ans.add(matrix[bottom][k]);
                }
                bottom--;
            }

            if(left <= right) {
                for(int k = bottom; k >= top; k--) {
                    ans.add(matrix[k][left]);
                }
                left++;
            }

        }

        return ans;
    }
}