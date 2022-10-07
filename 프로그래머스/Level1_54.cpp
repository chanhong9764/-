#include <iostream>
#include <algorithm>
#include <string>
#include <vector>

using namespace std;

int solution(vector<int> d, int budget) {
    int answer = 0;
    int total = 0;
    int i = 0;
    
    sort(d.begin(),d.end());                // 오름차순 정렬
    
    while(!(i > d.size() - 1))              // i가 d 사이즈보다 작을시 루프
    {
        total += d[i];                      // 각 부서 예산 더하기
        if(total > budget)                  // 예산 오바시 루프문 종료
            break;
        i++;
        answer++;                           // 부서 카운트 
    }
    
    return answer;
}
