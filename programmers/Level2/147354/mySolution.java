import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
    	List<int[]> list = new ArrayList<>();

    	for(int i = 0; i < data.length; i++)
    		list.add(data[i]);
    	
    	list.sort(new Comparator<int[]>() {
    		public int compare(int[] a, int[] b)
    		{
    			if(a[col - 1] > b[col - 1])
    				return 1;
    			else if(a[col - 1] < b[col - 1])
    				return -1;
    			else
    			{
    				if(a[0] > b[0])
    					return -1;
    				else 
    					return 1;
    			}
    		}
    	});
    	
    	int idx = 0;
    	int[] arr = new int[row_end - row_begin + 1];
    	int[] temp = null;
    	for(int i = row_begin; i <= row_end; i++)
    	{
    		temp = list.get(i - 1);
    		for(int j = 0; j < temp.length; j++)
    			arr[idx] += temp[j] % i;
    		idx++;
    	}
    	
        int answer = arr[0];
        for(int i = 1; i < arr.length; i++)
        	answer = answer ^ arr[i];
        
        return answer;
    }
}
