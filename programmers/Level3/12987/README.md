날짜 : 2022-10-31  

링크 : https://programmers.co.kr/learn/courses/30/lessons/12987  

풀이 :  
int배열을 Integer배열로 치환 : n  
Arrays.sort : nlogn  
값 비교 : n  
  
2가지 알아둬야할 게 있음.  
1. java stream  
int[] A = {};  
Integer[] a = Arrays.stream(A).boxed().toArray(Integer[]::new);  

2. Arrays.sort  
이때, sort(배열, Comparator) 로 정렬을 하는데, Comparator를 사용하려면 primitive 자료형 (int, boolean, long)을 사용할 수 없음.  
Wrapper 클래스(Integer, Boolean, Long)을 사용해야 함.  
primitive -> wrapper (Boxing)  
wrapper -> primitive (Unboxing)   
