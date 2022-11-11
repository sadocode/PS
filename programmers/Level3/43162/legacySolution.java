import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
	public int solution(int n, int[][] computers) {
        boolean[] check = new boolean[n];
        List<Network> list = new ArrayList<>();
        
        // [0][0] 노드
        Network net = new Network();
		net.addCom(0);
		list.add(net);
		
		int netNum = 0;
		int temp = 0;
        for(int i = 0; i < n; i++)
        {
        	temp = -1;
        	netNum = -1;
        	for(int k = 0; k < list.size(); k++)
    		{
    			if(list.get(k).isComputer(i))
    			{
    				netNum = k;
    				break;
    			}
    		}
        	
        	if(netNum == -1)
        	{
        		Network tempNetwork = new Network();
        		tempNetwork.addCom(i);
        		list.add(tempNetwork);
        		netNum = list.size() - 1;
        	}
        	
        	for(int j = 0; j < n; j++)
        	{
        		if(computers[i][j] == 1 )
        		{
        			if(!check[j])
       				{
        				check[j] = true;
       					list.get(netNum).addCom(j);
       				}
        			else
        			{
        				if(!list.get(netNum).isComputer(j))
        				{
        					for(int k = 0; k < list.size(); k++)
        		    		{
        		    			if(list.get(k).isComputer(j))
        		    			{
        		    				temp = k;
        		    				break;
        		    			}
        		    		}
        					list.get(netNum).addNetwork(list.get(temp).getMap());
        				}
        			}
        		}
        	}
        	if(temp != -1)
        		list.remove(temp);
        }

        return list.size();
    }
	class Network {
		private Map<Integer, Boolean> map;
		Network()
		{
			this.map = new HashMap<>();
		}
		public boolean isComputer(int com)
		{
			if(this.map.containsKey(com))
				return true;

			return false;
		}
		public void addCom(int com)
		{
			this.map.put(com, true);
		}
		public Map<Integer, Boolean> getMap()
		{
			return this.map;
		}
		public void addNetwork(Map<Integer, Boolean> map)
		{
			for(Integer key : map.keySet())
				this.map.put(key, true);
		}
	}
}
