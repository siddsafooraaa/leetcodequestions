class Solution {
    public int lastStoneWeight(int[] stones) {
        while(stones.length>1){
            int n=stones.length;
            Arrays.sort(stones);
            int a=stones[n-1];
            int b=stones[n-2];
           stones[n-2]=Math.abs(a-b);
           stones=Arrays.copyOf(stones,n-1);
        }
        return stones[0];
    }
}