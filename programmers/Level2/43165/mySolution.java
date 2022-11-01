class Solution {
    public int solution(int[] numbers, int target) {
    	// 더해서 value가 되는 케이스를 구하면 된다.
    	int value = 0;
        for(int i = 0; i < numbers.length; i++)
        	value += numbers[i];
        value = value - target;
        
        if(value % 2 != 0)
        	return 0;
        else
        	value /= 2;
    	
        if(value == 0 && numbers.length != 1)
        	return 0;
        else if(value == 0 && numbers.length == 1)
        	return 1;
        
        Integer[] numArr = Arrays.stream(numbers).boxed().toArray(Integer[]::new);
        Arrays.sort(numArr, Collections.reverseOrder());
        
        
        // numArr의 체크
        List<Integer> valueList = new LinkedList<>();
        List<Integer> checkList = new LinkedList<>();
        
        int tempValue = 0;
        int index = 0;
        int answer = 0;
        boolean isFin = false;
        
        while(!isFin)
        {
        	if(index == numArr.length)
        	{
        		if(valueList.size() == 0)
        		{
        			break;
        		}
        		else
        		{
        			tempValue -= valueList.get(valueList.size() - 1);
        			valueList.remove(valueList.size() - 1);
        			index = checkList.get(checkList.size() - 1) + 1;
        			checkList.remove(checkList.size() - 1);
        			continue;
        		}
        	}
        	
        	tempValue += numArr[index];
        	valueList.add(numArr[index]);
        	checkList.add(index);

        	if(tempValue < value)
        	{
        		index++;
        	}
        	else if(tempValue == value)
        	{
        		answer++;
        		tempValue -= valueList.get(valueList.size() - 1);
        		valueList.remove(valueList.size() - 1);
        		index++;
        		checkList.remove(checkList.size() - 1);
        	}
        	else
        	{
        		tempValue -= valueList.get(valueList.size() - 1);
        		valueList.remove(valueList.size() - 1);
        		index = checkList.get(checkList.size() - 1) + 1;
        		checkList.remove(checkList.size() - 1);
        	}
        }
        
        return answer;
    }
}
