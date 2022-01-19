import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public boolean solution(String[] phone_book) {
    	// phone_book 길이
    	int bookSize = phone_book.length;

    	// 전화번호의 길이는 최소 1, 최대 20
    	// 따라서, 각 길이마다 HashSet을 생성 후, bookList(ArrayList)에 저장
        List<Set<String>> bookList = new ArrayList<Set<String>>(20);
        for(int i = 0; i < 20; i++)
        {
        	bookList.add(new HashSet<String>());
        }
        
        int tempLength = 0;
        
        // isEmptyMap : 각 길이별로 저장된 HashSet이 비었는지 여부를 저장한 배열
        boolean[] isEmptySet = new boolean[20];
        Arrays.fill(isEmptySet, true);
        
        // phone_book 배열에 저장된 전화번호를 길이별로 bookList에 저장한다.
        // 각 길이마다 값이 있을 경우, isEmptySet에 false처리 
        for(int i = 0; i < bookSize; i++)
        {
        	tempLength = phone_book[i].length();
        	bookList.get(tempLength - 1).add(phone_book[i]);
        	isEmptySet[tempLength - 1] = false;
        }
        
        // 전화번호 비교를 진행할지 여부
        boolean isNext = false;
        
        for(int i = 0; i < 19; i++)
        {
        	if(isEmptySet[i])
        		continue;
        	
        	isNext = false;
        	
        	// 뒤에 비교할 전화번호가 있는지 체크. 있으면 isNext = true
        	for(int j = i + 1; j < 20; j++)
        	{
        		if(isEmptySet[j] == false)
        			isNext = true;
        	}
        	
        	// 뒤에 더 비교할 전화번호가 없으므로, 작업 종료
        	if(!isNext)
        		return true;
        	
        	// 전화번호 비교
        	for(int j = i + 1; j < 20; j++)
        	{
        		if(isEmptySet[j])
        			continue;
        		
        		for(String key : bookList.get(i))
            	{
        			for(String temp : bookList.get(j))
        			{
        				if(temp.startsWith(key))
        					return false;
        			}
            	}
        	}
        }
        return true;
    }
}

