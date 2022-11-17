import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
	private static Map<Integer, Integer> map = new HashMap<>(); 
	public int solution(int N, int[][] road, int K) {
		if(N == 1)
			return 1;
		
		// 중복 제거. 시간 낮은 값으로만 채움.
		int a = 0;	// a마을 ( a < b )
		int b = 0;	// b마을
		int[][] r = new int[road.length][3];
    	for(int i = 0; i < road.length; i++)
    	{
    		if(road[i][2] > K) 
    			continue;
    		
    		a = road[i][0] < road[i][1] ? road[i][0] : road[i][1];
    		b = road[i][0] > road[i][1] ? road[i][0] : road[i][1];

    		if(i == 0)
    		{
    			r[0][0] = a;
    			r[0][1] = b;
    			r[0][2] = road[0][2];
    			continue;
    		}
    		
    		for(int j = 0; j < r.length; j++)
    		{
    			if(r[j][0] == 0)
    			{
    				r[j][0] = a;
    				r[j][1] = b;
    				r[j][2] = road[i][2];
    				break;
    			}
    			
    			if(a == (r[j][0] < r[j][1] ? r[j][0] : r[j][1]) && b == (r[j][0] > r[j][1] ? r[j][0] : r[j][1]))
    			{
    				if(road[i][2] < r[j][2])
    					r[j][2] = road[i][2];
    				break;
    			}
    		}
    	}
    	
    	for(int i = 0; i < r.length; i++)
    	{
    		if(r[i][0] == 0)
    		{
    			r = Arrays.copyOfRange(r, 0, i);
    			break;
    		}
    	}
    	
    	boolean[] visit = new boolean[N + 1];
    	visit[1] = true;
    	
    	for(int i = 2; i <= N; i++)
    		dfs(N, r, visit, K, i, 0, 1);
    	
    	map.put(1, 0);
        return map.size();
    }
	private static void dfs(int N, int[][] r, boolean[] visit, int K, int end, int time, int idx)
	{
		if(K < time)
			return;
		
		if(map.containsKey(end) && map.get(end) < time)
			return;
		
		if(end == idx)
		{
			if(K >= time)
				map.put(end, time);
			
			return;
		}
		
		for(int i = 0; i < r.length; i++)
		{
			if(idx == r[i][0] && !visit[r[i][1]])
			{
				visit[r[i][1]] = true;
				dfs(N, r, visit, K, end, time + r[i][2], r[i][1]);
				visit[r[i][1]] = false;
			}
			else if(idx == r[i][1] && !visit[r[i][0]])
			{
				visit[r[i][0]] = true;
				dfs(N, r, visit, K, end, time + r[i][2], r[i][0]);
				visit[r[i][0]] = false;
			}
		}
	}
}
