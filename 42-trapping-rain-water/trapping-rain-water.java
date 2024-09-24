class Solution {
    public int trap(int[] height) {

        int n = height.length;

        int[] pfArr = pf(height);
        int[] sfArr = sf(height);

        int totalRainWater = 0;

        for(int i = 1; i < n - 1; i++) {
            totalRainWater += Math.min(pfArr[i], sfArr[i]) - height[i];
        }

        return totalRainWater;
        
    }

    public int[] pf(int[] arr) {
        int[] pf = new int[arr.length];
        pf[0] = arr[0];
        for(int i = 1; i < arr.length; i++) {
            pf[i] = Math.max(pf[i - 1], arr[i]);
        }

        return pf;
    }

    public int[] sf(int[] arr) {
        int n = arr.length;
        int[] sf = new int[arr.length];
        sf[n - 1] = arr[n - 1];
        for(int i = n - 2; i >= 0; i--) {
            sf[i] = Math.max(sf[i + 1], arr[i]);
        }

        return sf;
    }
}