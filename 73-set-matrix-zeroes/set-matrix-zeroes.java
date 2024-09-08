class Solution {
    public void setZeroes(int[][] matrix) {
        
        int n = matrix.length;
        int m = matrix[0].length;
        Set<Integer> st = new HashSet<>();

        for(int i = 0; i < n; i++) {
            boolean zero = false;
            for(int j = 0; j < m; j++) {
                if(matrix[i][j] == 0) {
                    zero = true;
                    st.add(j);
                }
            }

            if(zero) {
                for(int j = 0; j < m; j++) {
                        matrix[i][j] = 0;
                }
            }
            zero = false;
        }

        for(int j = 0; j < m; j++) {
            if(st.contains(j)) {
                for(int i = 0; i < n; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}