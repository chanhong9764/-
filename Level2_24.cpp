#include <string>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;

int solution(vector<int> priorities, int location) {
    int answer = 0;
    queue<pair<int, int>> q;
    int count = 0;
    
    for(int i = 0; i < priorities.size(); i++)
    {
        q.push(make_pair(i,priorities[i]));                     // location을 파악하기 위해 pair 사용
    }
    while(1)
    {
        sort(priorities.begin(),priorities.end(),greater<>());  // 가장 큰 수를 찾기 위해 sort
        if(priorities[0] > q.front().second)                    // 우선 순위가 낮으면 뒤로
        {
            q.push(q.front());
            q.pop();
        }
        else                                                    // 우선 순위 가장 높거나 같으므로 count++
        {
            count++;
            if(q.front().first == location){                    // location이 같으면 정답
                answer = count;
                break;
            }
            q.pop();
            priorities.erase(priorities.begin());               // 우선 순위가 가장 높은 걸 제거
        }
    }
    
    return answer;
}
