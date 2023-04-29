class Solution(object):
    def romanToInt(self, s):
        """
        :type s: str
        :rtype: int
        """
        sum = 0
        rom_dict = {
            'I' : 1,'V' : 5,'X' : 10,'L' : 50,'C' : 100,'D' : 500,'M' : 1000
        }
        for letter in range(len(s)):
            if letter <= len(s)-2:
                if s[letter] == 'I' and (s[letter+1] == 'V' or s[letter+1] =='X'):
                    sum -= rom_dict[s[letter]]
                elif s[letter] == 'X' and (s[letter+1] == 'L' or s[letter+1] =='C'):
                    sum -= rom_dict[s[letter]]
                elif s[letter] == 'C' and (s[letter+1] == 'D' or s[letter+1] =='M'):
                    sum -= rom_dict[s[letter]]
                else:
                    sum += rom_dict[s[letter]]
            else:
                    sum += rom_dict[s[letter]]

        return sum