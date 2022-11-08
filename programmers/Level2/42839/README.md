날짜 : 2022-11-08  

링크 : https://programmers.co.kr/learn/courses/30/lessons/42839  

풀이 :  
legacySolution 풀이 방식  
 1. 재귀로 만들 수 있는 모든 수를 생성, 저장 --> O(n!). 최악 O(7!)  
 2. 해당 숫자까지의 모든 소수를 계산. --> O(n^2)  
 3. 시간초과 뜸.  
 
mySolution 풀이 방식  
 1.  재귀로 만들 수 있는 모든 수를 생성, 저장 --> O(n!). 최악 O(7!)  
 2. 에라토스테네스의 체. --> O(nloglogn) 사실상 O(N)  
  
에라토스테네스의 체. 평소에 기억해두자~

