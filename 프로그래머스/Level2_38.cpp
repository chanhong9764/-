#include <string>
#include <vector>
#include <algorithm>
#include <queue>

using namespace std;

int solution(vector<int> scoville, int K) {
    int answer = 0;
    int mix = 0;
    priority_queue<int,vector<int>,greater<int>> pq;
    
    for(auto c : scoville)                              // 우선 순위 큐에 원소 삽입
    {
        pq.push(c);   
    }
    while(pq.top() <= K && pq.size() != 1)              // 큐의 가장 작은 원소가 K보다 작을 때까지 반복
    {                                                   // 큐의 사이즈가 1이하면 안되는 조건도 포함
        mix = 0;                                        // 섞은 음식의 스코빌 지수
        mix += pq.top();
        pq.pop();
        mix += pq.top()*2;
        pq.pop();
        pq.push(mix);
        answer++;
    }
    if(pq.top() < K)                                     // 큐의 가장 작은 원소가 K보다 작을 시 -1  
        answer = -1;
    
    return answer;
}
