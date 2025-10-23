public class Leet477 {
    public int totalHammingDistance(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int i = 0; i < 32; i++){
            int count1 = 0;
            int count0 = 0;
            for(int j = 0; j < n; j++){
                if(((nums[j] >> i) & 1) == 1)count1++;
                else count0++;
            }
            sum += (count1 * count0);
        }
        return sum;
    }
}
