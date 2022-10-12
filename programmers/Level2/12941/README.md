날짜 : 2022-10-12

링크 : https://programmers.co.kr/learn/courses/30/lessons/12941

풀이 :
문제가 좀 이상함.
(1) Arrays.sort() 로 하니까 시간초과 안 뜸.
(2) Collections.sort() 하니까 시간초과 뜸.
(3) insertion sort 직접 구현하니까 시간초과 뜸.
(4) TreeMap 이용해서 하니까 시간초과 뜸.

(1) < (3) < (2) < (4) 순으로 시간이 짧게 나왔음.

### Arrays.sort()
> 평균 O(nlogn), 최악 O(n^2)
> 듀얼 피봇 퀵소트 사용

### Collections.sort()
>  평균 O(nlogn), 최악 O(nlogn)
> 삽입 정렬과 합병 정렬을 결합하여 사용

이래서 Collections.sort() 썼는데 Arrays.sort()가 더 빠르네.
이거 input 조건이 배열 1000개 2쌍이라서  nlogn 어지간한건 다 될텐데 잘 이해가 안 됨.
