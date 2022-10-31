import java.util.Arrays;
import java.util.Collections;

class Solution {
    public int solution(int[] A, int[] B) {
    	Integer[] a = Arrays.stream(A).boxed().toArray(Integer[]::new);
    	Integer[] b = Arrays.stream(B).boxed().toArray(Integer[]::new);
    	Arrays.sort(a, Collections.reverseOrder());
    	Arrays.sort(b, Collections.reverseOrder());
    	
    	int answer = 0;
    	int len = A.length;
    	int indexA = 0;
    	int indexB = 0;
    	
    	while(indexA < len && indexB < len)
    	{
    		if(b[indexB] > a[indexA])
    		{
    			answer++;
    			indexB++;
    		}

    		indexA++;
    	}
    	
    	return answer;
    }
}
