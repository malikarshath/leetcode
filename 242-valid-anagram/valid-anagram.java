class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> mp = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            mp.put(ch, mp.getOrDefault(ch, 0) + 1);
        }

        for(int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);

            if(mp.containsKey(ch)) {
                mp.put(ch, mp.get(ch) - 1);
                if(mp.get(ch) <= 0) {
                    mp.remove(ch);
                }
            } else {
                return false;
            }
        }

        if(mp.size() > 0) {
            return false;
        }

        return true;
    }
}