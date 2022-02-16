import java.util.HashSet;
import java.util.Set;
class Solution {
	public boolean solution(String[] phone_book) {
		Set<String> phoneSet = new HashSet<String>();
		int bookSize = phone_book.length;
		
		for(int i = 0; i < bookSize; i++)
		{
			phoneSet.add(phone_book[i]);
		}
		
		for(int i = 0; i < bookSize; i++)
		{
			for(int j = 0; j < phone_book[i].length(); j++)
			{
				if(phoneSet.contains(phone_book[i].substring(0, j)))
					return false;
			}
		}
		return true;
	}
}
