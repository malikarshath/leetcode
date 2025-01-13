class Solution {
    public int maxArea(int[] height) {
        int s = 0;
        int e = height.length - 1;
        int maxWater = 0;

        while(s < e) {
            int minheight = Math.min(height[s],height[e]);
            maxWater = Math.max(maxWater, minheight * (e - s));
            if(height[s] < height[e]) {
                s++;
            } else {
                e--;
            }
        }

        return maxWater;
    }
}