#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(int cacheSize, vector<string> cities) {
    int answer = 0;
    vector<string> cache;
     
    for(int i = 0; i < cities.size(); i++)
    {
        transform(cities[i].begin(), cities[i].end(), cities[i].begin(), ::tolower);    // 소문자 변환
        if(cache.empty() && cacheSize != 0)                                             // cache가 비어있거나 캐시크기가 0이면 무조건 miss
        {
            cache.push_back(cities[i]);
            answer += 5;
        }
        else 
        {
            auto f = find(cache.begin(),cache.end(),cities[i]);                         
            if(f == cache.end())                                                        // 도시가 캐시에 있는지 확인
            {
                if(cache.size() == cacheSize && cacheSize != 0)                         // 캐시가 꽉 차 있으면 가장 먼저 들어온 도시 삭제 후 최근 도시 삽입
                {
                    cache.erase(cache.begin());
                    cache.push_back(cities[i]);
                }
                else if(cacheSize != 0)                                                 // 캐시가 꽉 차지 않았으면 그대로 도시 삽입
                {
                    cache.push_back(cities[i]);
                }
                answer += 5;                                                            // 캐시는 경우이므로 miss
            }
            else
            {
                cache.erase(f);                                                         // hit한 경우 가장 최근에 참조 됐으므로 가장 맨 뒤로 다시 삽입
                cache.push_back(cities[i]);
                answer += 1;
            }
        }
    }
    
    return answer;
}
