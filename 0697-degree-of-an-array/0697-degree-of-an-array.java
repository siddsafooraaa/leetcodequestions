class Solution {
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        HashMap<Integer, Integer> first = new HashMap<>();
        HashMap<Integer, Integer> last = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            freq.put(num, freq.getOrDefault(num, 0) + 1);
            if (!first.containsKey(num)) {
                first.put(num, i);
            }
            last.put(num, i);
        }
        int degree = 0;
        for (int f : freq.values()) {
            degree = Math.max(degree, f);
        }
        int ans = nums.length;
        for (int num : freq.keySet()) {
            if (freq.get(num) == degree) {
                int len = last.get(num) - first.get(num) + 1;
                ans = Math.min(ans, len);
            }
        }
        return ans;
    }
}