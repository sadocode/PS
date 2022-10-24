class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int product = brown + yellow;
        int sum = (brown + 4) / 2;
        
        for(int i = 1; i <= sum / 2; i++)
        {
        	if(i * (sum - i) == product)
        	{
        		answer[0] = sum - i;
        		answer[1] = i;
        	}
        }
        
        return answer;
    }
}
