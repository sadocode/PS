class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        String left = "L";
        String right = "R";

        // hand를 주 사용 손 문자로 초기화 
        if("left".equals(hand))
        	hand = left;
        else
        	hand = right;
        
        // 손의 위치
        int leftPos = 10;
        int rightPos = 10;
        
        // 임시값
        int leftCount = 0;
        int rightCount = 0;
        
        // 배열 길이
        int numLength = numbers.length;
         
        // 손 위치별 거리
        int[][] sideCountArr = {{1, 2, 3, 4}, {2, 1, 2, 3}, {3, 2, 1, 2}, {4, 3, 2, 1}};
        int[][] centerCountArr = {{0, 1, 2, 3}, {1, 0, 1, 2}, {2, 1, 0, 1}, {3, 2, 1, 0}};
        
        // 키패드의 배열에서의 위치
        int numPos = 0;
        
        // 배열 위치 임시 값
        int leftTemp = 0;
        int rightTemp = 0;
        
        // 어느손인지 계산
        for(int i = 0; i < numLength; i++)
        {
        	System.out.println(i + " -- 현재 왼손 : " + leftPos + ", 현재 오른손 : " + rightPos + ", 눌러야하는놈 : " + numbers[i]);
        	switch(numbers[i])
        	{
        		case 1:
        		case 4:
        		case 7:
        			answer.append(left);
        			leftPos = numbers[i];
        			break;
        		case 3:
        		case 6:
        		case 9:
        			answer.append(right);
        			rightPos = numbers[i];
        			break;
        		case 2:
        		case 5:
        		case 8:
        		case 0:
        			if(numbers[i] > 0)
        				numPos = numbers[i] / 3;
        			else
        				numPos = 3;
        			
        			if(leftPos % 3 == 1)
        			{
        				leftTemp = leftPos / 3;
        				leftCount = sideCountArr[leftTemp][numPos];
        			}
        			else 
        			{
        				if(leftPos == 2)
        					leftTemp = 0;
        				else if(leftPos == 5)
        					leftTemp = 1;
        				else if(leftPos == 8)
        					leftTemp = 2;
        				else
        					leftTemp = 3;
        				leftCount = centerCountArr[leftTemp][numPos];
        			}
        			
        			if(rightPos % 3 == 0 && rightPos > 0)
        			{
        				rightTemp = (rightPos - 2 ) / 3;
        				rightCount = sideCountArr[rightTemp][numPos]; // 0 3
        			}
        			else if (rightPos == 10)
        			{
        				rightTemp = 3;
        				rightCount = sideCountArr[rightTemp][numPos];
        			}
        			else 
        			{
        				if(rightPos == 2)
        					rightTemp = 0;
        				else if(rightPos == 5)
        					rightTemp = 1;
        				else if(rightPos == 8)
        					rightTemp = 2;
        				else
        					rightTemp = 3;
        				rightCount = centerCountArr[rightTemp][numPos];
        			}
        			
        			if(leftCount > rightCount)
        			{	
        				answer.append(right);
        				rightPos = numbers[i];
        			}
        			else if(leftCount < rightCount)
        			{
        				answer.append(left);
        				leftPos = numbers[i];
        			}
        			else
        			{
        				answer.append(hand);
        				if(hand.equals(left))
        					leftPos = numbers[i];
        				else
        					rightPos = numbers[i];
        			}
        			break;
        		default:
        			break;
        	}
        }
        
        
        return answer.toString();
    }
}
