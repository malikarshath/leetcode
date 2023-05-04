class Solution(object):
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        paranthesis = {'{':'}','[':']','(':')'}
        stack = []
        for letter in s:
            if letter in paranthesis.keys():
                stack.append(paranthesis[letter])
            elif letter in stack and stack[-1]==letter:
                stack.pop()
            else:
                return False
        return True  if len(stack) == 0 else False
