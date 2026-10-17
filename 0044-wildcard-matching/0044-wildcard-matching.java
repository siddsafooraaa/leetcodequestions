class Solution {
    Boolean[][] dp;
    public boolean isMatch(String s, String p) {
        dp = new Boolean[s.length() + 1][p.length() + 1];
        return solve(0, 0, s, p);
    }
    boolean solve(int i, int j, String s, String p) {
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        boolean ans;
        if (j == p.length()) {
            ans = (i == s.length());
        } else if (p.charAt(j) == '*') {
            ans = solve(i, j + 1, s, p)
                    || (i < s.length() && solve(i + 1, j, s, p));
        } else {
            ans = i < s.length()
                    && (p.charAt(j) == '?' || s.charAt(i) == p.charAt(j))
                    && solve(i + 1, j + 1, s, p);
        }

        dp[i][j] = ans;
        return ans;
    }
}