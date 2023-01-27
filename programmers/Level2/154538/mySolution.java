import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class Solution {
	public int solution(int x, int y, int n) {
		Map<Integer, Integer> map = new HashMap<>();
		Queue<int[]> queue = new LinkedList<>();
		
		int[] arr = getArr(x, 0);
		queue.add(arr);
		map.put(x, 0);
		
		while(!queue.isEmpty())
		{
			arr = queue.poll();
			if(map.containsKey(arr[0] * 2))
			{
				if(map.get(arr[0] * 2) > arr[1] + 1)
				{
					map.put(arr[0] * 2, arr[1] + 1);
					queue.add(getArr(arr[0] * 2, arr[1] + 1));
				}
			}
			else
			{
				if(arr[0] * 2 <= y)
				{
					map.put(arr[0] * 2, arr[1] + 1);
					queue.add(getArr(arr[0] * 2, arr[1] + 1));
				}
			}
			
			if(map.containsKey(arr[0] * 3))
			{
				if(map.get(arr[0] * 3) > arr[1] + 1)
				{
					map.put(arr[0] * 3, arr[1] + 1);
					queue.add(getArr(arr[0] * 3, arr[1] + 1));
				}
			}
			else
			{
				if(arr[0] * 3 <= y)
				{
					map.put(arr[0] * 3, arr[1] + 1);
					queue.add(getArr(arr[0] * 3, arr[1] + 1));
				}
			}
			
			if(map.containsKey(arr[0] + n))
			{
				if(map.get(arr[0] + n) > arr[1] + 1)
				{
					map.put(arr[0] + n, arr[1] + 1);
					queue.add(getArr(arr[0] + n, arr[1] + 1));
				}
			}
			else
			{
				if(arr[0] + n <= y)
				{
					map.put(arr[0] + n, arr[1] + 1);
					queue.add(getArr(arr[0] + n, arr[1] + 1));
				}
			}
		}
		
		if(map.containsKey(y))
			return map.get(y);
		else
			return -1;
    }
	private static int[] getArr(int num, int count)
	{
		int[] arr = new int[2];
		arr[0] = num;
		arr[1] = count;
		return arr;
	}
}
