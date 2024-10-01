class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {

        // approach -- sum of gas needs to be greater than the sum of cost if we start from the  particular index.
        int n = gas.length;
        int idx = -1;

        int totalGas = 0;
        int totalCost = 0;
        int currentGas = 0;
        int currentCost = 0;

        for(int i = 0; i < n; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
            if(idx != -1) {
                currentGas += gas[i];
                currentCost += cost[i];
            }

            if(currentGas < currentCost) { // if totalGas is less then totalCost than till current index gas is not enough to travel
                idx = -1;
            }

            if(gas[i] >= cost[i] && idx == -1) { // if there tank is empty that means idx = -1 then we will consider the current index as the starting point if gas >= cost
                idx = i;
                currentGas = gas[i];
                currentCost = cost[i];
            }

        }
        if(totalCost > totalGas) return -1; // gas is not enough for travel 
        return idx;

    }
}