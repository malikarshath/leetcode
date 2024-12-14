class Solution {
    public int findGCD(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }

        return gcd(max, min);
    }

    public int gcd(int a, int b) {
        if(a == 0 || b == 0) {
            return a + b;
        }

        if(a >= b) {
            return gcd(a%b, b);
        }

        return gcd(b, a);

    }
}