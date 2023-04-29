class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        for index in range(len(nums)):
            for val in range(index+1,len(nums)):
                if target == nums[index]+nums[val]:
                    return[index,val]