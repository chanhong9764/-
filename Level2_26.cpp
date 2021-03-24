#include <string>
#include <vector>

using namespace std;

int solution(int bridge_length, int weight, vector<int> truck_weights) {
    int answer = 1;
    int total = 0;
    int size = truck_weights.size();
    vector<pair<int, int>> bridge;
    vector<int> complete;

    while (complete.size() != size)                         // 모든 트럭이 다리를 지나면 중단
    {
        total = 0;
        if(!bridge.empty() && !truck_weights.empty())       // 건너고 있는 트럭들의 중량 측정
        {
            for (auto c : bridge)
                total += c.second;
        }
        
        if(!truck_weights.empty())
        {
            if (total + truck_weights.front() <= weight)    // 다리에 있는 트럭과 대기 트럭의 합을 제한 중량과 비교
            {
                bridge.push_back(make_pair(1, truck_weights.front()));  
                truck_weights.erase(truck_weights.begin());
            }
        }
        for (auto &c : bridge)
        {
            if (c.first == bridge_length)                   // 트럭이 다리를 다 지나갔는지 확인하는 부분
            {
                complete.push_back(c.second);
                bridge.erase(bridge.begin());
            }
            c.first++;
        }
        answer++;
    }
    return answer;
}
