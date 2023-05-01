#User function Template for python3

class Solution:
    #Function to sort the array using bubble sort algorithm.
    def bubbleSort(self,arr, n):
        # code here
        for i in range(n):
            swap = 0
            for x in range(n-i-1):
                if arr[x]>arr[x+1]:
                    temp = arr[x]
                    arr[x] = arr[x+1]
                    arr[x+1] = temp
                    swap = 1
            if swap == 0:
                break

#{ 
 # Driver Code Starts
#Initial Template for Python 3



if __name__=='__main__':
    t = int(input())
    for i in range(t):
        n = int(input())
        arr = list(map(int, input().strip().split()))
        ob = Solution()
        ob.bubbleSort(arr, n)
        for i in arr:
            print(i,end=' ')
        print()

# } Driver Code Ends