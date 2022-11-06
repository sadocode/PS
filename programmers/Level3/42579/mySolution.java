import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
    	Map<String, Genre> genreMap = new HashMap<>();
    	Genre temp = null;
    	for(int i = 0; i < plays.length; i++)
    	{
    		if(genreMap.containsKey(genres[i]))
    		{
    			genreMap.get(genres[i]).addCount(plays[i]);
    			genreMap.get(genres[i]).addSong(i, plays[i]);
    		}
    		else
    		{
    			temp = new Genre(genres[i]);
    			temp.addCount(plays[i]);
    			temp.addSong(i, plays[i]);
    			genreMap.put(genres[i], temp);
    		}
    	}
    	
    	List<Genre> genreList = new LinkedList<>();
    	int songCount = 0;
    	for(String genre : genreMap.keySet())
    	{
    		if(genreList.size() == 0)
    		{
    			genreList.add(genreMap.get(genre));
    		}
    		else
    		{
    			for(int i = 0; i < genreList.size(); i++)
        		{
        			if(genreMap.get(genre).getTotalCount() > genreList.get(i).getTotalCount())
        			{
        				genreList.add(i, genreMap.get(genre));
        				break;
        			}
        			
        			if(i + 1 == genreList.size())
        			{
        				genreList.add(genreMap.get(genre));
        				break;
        			}
        		}
    		}
    		songCount += genreMap.get(genre).getSongCount();
    	}
    	
        int[] answer = new int[songCount];
        int index = 0;
        for(int i = 0; i < genreList.size(); i++)
        {
        	answer[index++] = genreList.get(i).getPosArr()[0];
        	if(genreList.get(i).getSongCount() == 2)
        		answer[index++] = genreList.get(i).getPosArr()[1];
        }
        return answer;
    }
    class Genre
    {
    	private String name;
    	private int totalCount;
    	private int[] posArr;
    	private int[] valueArr;
    	private int songCount;
    	public Genre(String name)
    	{
    		this.name = name;
    		this.posArr = new int[2];
    		this.posArr[0] = -1;
    		this.posArr[1] = -1;
    		this.valueArr = new int[2];
    		this.valueArr[0] = -1;
    		this.valueArr[1] = -1;
    	}
    	public String getName()
    	{
    		return this.name;
    	}
    	public int getTotalCount()
    	{
    		return this.totalCount;
    	}
    	public void addCount(int count)
    	{
    		this.totalCount += count;
    	}
    	public int[] getPosArr()
    	{
    		return this.posArr;
    	}
    	public int[] getValueArr()
    	{
    		return this.valueArr;
    	}
    	public int getSongCount()
    	{
    		return this.songCount;
    	}
    	public void addSong(int pos, int value)
    	{
    		if(this.songCount < 2)
    			this.songCount++;

    		if(value > this.valueArr[0])
    		{
    			this.valueArr[1] = this.valueArr[0];
    			this.posArr[1] = this.posArr[0];
    			this.valueArr[0] = value;
    			this.posArr[0] = pos;
    		}
    		else if(value <= this.valueArr[0] && value > this.valueArr[1])
    		{
    			
    			this.valueArr[1] = value;
    			this.posArr[1] = pos;
    		}
    	}
    }
}
