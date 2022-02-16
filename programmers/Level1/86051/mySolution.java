class Solution {
    public int solution(int[] numbers) {
        int temp = 0;
        int numSize = numbers.length;
        
        int[] numArr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        
        for(int i = 0; i < numSize; i++)
        {
            temp += numArr[numbers[i]];
        }
        
        return 45 - temp;
    }
}
