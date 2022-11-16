import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(int[] elements) {
		Map<Integer, Boolean> map = new HashMap<>();
		int len = elements.length;
		
		// 전체 합
		int all = 0;
		for(int i = 0; i < len; i++)
			all += elements[i];
		map.put(all, true);
		
		int sum = 0;
		for(int count = 1; count <= len / 2 ; count++)
		{
			for(int startIdx = 0; startIdx < len; startIdx++)
			{
				sum = 0;
				for(int idx = startIdx; idx < startIdx + count; idx++)
				{
					if(idx < len)
						sum += elements[idx];
					else
						sum += elements[idx - len];
				}
				map.put(sum, true);
				map.put(all - sum, true);
			}
		}
		
		return map.size();
    }
}
