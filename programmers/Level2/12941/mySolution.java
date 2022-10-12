import java.util.Arrays;

class Solution
{
    public int solution(int []A, int []B)
    {
    	int answer = 0;
    	int aLen = A.length;
    	
    	Arrays.sort(A);
        Arrays.sort(B);
    	
    	for(int i = 0; i < aLen; i++)
    		answer += A[i] * B[aLen - i - 1];

    	return answer;
    }
}
