날짜 : 2022-10-11

링크 : https://programmers.co.kr/learn/courses/30/lessons/17680

풀이 :
무난무난.

###페이징 교체 알고리즘
##### FIFO : First In First Out
> 가장 먼저 메모리에 올라온 페이지를 가장 먼저 내보내는 알고리즘.

##### LRU  : Least Recently Used
> 가장 오래전에 사용된 것을 제거.

##### LFU  : Least Frequently Used
> 참조 횟수가 가장 적은 페이지를 제거. 교체 대상이 여러개라면? 오랫동안 사용하지 않은 페이지를 제거.

##### MFU  : Most Frequently Used
> LFU와 반대로 참조 횟수가 가장 많은 페이즈를 교체.

##### OPT  : Optimal
> 앞으로 가장 오래 사용되지 않을 페이지를 예상해서 교체하는 알고리즘. 구현 거의 불가.
