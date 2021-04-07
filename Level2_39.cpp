#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<int> citations) {
    int answer = 0;
    int h = 0;
    int max = *max_element(citations.begin(),citations.end());  // vector에서 가장 큰 원소
    
    while(h != max + 1)                                         // h값은 max+1의 값을 넘을 수 없음
    {
        int count = 0;
        for(int i = 0; i < citations.size(); i++)
        {
            if(citations[i] >= h)                               // h번 이상 인용된 논문
            {
                count++;                                        // h번 이상 인용된 논문 개수
            }
        }
        if((count >= h) && (citations.size() - count <= h)){    // h번 이상, 이하 인용된 논문의 개수가 일치 하면 answer 
            answer = h;
        }
        h++;
    }
    return answer;
}
