class Solution {
    public int reverse(int x) {

        long finalNum = 0;

        while(x != 0) {
            finalNum = (finalNum*10) + (x % 10);
            x = x / 10;
        }


        if(finalNum > Integer.MAX_VALUE || finalNum < Integer.MIN_VALUE) {
            return 0;
        }

        return (int)finalNum;
        
    }
}