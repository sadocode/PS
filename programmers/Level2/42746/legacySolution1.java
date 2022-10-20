import java.util.LinkedList;
import java.util.List;

class Solution {
    public String solution(int[] numbers) {
    	List<Integer> list = new LinkedList<>();

    	// list에 값 입력
    	for(int i = 0; i < numbers.length; i++)
    	{
    		addList(list, numbers[i]);
    		System.out.println(list.toString());
    	}
    	
    	// 결과 리턴
    	if(list.get(0) == 0)
    		return "0";
    	
    	StringBuilder answer = new StringBuilder();
        for(int i = 0; i < list.size(); i++)
        {
        	answer.append(list.get(i));
        }
        return answer.toString();
    }
    // 정렬 순서에 맞게 값 입력
    private static void addList(List<Integer> list, int num)
    {
    	if(list.size() == 0 || num == 0)
    	{
    		list.add(num);
    		return;
    	}
    	
    	for(int i = 0; i < list.size(); i++)
    	{
    		if(isHighPriority(num , list.get(i)))
    		{
    			list.add(i, num);
    			return;
    		}
    	}
    	list.add(num);
    }
    // a가 우선순위가 높으면 true, 낮으면 false를 반환. 1 <= a <= 1000. 0 <= b <= 1000
    // a는 새로 넣을 수, b는 list의 숫자
    private static boolean isHighPriority(int a, int b)
    {
    	if(b == 0 || a == b || b == 1000)
    		return true;
    	
    	if(a == 1000)
    		return false;
    	
    	// a, b의 자리수
    	int indexA = 0;
    	int indexB = 0;
    	int[] arrA = new int[3];
    	int[] arrB = new int[3];
    	
    	for(int i = 2; i >= 0; i--)
    	{
    		arrA[i] = a % 10;
    		arrB[i] = b % 10;
    		a /= 10;
    		b /= 10;
    		
    		if(arrA[i] != 0)
    			indexA = i;
    		if(arrB[i] != 0)
    			indexB = i;
    	}
    	
    	if(indexA == 1)
    	{
    		arrA[0] = arrA[1];
    		arrA[1] = arrA[2];
    		arrA[2] = arrA[0];
    	}
    	else if(indexA == 2)
    	{
    		arrA[0] = arrA[2];
    		arrA[1] = arrA[2];
    	}
    	
    	if(indexB == 1)
    	{
    		arrB[0] = arrB[1];
    		arrB[1] = arrB[2];
    		arrB[2] = arrB[0];
    	}
    	else if(indexB == 2)
    	{
    		arrB[0] = arrB[2];
    		arrB[1] = arrB[2];
    	}

    	for(int i = 0; i < 3; i++)
    	{
    		
    		if(arrA[i] < arrB[i])
    			return false;
    		else if(arrA[i] > arrB[i])
    			return true;
    		
    		if(i == 2)
    		{
    			if(indexA == indexB)
    				return true;

    			if(arrA[1] < arrA[0])
    				return indexA < indexB ? true : false;
    			
    			if(arrA[1] > arrA[0])
    				return indexA > indexB ? true : false;
    		
    			return indexA >= indexB ? true : false;
    		}
    	}
    	
    	return true;
    }
}
