class Solution {
    public boolean predictTheWinner(int[] nums) {
        return solve(nums, 0, nums.length - 1, 0, 0, true);
    }
    static boolean solve(int[] nums, int start, int end,int score1, int score2, boolean player1) {
        if (start > end) {
            return score1 >= score2;
        }
        if (player1) {
            boolean first = solve(nums, start + 1, end,score1 + nums[start], score2,false);
            boolean last = solve(nums, start, end - 1,score1 + nums[end], score2,false);
            return first || last;
        } else {
            boolean first = solve( nums, start + 1, end, score1, score2 + nums[start],true );
            boolean last = solve(nums, start, end - 1,score1, score2 + nums[end],true);
            return first && last;
        }
    }
}