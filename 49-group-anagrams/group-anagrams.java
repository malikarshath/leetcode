class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> strMap = new HashMap<>();


        for(String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);
            String val = str;

            if(strMap.containsKey(key)) {
                List<String> li = strMap.get(key);
                li.add(val);
                strMap.put(key, li);
            } else {
                List<String> li = new ArrayList<>();
                li.add(val);
                strMap.put(key, li);
            }
        }

        List<List<String>> ans = new ArrayList<>();

        for(String key : strMap.keySet()) {
            ans.add(strMap.get(key));
        }

        return ans;
        
    }
}