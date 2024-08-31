class Solution {
    public int reverse(int x) {

        boolean pos = x >= 0 ? true : false;

        long num = Math.abs((long)x);

        char[] arr = String.valueOf(num).toCharArray();

        int l = 0;
        int r = arr.length - 1;

        while(l < r) {
            char temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }

        long finalNum = Long.valueOf(new String(arr));


        if((pos && finalNum > Math.pow(2, 31) - 1) || (!pos && -1 * finalNum < Math.pow(-2, 31))) {
            return 0;
        }

        return pos ? (int)finalNum : -1 * (int)finalNum;
        
    }
}