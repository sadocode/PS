import java.util.LinkedList;
import java.util.List;

class Solution {
    public String solution(int[] numbers) {
    	List<Integer> list = new LinkedList<>();
    	List<Integer> list0 = new LinkedList<>();
    	List<Integer> list1 = new LinkedList<>();
    	List<Integer> list2 = new LinkedList<>();
    	List<Integer> list3 = new LinkedList<>();
    	List<Integer> list4 = new LinkedList<>();
    	List<Integer> list5 = new LinkedList<>();
    	List<Integer> list6 = new LinkedList<>();
    	List<Integer> list7 = new LinkedList<>();
    	List<Integer> list8 = new LinkedList<>();
    	List<Integer> list9 = new LinkedList<>();
    	List<Integer> list10 = new LinkedList<>();
    	
    	int tempNum = 0;
    	// list에 값 입력
    	for(int i = 0; i < numbers.length; i++)
    	{
    		if(numbers[i] < 10)
    			tempNum = numbers[i] % 10;
    		else if(numbers[i] >= 10 && numbers[i] < 100)
    			tempNum = (numbers[i] / 10) % 10;
    		else if(numbers[i] >= 100 && numbers[i] < 1000)
    			tempNum = (numbers[i] / 100) % 10;
    		else
    			tempNum = 10;
    		
    		switch(tempNum)
    		{
    			case 0:
    				list0.add(0);
    				break;
    			case 10:
    				list10.add(1000);
    				break;
    			case 1:
    				addList(list1, numbers[i]);
    				break;
    			case 2:
    				addList(list2, numbers[i]);
    				break;
    			case 3:
    				addList(list3, numbers[i]);
    				break;
    			case 4:
    				addList(list4, numbers[i]);
    				break;
    			case 5:
    				addList(list5, numbers[i]);
    				break;
    			case 6:
    				addList(list6, numbers[i]);
    				break;
    			case 7:
    				addList(list7, numbers[i]);
    				break;
    			case 8:
    				addList(list8, numbers[i]);
    				break;
    			case 9:
    				addList(list9, numbers[i]);
    				break;
    		}
    	}
    	
    	list.addAll(list9);
    	list.addAll(list8);
    	list.addAll(list7);
    	list.addAll(list6);
    	list.addAll(list5);
    	list.addAll(list4);
    	list.addAll(list3);
    	list.addAll(list2);
    	list.addAll(list1);
    	list.addAll(list10);
    	list.addAll(list0);
    	
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
    	if(list.size() == 0)
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
    // a가 우선순위가 높으면 true, 낮으면 false를 반환. 1 <= a <= 999. 1 <= b <= 999
    // a는 새로 넣을 수, b는 list의 숫자
    private static boolean isHighPriority(int a, int b)
    {
    	if(a == b)
    		return true;
    	
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
