#User function Template for python3

class Solution: 
    def select(self, arr, i):
        # code here 
        for y in range(i,len(arr)):
                    if arr[y]<arr[i]:
                        temp = arr[i]
                        arr[i] = arr[y]
                        arr[y] = temp
    def selectionSort(self, arr,n):
        #code here
        for x in range(len(arr)):
            self.select(arr,x)
                


#{ 
 # Driver Code Starts
#Initial Template for Python 3

if __name__ == '__main__': 
    t = int(input())
    for _ in range(t):
        n = int(input())
        arr = list(map(int, input().strip().split()))
        Solution().selectionSort(arr, n)
        for i in range(n):
            print(arr[i],end=" ")
        print()
# } Driver Code Ends