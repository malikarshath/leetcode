class Solution {
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] sq = new int[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                sq[i][j] = matrix[i][j] - '0';
                if(j > 0 && sq[i][j] == 1) {
                    sq[i][j] = sq[i][j - 1] + 1;
                }
                //System.out.print(sq[i][j]+" ");
            }
            //System.out.println("");
        }

        int maxArea = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(sq[i][j] != 0) {
                    int height = 1;
                    int curr = i;
                    int prev = -1;
                    while(curr >= 0 && sq[curr][j] != 0) {

                        int width = sq[curr][j];

                        if(prev != -1) {
                            width = prev < width ? prev : width;
                        }

                        if(height == width) {
                            int area = height * width;
                            //System.out.println(i + "  "+curr+"  "+area+ " "+height+"  "+width);
                            maxArea = Math.max(maxArea, height * width);
                        }

                        prev = width;
                        height++;
                        curr--;
                    }
                }
            }
        }

        return maxArea;
        
    }
}