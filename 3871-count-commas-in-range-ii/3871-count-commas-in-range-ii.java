class Solution {
    public long countCommas(long n) {
        long count = 0;
        long power = 1000;
        while (power <= n) {
            count += n - power + 1;
            if (power > Long.MAX_VALUE / 1000) {
                break;
            }
            power *= 1000;
        }
        return count;
    }
}