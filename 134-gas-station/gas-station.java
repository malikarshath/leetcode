class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {

        // approach -- sum of gas needs to be greater than the sum of cost if we start from the  
        // particular index.
        int n = gas.length;
        int idx = 0;
        int totalCost = 0;
        int totalGas = 0;

        int remainingGas = 0;

        for(int i = 0; i < n; i++) {
            remainingGas += gas[i]- cost[i];
            totalGas += gas[i];
            totalCost += cost[i];

            if(remainingGas < 0) {
                remainingGas = 0;
                idx = i + 1;
            }   

        }
        if(totalCost > totalGas) return -1; // gas is not enough for travel 
        return idx;

    }
}