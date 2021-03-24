#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> progresses, vector<int> speeds) {
    vector<int> answer;
    int count = 0;
    int size = progresses.size();
    while(!progresses.empty())
    {
        for(int i = 0; i < progresses.size(); i++)          // 작업 진도 증가
        {
            progresses[i] += speeds[i];
        }
        while(progresses.front() >= 100)                    // 작업 진도 맨 앞 체크
        {
            count++;                                        // 완료 횟수
            progresses.erase(progresses.begin());           // 완료 되어서 제거
            speeds.erase(speeds.begin());                   // 스피드도 같이 제거
            if(progresses.empty())
            {
                answer.push_back(count);
                break;
            }
            if(progresses.front() < 100){                   // 작업 진도가 100이하 이므로 정답에 push
                answer.push_back(count);
                count = 0;
            }
        }
    }
    
    return answer;
}
